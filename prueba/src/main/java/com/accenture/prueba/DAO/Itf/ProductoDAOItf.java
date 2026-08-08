package com.accenture.prueba.DAO.Itf;

import java.util.List;

import com.accenture.prueba.models.Producto;

public interface ProductoDAOItf {
    public List<Producto> findByMaxProducto(Long idSucursal);
}
