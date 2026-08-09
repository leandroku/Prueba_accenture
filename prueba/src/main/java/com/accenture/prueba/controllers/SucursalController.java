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


    @RequestMapping(value = "/createSucursal", method = RequestMethod.POST)
    @ResponseBody
    public Sucursal createSucursal(@RequestBody Map<String, String> params) {
        return sucursalService.crearSucursal(params);
    }

    @PatchMapping("/updateNombreSucursal")
    @ResponseBody
    public String updateNombreSucursal(@RequestBody Map<String, String> params) {
        return sucursalService.actualizarNombreSucursal(params);
    }


}


