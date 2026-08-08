package com.accenture.prueba.services.Itf;

import java.util.List;
import java.util.Map;

import com.accenture.prueba.models.Sucursal;

public interface SucursalService {
    Sucursal crearSucursal(Map<String, String> params);
    List<Sucursal> obtenerSucursales();
    String actualizarNombreSucursal(Map<String, String> params);

}
