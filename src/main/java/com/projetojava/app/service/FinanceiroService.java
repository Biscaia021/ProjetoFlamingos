package com.projetojava.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.app.entidades.Financeiro;
import com.projetojava.app.repositories.FinanceiroRepository;

@Service	
public class FinanceiroService {
	
	@Autowired
	private FinanceiroRepository fr;
	
	public List<Financeiro> findAll(){
		return fr.findAll();
	}
	
	public Financeiro findById(Long id){
			Optional<Financeiro> obj = fr.findById(id);
			return obj.get();
	}
	
	public Financeiro insert(Financeiro obj) {
		return fr.save(obj);
	}
}
