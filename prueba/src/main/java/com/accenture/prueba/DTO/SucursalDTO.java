package com.accenture.prueba.DTO;

import com.accenture.prueba.models.Sucursal;

public class SucursalDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean indActivo;
    private Long idFranquicia;

    public SucursalDTO(Sucursal sucursal) {
        this.id = sucursal.getId();
        this.nombre = sucursal.getNombre();
        this.descripcion = sucursal.getDescripcion();
        this.indActivo = sucursal.getIndActivo();
        this.idFranquicia = sucursal.getFranquicia().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(Boolean indActivo) {
        this.indActivo = indActivo;
    }

    public Long getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(Long idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    

}
