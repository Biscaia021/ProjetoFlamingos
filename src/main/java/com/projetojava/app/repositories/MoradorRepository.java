package com.projetojava.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projetojava.app.entidades.Morador;

@Repository
@Transactional
public interface MoradorRepository extends JpaRepository<Morador,Long>{
	
}
