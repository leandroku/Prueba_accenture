package com.accenture.prueba.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.prueba.DTO.FranquiciaDTO;
import com.accenture.prueba.models.Franquicia;
import com.accenture.prueba.repositories.FranquiciaRepository;
import com.accenture.prueba.services.Itf.FranquiciaService;

@Service
public class FranquiciaServiceImp implements FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Override
    public FranquiciaDTO crearFranquicia(FranquiciaDTO franquicia) {
        Franquicia franquiciaModel = new Franquicia();
        franquiciaModel.setNombre(franquicia.getNombre());
        franquiciaModel.setDescripcion(franquicia.getDescripcion());
        franquiciaModel.setIndActivo(franquicia.getIndActivo());

        Franquicia savedFranquicia = franquiciaRepository.save(franquiciaModel);
        return new FranquiciaDTO(savedFranquicia);
    }

    @Override
    public List<FranquiciaDTO> obtenerFranquicias() {
        return franquiciaRepository.findAll().stream()
                .map(FranquiciaDTO::new)
                .toList();
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
