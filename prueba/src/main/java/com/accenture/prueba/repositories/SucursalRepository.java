package com.accenture.prueba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.prueba.models.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

@Query("SELECT s FROM Sucursal s WHERE s.franquicia.id = :franquiciaId")
    List<Sucursal> findByFranquiciaId(@Param("franquiciaId") Long idFranquicia);
    
}
