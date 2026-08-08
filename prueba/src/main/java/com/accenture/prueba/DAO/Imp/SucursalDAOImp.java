package com.accenture.prueba.DAO.Imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.accenture.prueba.DAO.Itf.SucursalDAOItf;
import com.accenture.prueba.models.Sucursal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class SucursalDAOImp implements SucursalDAOItf {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Sucursal> findByFranquiciaId(Long idFranquicia) {
        try {
            TypedQuery<Sucursal> query = entityManager.createQuery ("SELECT s "
            + "FROM Sucursal s "
            + "WHERE s.franquicia.id = :franquiciaId ", Sucursal.class);
            query.setParameter("franquiciaId", idFranquicia);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
