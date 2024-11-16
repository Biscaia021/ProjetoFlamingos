package com.projetojava.app.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojava.app.entidades.Apartamento;
import com.projetojava.app.entidades.Morador;
import com.projetojava.app.service.ApartamentoService;

@RestController
@RequestMapping(value="/apartamentos")
public class ApartamentoResource {
	
	@Autowired
	private ApartamentoService server;
	
	@GetMapping
	public ResponseEntity<List<Apartamento>> findAll(){
		List<Apartamento> list = server.findAll();
		return ResponseEntity.ok().body(list); //EXPO
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Apartamento> findById(@PathVariable Long id){
		Apartamento obj = server.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		server.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<Apartamento> update(@PathVariable Long id,@RequestBody Apartamento obj){
		obj = server.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
