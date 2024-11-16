package com.projetojava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projetojava.app.entidades.Acess;
import com.projetojava.app.service.AcessService;

@Controller
public class AcessControle {
	
	@Autowired
	private AcessService as;	
	
	@GetMapping(value="/login")
	public String getLoginPage(Model model) {
		model.addAttribute("LoginRequisicao", new Acess());
		return "index";
	}
	
	@PostMapping(value="/login")
	public String Login(@ModelAttribute Acess acess) {
		System.out.println("Login requisição: " + acess);
		Acess autenticar = as.autenticar(acess.getLogin(), acess.getPassword());
		if(autenticar != null){
			return "menu";
		}
		else {
			return "index";
		}
	}
	
	@GetMapping(value="/registro")
    public String getRegisterPage(Model model) {
        model.addAttribute("CadastroRequisicao", new Acess());
        return "reg";
    }

    @PostMapping(value="/registro")
    public String Registro(@ModelAttribute Acess acess) {
        System.out.println("Cadastro requisicao: " + acess);
        Acess usuarioRegistrado = as.registUser(acess.getLogin(), acess.getPassword());
        return usuarioRegistrado == null ? "error" : "redirect:/login";
    }
}
