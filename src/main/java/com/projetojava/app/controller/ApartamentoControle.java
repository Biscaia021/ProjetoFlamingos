package com.projetojava.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projetojava.app.entidades.Apartamento;
import com.projetojava.app.repositories.ApartamentoRepository;
import com.projetojava.app.service.ApartamentoService;

@Controller
public class ApartamentoControle {

	@Autowired
	private ApartamentoService as;
	
	@Autowired
	private ApartamentoRepository ap;
	
	@RequestMapping(method=RequestMethod.POST, value="/cadapartamento")
	public String salvar(Apartamento apartamento) {
		ap.save(apartamento);
		return "/cadastro";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/buscarAloc")
	public String buscarAloc(Long id, Model model) {
		Optional<Apartamento> obj = ap.findById(id);
		System.out.println(obj.get());
		model.addAttribute("apartamentos", obj.get());
		return "/consulta";
	}
	@RequestMapping(method=RequestMethod.POST, value="/bsaloc")
	public String buscAloc(Long id, Model model) {
		Optional<Apartamento> obj = ap.findById(id);
		System.out.println(obj.get());
		model.addAttribute("aparts", obj.get());
		return "/deletar";
	}
	@GetMapping("/deleteAp/{id}")
	public String deleteAloc(@PathVariable(name="id") Long id){
		System.out.println("É dentro");
		as.delete(id);
		return "redirect:/deletar";
	}
	@RequestMapping(method=RequestMethod.POST, value="/bsalocatt")
	public String buscAlocAtt(Long id, Model model) {
		System.out.println("Funciona ? "+ id);
		Optional<Apartamento> obj = ap.findById(id);
		System.out.println(obj.get());
		model.addAttribute("aparts", obj.get());
		return "/atualizar2";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/busAlocAtt")
	public String buscarAlocAtt(Long id, Model model) {
		Optional<Apartamento> obj = ap.findById(id);
		System.out.println(obj.get());
		model.addAttribute("aparts", obj.get());
		model.addAttribute("ids", obj.get());
		return "/atualizar2";
	}
	@RequestMapping(method=RequestMethod.POST, value="/datupdate")
	public String update(Long id, Apartamento apartamento){
		System.out.println("É dentro");
		as.update(id, apartamento);
		return "redirect:/menu";
	}
	
}
