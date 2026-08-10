package com.accenture.prueba.services.Itf;

import java.util.List;

import com.accenture.prueba.DTO.SucursalDTO;

public interface SucursalService {
    SucursalDTO crearSucursal(SucursalDTO sucursalDTO);
    List<SucursalDTO> obtenerSucursales();
    String actualizarNombreSucursal(Long id, String nuevoNombre);
}
