package com.projetojava.app.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojava.app.entidades.Pagamento;
import com.projetojava.app.service.PagamentoService;

@RestController
@RequestMapping(value="/pagamentos")
public class PagamentoResource {
	
	@Autowired
	private PagamentoService server;
	
	@GetMapping
	public ResponseEntity<List<Pagamento>> findAll(){
		List<Pagamento> list = server.findAll();
		return ResponseEntity.ok().body(list); //EXPO
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Pagamento> findById(@PathVariable Long id){
		Pagamento obj = server.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
