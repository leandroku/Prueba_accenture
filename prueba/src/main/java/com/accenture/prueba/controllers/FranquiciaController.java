package com.accenture.prueba.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.prueba.models.Franquicia;
import com.accenture.prueba.services.Itf.FranquiciaService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    public List<Franquicia> getAllFranquicias() {
        return franquiciaService.obtenerFranquicias();
    }
    
    @PostMapping
    public Franquicia crearFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.crearFranquicia(franquicia);
    }

    @PatchMapping("/updateNombreFranquicia")
    @ResponseBody
    public String updateNombreFranquicia(@RequestBody Map<String, String> params) {
        return franquiciaService.actualizarNombreFranquicia(params);
    }

}
