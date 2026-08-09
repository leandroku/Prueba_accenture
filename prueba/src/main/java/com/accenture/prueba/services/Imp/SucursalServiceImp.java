package com.accenture.prueba.services.Imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.prueba.DTO.SucursalDTO;
import com.accenture.prueba.models.Franquicia;
import com.accenture.prueba.models.Sucursal;
import com.accenture.prueba.repositories.FranquiciaRepository;
import com.accenture.prueba.repositories.SucursalRepository;
import com.accenture.prueba.services.Itf.SucursalService;

@Service
public class SucursalServiceImp implements SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Override
    public Sucursal crearSucursal(Map<String, String> params) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(params.get("nombre"));
        sucursal.setDescripcion(params.get("descripcion"));
        sucursal.setIndActivo((params.get("indActivo").equalsIgnoreCase("true")) ? true : false);
        Franquicia franquicia = franquiciaRepository.findById(Long.parseLong(params.get("franquicia")))
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        sucursal.setFranquicia(franquicia);
        return sucursalRepository.save(sucursal);
    }

    @Override
    public List<SucursalDTO> obtenerSucursales() {
        return sucursalRepository.findAll()
                .stream()
                .map(SucursalDTO::new)
                .toList();
    }

    @Override
    public String actualizarNombreSucursal(Map<String, String> params) {
        Sucursal sucursal = sucursalRepository.findById(Long.parseLong(params.get("id"))).orElse(null);
        if ( sucursal != null) {
            String oldNombre = sucursal.getNombre();
            sucursal.setNombre(params.get("nombre"));
            sucursalRepository.save(sucursal);
            return "se ha cambiado el nombre de la sucursal "+ oldNombre + " a " + params.get("nombre") + "  correctamente";
        }
        return "Error al actualizar el nombre, Sucursal no encontrada";
    }

}
