package com.accenture.prueba.services.Itf;

import java.util.List;
import java.util.Map;

import com.accenture.prueba.DTO.ProductoDTO;
import com.accenture.prueba.models.Producto;

import reactor.core.publisher.Flux;

public interface ProductoService {
    Flux<ProductoDTO> getAllProductos();
    Producto crearProducto(ProductoDTO productoDTO);
    boolean eliminarProducto(Long id);
    String actualizarStockProducto(Long id, int nuevoStock);
    List<Map<String,String>> getMaxStockProductoSucursal(Long id);
    String actualizarNombreProducto(Long id, String nuevoNombre);
}
