package com.projetojava.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojava.app.entidades.Financeiro;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro,Long>{
	

}
