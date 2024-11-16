package com.projetojava.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.app.entidades.Acess;
import com.projetojava.app.repositories.AcessRepository;

@Service
public class AcessService {
	
	@Autowired
	private AcessRepository ar;
	
	public AcessService(AcessRepository ar) {
		super();
		this.ar = ar;
	}

	public Acess registUser(String login, String password) {
		if(login ==null && password ==null) {
			return null;
		}
		else {
			Acess mod = new Acess();
			mod.setLogin(login);
			mod.setPassword(password);
			return ar.save(mod);
		}
	}
	
	public Acess autenticar(String login, String password) {
		return ar.findByLoginAndPassword(login, password).orElse(null);
	}

}
