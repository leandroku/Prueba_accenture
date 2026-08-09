package com.accenture.prueba.services.Imp;

import java.util.List;

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
    public Sucursal crearSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalDTO.getNombre());
        sucursal.setDescripcion(sucursalDTO.getDescripcion());
        sucursal.setIndActivo(sucursalDTO.getIndActivo());
        Franquicia franquicia = franquiciaRepository.findById(sucursalDTO.getIdFranquicia())
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
    public String actualizarNombreSucursal(Long id, String nuevoNombre) {
        Sucursal sucursal = sucursalRepository.findById(id).orElse(null);
        if ( sucursal != null) {
            String oldNombre = sucursal.getNombre();
            sucursal.setNombre(nuevoNombre);
            sucursalRepository.save(sucursal);
            return "se ha cambiado el nombre de la sucursal "+ oldNombre + " a " + nuevoNombre + "  correctamente";
        }
        return "Error al actualizar el nombre, Sucursal no encontrada";
    }

}
