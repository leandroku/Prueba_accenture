package com.accenture.prueba.services.Itf;

import java.util.List;
import java.util.Map;

import com.accenture.prueba.DTO.ProductoDTO;
import com.accenture.prueba.models.Producto;

import reactor.core.publisher.Flux;

public interface ProductoService {
    Flux<ProductoDTO> getAllProductos();
    Producto crearProducto(Map<String, String> params);
    boolean eliminarProducto(Long id);
    String actualizarStockProducto(Map<String, String> params);
    List<Map<String,String>> getMaxStockProductoSucursal(Long id);
    String actualizarNombreProducto(Map<String, String> params);
}
