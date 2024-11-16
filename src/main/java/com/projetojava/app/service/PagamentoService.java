package com.projetojava.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.app.entidades.Pagamento;
import com.projetojava.app.repositories.PagamentoRepository;

@Service	
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository fr;
	
	public List<Pagamento> findAll(){
		return fr.findAll();
	}
	
	public Pagamento findById(Long id){
			Optional<Pagamento> obj = fr.findById(id);
			return obj.get();
	}
	
	public Pagamento insert(Pagamento obj) {
		return fr.save(obj);
	}
}
