package com.projetojava.app.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojava.app.entidades.Financeiro;
import com.projetojava.app.service.FinanceiroService;

@RestController
@RequestMapping(value="/financas")
public class FinanceiroResource {
	
	@Autowired
	private FinanceiroService server;
	
	@GetMapping
	public ResponseEntity<List<Financeiro>> findAll(){
		List<Financeiro> list = server.findAll();
		return ResponseEntity.ok().body(list); //EXPO
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Financeiro> findById(@PathVariable Long id){
		Financeiro obj = server.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
