package br.edu.infnet.appmontadora.controller;

import br.edu.infnet.appmontadora.model.domain.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appmontadora.model.service.FuncionarioService;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping(value = "/valida")
	public String validar(Model model, @RequestParam String email, @RequestParam String senha) {

		Funcionario user = funcionarioService.validar(email, senha);
		
		if(user != null) {
			
			model.addAttribute("user", user);

			return "home";
		}
		return "redirect:/login";		
	}	
	
	@GetMapping(value = "/funcionario/lista")
	public String telaLista(Model model) {

		model.addAttribute("listaFuncionarios", funcionarioService.obterLista());
		
		return "funcionario/lista";
	}

	@GetMapping(value = "/funcionario/cadastro")
	public String telaCadastro() {

		return "funcionario/cadastro";
	}

	@PostMapping(value = "/funcionario/incluir")
	public String incluir(Funcionario funcionario) {

		funcionarioService.incluir(funcionario);
		
		return "redirect:/";
	}

	@GetMapping(value = "/funcionario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		funcionarioService.excluir(id);

		return "redirect:/funcionario/lista";
	}
}