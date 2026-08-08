package com.accenture.prueba.services.Itf;

import java.util.List;
import java.util.Map;

import com.accenture.prueba.models.Franquicia;

public interface FranquiciaService {
    Franquicia crearFranquicia(Franquicia franquicia);
    List<Franquicia> obtenerFranquicias();
    String actualizarNombreFranquicia(Map<String, String> params);
}
