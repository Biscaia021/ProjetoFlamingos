package com.projetojava.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojava.app.entidades.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Long>{
	

}
