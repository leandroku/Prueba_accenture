package com.accenture.prueba.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.prueba.services.Itf.FranquiciaService;
import com.accenture.prueba.DTO.FranquiciaDTO;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/franquicia")
public class FranquiciaController {
    private final FranquiciaService franquiciaService;

    
    public FranquiciaController(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @GetMapping()
    public List<FranquiciaDTO> getAllFranquicias() {
        return franquiciaService.obtenerFranquicias();
    }
    
    @PostMapping
    public FranquiciaDTO crearFranquicia(@RequestBody FranquiciaDTO franquicia) {
        return franquiciaService.crearFranquicia(franquicia);
    }

    @PatchMapping("/{id}/nombre")
    @ResponseBody
    public String updateNombreFranquicia(@PathVariable Long id, @RequestBody String nuevoNombre) {
        return franquiciaService.actualizarNombreFranquicia(id, nuevoNombre);
    }

}
