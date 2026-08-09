package com.accenture.prueba.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.prueba.models.Franquicia;
import com.accenture.prueba.repositories.FranquiciaRepository;
import com.accenture.prueba.services.Itf.FranquiciaService;

@Service
public class FranquiciaServiceImp implements FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Override
    public Franquicia crearFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    @Override
    public List<Franquicia> obtenerFranquicias() {
        return franquiciaRepository.findAll();
    }

    @Override
    public String actualizarNombreFranquicia(Long id, String nuevoNombre) {
        Franquicia franquicia = franquiciaRepository.findById(id).orElse(null);
        if ( franquicia != null) {
            String oldNombre = franquicia.getNombre();
            franquicia.setNombre(nuevoNombre);
            franquiciaRepository.save(franquicia);
            return "se ha cambiado el nombre de la franquicia "+ oldNombre + " a " + nuevoNombre + "  correctamente";
        }
        return "Error al actualizar el nombre, Franquicia no encontrada";
    }
    

}
