package br.edu.infnet.appmontadora.controller;

import br.edu.infnet.appmontadora.model.domain.Fabrica;
import br.edu.infnet.appmontadora.model.domain.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmontadora.model.service.FabricaService;

@Controller
public class FabricaController {
	
	@Autowired
	private FabricaService fabricaService;
	
	@GetMapping(value = "/fabrica/lista")
	public String telaLista(Model model, @SessionAttribute("user") Funcionario funcionario) {
		model.addAttribute("listagem", fabricaService.obterLista());

		return "fabrica/lista";
	}
	
	@GetMapping(value = "/fabrica")
	public String telaCadastro() {
		return "fabrica/cadastro";
	}

	@PostMapping(value = "/fabrica/incluir")
	public String incluir(Fabrica fabrica, @SessionAttribute("user") Funcionario funcionario) {

		fabricaService.incluir(fabrica);
		
		return "redirect:/fabrica/lista";
	}
	
	@GetMapping(value = "/fabrica/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		fabricaService.excluir(id);
		
		return "redirect:/fabrica/lista";
	}
}