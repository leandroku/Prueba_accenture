package com.accenture.prueba.DTO;

import com.accenture.prueba.models.Franquicia;

public class FranquiciaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean indActivo;

    public FranquiciaDTO() {}

    public FranquiciaDTO(Franquicia franquicia) {
        this.id = franquicia.getId();
        this.nombre = franquicia.getNombre();
        this.descripcion = franquicia.getDescripcion();
        this.indActivo = franquicia.getIndActivo();
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

}
