package com.accenture.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.prueba.models.Franquicia;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {}
