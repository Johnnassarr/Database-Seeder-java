package com.banco.banco_digital.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.banco_digital.Encomenda;

public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {
}
