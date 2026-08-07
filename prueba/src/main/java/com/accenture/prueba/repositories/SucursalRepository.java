package com.accenture.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.prueba.models.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {}
