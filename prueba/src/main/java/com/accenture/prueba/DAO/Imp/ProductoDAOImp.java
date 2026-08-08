package com.accenture.prueba.DAO.Imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.accenture.prueba.models.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class ProductoDAOImp {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Producto> findByMaxProducto(Long idSucursal){
        try{
            TypedQuery<Producto> query = entityManager.createQuery("SELECT p "
                +"FROM Producto p "
                +"WHERE p.sucursal.id = :idSucursal ", Producto.class);
            query.setParameter("idSucursal", idSucursal);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
