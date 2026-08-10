package com.accenture.prueba.services.Itf;

import java.util.List;

import com.accenture.prueba.DTO.FranquiciaDTO;

public interface FranquiciaService {
    FranquiciaDTO crearFranquicia(FranquiciaDTO franquicia);
    List<FranquiciaDTO> obtenerFranquicias();
    String actualizarNombreFranquicia(Long id, String nuevoNombre);
}
