package com.example.onebite.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onebite.domain.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
