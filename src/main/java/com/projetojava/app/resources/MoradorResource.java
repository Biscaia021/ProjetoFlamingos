package com.projetojava.app.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetojava.app.entidades.Morador;
import com.projetojava.app.service.MoradorService;

@RestController
@RequestMapping(value="/moradores")
public class MoradorResource {
	
	@Autowired
	private MoradorService server;
	
	@GetMapping
	public ResponseEntity<List<Morador>> findAll(){
		List<Morador> list = server.findAll();
		return ResponseEntity.ok().body(list); //EXPO
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Morador> findById(@PathVariable Long id){
		Morador obj = server.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Morador> insert(@RequestBody Morador obj){
		obj = server.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		server.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Morador> update(@PathVariable Long id,@RequestBody Morador obj){
		obj = server.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
