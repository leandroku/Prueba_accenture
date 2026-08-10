package com.accenture.prueba.services.Itf;

import java.util.List;
import java.util.Map;

import com.accenture.prueba.DTO.ProductoDTO;

import reactor.core.publisher.Flux;

public interface ProductoService {
    Flux<ProductoDTO> getAllProductos();
    ProductoDTO crearProducto(ProductoDTO productoDTO);
    boolean eliminarProducto(Long id);
    String actualizarStockProducto(Long id, int nuevoStock);
    List<Map<String,String>> getMaxStockProductoSucursal(Long id);
    String actualizarNombreProducto(Long id, String nuevoNombre);
}
