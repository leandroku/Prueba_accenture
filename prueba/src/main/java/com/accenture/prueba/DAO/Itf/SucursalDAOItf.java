package com.accenture.prueba.DAO.Itf;

import java.util.List;

import com.accenture.prueba.models.Sucursal;

public interface SucursalDAOItf {

    public List<Sucursal> findByFranquiciaId(Long idFranquicia);

}
