package com.example.onebite.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onebite.domain.model.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

}
