package br.edu.infnet.appmontadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmontadora.model.domain.Carro;
import br.edu.infnet.appmontadora.model.domain.Funcionario;
import br.edu.infnet.appmontadora.model.service.CarroService;

@Controller
public class CarroController {
	
	@Autowired
	private CarroService carroService;

	@GetMapping(value = "/carro/lista")
	public String telaLista(Model model, @SessionAttribute("user") Funcionario funcionario) {

		model.addAttribute("listaCarro", carroService.obterLista());
		
		return "carro/lista";
	}

	@GetMapping(value = "/carro/cadastro")
	public String telaCadastro() {

		return "carro/cadastro";
	}

	@PostMapping(value = "/carro/incluir")
	public String incluir(Carro carro, @SessionAttribute("user") Funcionario funcionario) {
		
		carroService.incluir(carro);
		
		return "redirect:/carro/lista";
	}

	@GetMapping(value = "/carro/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		carroService.excluir(id);

		return "redirect:/carro/lista";
	}
}