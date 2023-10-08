package br.edu.infnet.appmontadora.controller;

import br.edu.infnet.appmontadora.model.domain.Lote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmontadora.model.domain.Funcionario;
import br.edu.infnet.appmontadora.model.service.LoteService;
import br.edu.infnet.appmontadora.model.service.VeiculoService;
import br.edu.infnet.appmontadora.model.service.FabricaService;

@Controller
public class LoteController {
	
	@Autowired
	private LoteService loteService;
	@Autowired
	private FabricaService fabricaService;
	@Autowired
	private VeiculoService veiculoService;

	@GetMapping(value = "/pedido")
	public String telaCadastro(Model model, @SessionAttribute("user") Funcionario funcionario) {

		model.addAttribute("solicitantes", fabricaService.obterLista());

		model.addAttribute("produtos", veiculoService.obterLista());
		
		return "pedido/cadastro";
	}
	
	@GetMapping(value = "/pedido/lista")
	public String telaLista(Model model, @SessionAttribute("user") Funcionario funcionario) {
		model.addAttribute("listagem", loteService.obterLista(funcionario));

		return "pedido/lista";
	}
	
	@PostMapping(value = "/pedido/incluir")
	public String incluir(Lote lote, @SessionAttribute("user") Funcionario funcionario) {
		
		lote.setResponsavel(funcionario);

		loteService.incluir(lote);
		
		return "redirect:/pedido/lista";
	}

	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		loteService.excluir(id);
		
		return "redirect:/pedido/lista";
	}
}