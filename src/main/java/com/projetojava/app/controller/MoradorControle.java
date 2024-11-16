package com.projetojava.app.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projetojava.app.entidades.Morador;
import com.projetojava.app.repositories.MoradorRepository;
import com.projetojava.app.service.MoradorService;

@Controller
public class MoradorControle {
	@Autowired
	private MoradorRepository mr;
	
	@Autowired
	private MoradorService ms;
	
	@RequestMapping(method=RequestMethod.GET, value="/cadastro")
	public String inicio() {
		return "/cadastro";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cadmorador")
	public String salvar(Morador morador) {
		mr.save(morador);
		return "/cadastro";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/buscarMorador")
	public String buscarMorador(Long id, Model model) {
		Optional<Morador> obj = mr.findById(id);
		System.out.println(obj.get());
		model.addAttribute("moradores", obj.get());
		return "/consulta";
		
	}
	@RequestMapping(method=RequestMethod.POST, value="/buscarMoradorDel")
	public String buscMor(Long id, Model model) {
		Optional<Morador> obj = mr.findById(id);
		System.out.println(obj.get());
		model.addAttribute("moradores", obj.get());
		return "/deletar";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") Long id){
		System.out.println("É dentro");
		ms.delete(id);
		return "redirect:/deletar";
	}
	

	@RequestMapping(method=RequestMethod.POST, value="/busMorAtt")
	public String buscarMoradorAtt(Long id, Model model) {
		Optional<Morador> obj = mr.findById(id);
		System.out.println(obj.get());
		model.addAttribute("moradores", obj.get());
		model.addAttribute("ids", obj.get());
		return "/atualizar";
	}
	@RequestMapping(method=RequestMethod.POST, value="/dataupdate")
	public String update(Long id, Morador morador){
		System.out.println("É dentro");
		ms.update(id, morador);
		return "redirect:/menu";
	}
	
}
