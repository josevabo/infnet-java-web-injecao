package br.edu.infnet.appmontadora.controller;

import br.edu.infnet.appmontadora.model.domain.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmontadora.model.service.VeiculoService;

@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;

	@GetMapping(value = "/veiculo/lista")
	public String telaLista(Model model) {

		model.addAttribute("listaVeiculo", veiculoService.obterLista());
		
		return "veiculo/lista";
	}

	@GetMapping(value = "/veiculo/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		veiculoService.excluir(id);

		return "redirect:/veiculo/lista";
	}
}