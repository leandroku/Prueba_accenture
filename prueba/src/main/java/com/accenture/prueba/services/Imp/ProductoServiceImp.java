package com.accenture.prueba.services.Imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.prueba.DTO.ProductoDTO;
import com.accenture.prueba.models.Producto;
import com.accenture.prueba.models.Sucursal;
import com.accenture.prueba.repositories.ProductoRepository;
import com.accenture.prueba.repositories.SucursalRepository;
import com.accenture.prueba.services.Itf.ProductoService;

import reactor.core.publisher.Flux;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public Flux<ProductoDTO> getAllProductos() {
        List<Producto> productoList = productoRepository.findAll();
        return Flux.fromIterable(productoList)
                .map(ProductoDTO::new);
    }

    @Override
    public Producto crearProducto(Map<String, String> params) {
        Producto producto = new Producto();
        producto.setNombre(params.get("nombre"));
        producto.setDescripcion(params.get("descripcion"));
        producto.setPrecio(Double.parseDouble(params.get("precio")));
        producto.setStock(Integer.parseInt(params.get("stock")));
        producto.setIndActivo(Boolean.parseBoolean(params.get("indActivo")));

        Sucursal sucursal = sucursalRepository.findById(Long.parseLong(params.get("sucursal"))).orElse(null);
        producto.setSucursal(sucursal);

        return productoRepository.save(producto);
    }

    @Override
    public boolean eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public String actualizarStockProducto(Map<String, String> params) {
        Producto producto = productoRepository.findById(Long.parseLong(params.get("id"))).orElse(null);
        if (producto != null) {
            producto.setStock(Integer.parseInt(params.get("stock")));
            productoRepository.save(producto);
            return "Stock actualizado correctamente";
        }
        return "Error al actualizar el stock, Producto no encontrado";
    }

    @Override
    public List<Map<String, String>> getMaxStockProductoSucursal(Long id) {
        List<Map<String, String>> maxStockProductos = new ArrayList<>();
        List<Sucursal> sucursalList = sucursalRepository.findByFranquiciaId(id);
        if (sucursalList != null && !sucursalList.isEmpty()) {
            for(Sucursal sucursal : sucursalList){
                List<Producto> productoList = productoRepository.findByMaxProducto(sucursal.getId());
                if (productoList != null && !productoList.isEmpty()) {
                    int maxStrock = productoList.stream()
                    .mapToInt(Producto::getStock)
                    .max()
                    .orElse(0);

                    List<Producto> maxProductoList = productoList.stream()
                    .filter(producto -> producto.getStock() == maxStrock)
                    .collect(Collectors.toList());

                    for(Producto producto : maxProductoList){
                        Map<String, String> productoInfo = Map.of(
                            "sucursal", sucursal.getNombre(),
                            "producto", producto.getNombre(),
                            "stock", String.valueOf(producto.getStock())
                        );
                        maxStockProductos.add(productoInfo);
                    }          
                }                  
            }
        }        
        return maxStockProductos;
    }

    @Override
    public String actualizarNombreProducto(Map<String, String> params) {
        Producto producto = productoRepository.findById(Long.parseLong(params.get("id"))).orElse(null);
        if ( producto != null) {
            String oldNombre = producto.getNombre();
            producto.setNombre(params.get("nombre"));
            productoRepository.save(producto);
            return "se ha cambiado el nombre del producto "+ oldNombre + " a " + params.get("nombre") + "  correctamente";
        }
        return "Error al actualizar el nombre, Producto no encontrado";
    }

}
