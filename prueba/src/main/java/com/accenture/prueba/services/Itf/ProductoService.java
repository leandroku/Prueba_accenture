package com.accenture.prueba.services.Itf;

import java.util.List;
import java.util.Map;

import com.accenture.prueba.models.Producto;

public interface ProductoService {
    List<Producto> getAllProductos();
    Producto crearProducto(Map<String, String> params);
    boolean eliminarProducto(Long id);
    String actualizarStockProducto(Map<String, String> params);
    List<Map<String,String>> getMaxStockProductoSucursal(Long id);
    String actualizarNombreProducto(Map<String, String> params);
}
