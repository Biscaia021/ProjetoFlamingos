package com.projetojava.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojava.app.entidades.Apartamento;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento,Long>{
	

}
