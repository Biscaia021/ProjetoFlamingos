package com.projetojava.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteControle {
	
	
	
	
	//--------------
	//menu
	
	@GetMapping("/menu")
	public String Menu(Model model) {
		
		return "menu";
	}
	@GetMapping("/stylemenu")
	public String StyleMem() {
		return "menu";
	}
	@GetMapping("/deletar")
	public String deletar(Model model) {
		
		return "deletar";
	}
	@GetMapping("/styleDel")
	public String StyleDel() {
		return "deletar";
	}
	@GetMapping("/atualizar")
	public String atualizar(Model model) {
		
		return "atualizar";
	}
	
	@GetMapping("/atualizar2")
	public String atualizar2(Model model) {
		
		return "atualizar2";
	}

	@GetMapping("/consulta")
	public String consulta(Model model) {
		
		return "consulta";
	}
}