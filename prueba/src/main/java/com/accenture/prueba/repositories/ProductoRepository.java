package com.accenture.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.prueba.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}