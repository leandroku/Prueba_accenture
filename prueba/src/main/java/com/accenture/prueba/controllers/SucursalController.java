package com.accenture.prueba.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.prueba.DTO.SucursalDTO;
import com.accenture.prueba.models.Sucursal;
import com.accenture.prueba.services.Itf.SucursalService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping("/sucursal")
public class SucursalController {
    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping()
    public List<SucursalDTO> getAllSucursales() {
        return sucursalService.obtenerSucursales();
    }
        
    @PostMapping()
    public Sucursal createSucursal(@RequestBody SucursalDTO sucursalDTO) {
        return sucursalService.crearSucursal(sucursalDTO);
    }

    @PatchMapping("/{id}/nombre")
    @ResponseBody
    public String updateNombreSucursal(@PathVariable Long id, @RequestBody String nuevoNombre) {
        return sucursalService.actualizarNombreSucursal(id, nuevoNombre);
    }


}


