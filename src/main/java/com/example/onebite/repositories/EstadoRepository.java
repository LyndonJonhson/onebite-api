package com.example.onebite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onebite.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
