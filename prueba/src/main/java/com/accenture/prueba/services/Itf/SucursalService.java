package com.accenture.prueba.services.Itf;

import java.util.List;

import com.accenture.prueba.DTO.SucursalDTO;
import com.accenture.prueba.models.Sucursal;

public interface SucursalService {
    Sucursal crearSucursal(SucursalDTO sucursalDTO);
    List<SucursalDTO> obtenerSucursales();
    String actualizarNombreSucursal(Long id, String nuevoNombre);
}
