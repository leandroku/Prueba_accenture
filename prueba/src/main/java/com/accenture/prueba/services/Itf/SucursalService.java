package com.accenture.prueba.services.Itf;

import java.util.List;
import java.util.Map;

import com.accenture.prueba.DTO.SucursalDTO;
import com.accenture.prueba.models.Sucursal;

public interface SucursalService {
    Sucursal crearSucursal(Map<String, String> params);
    List<SucursalDTO> obtenerSucursales();
    String actualizarNombreSucursal(Map<String, String> params);

}
