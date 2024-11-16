package com.projetojava.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.app.entidades.Morador;
import com.projetojava.app.repositories.MoradorRepository;

@Service	
public class MoradorService {
	
	@Autowired
	private MoradorRepository mr;
	
	public List<Morador> findAll(){
		return mr.findAll();
	}
	
	public Morador findById(Long id){
			Optional<Morador> obj = mr.findById(id);
			return obj.get();
	}
	
	public Morador insert(Morador obj) {
		return mr.save(obj);
	}
	
	public void delete(Long id) {
			mr.deleteById(id);
	}
	
	public Morador update(Long id,Morador obj) {
		Morador entity = mr.getReferenceById(id);
		updateData(entity,obj);
		return mr.save(entity);
	}
	private void updateData(Morador entity, Morador obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setCpf(obj.getCpf());
		entity.setTelefone(obj.getTelefone());
		entity.setInicio(obj.getInicio());
		entity.setTermino(obj.getTermino());
	}
}
