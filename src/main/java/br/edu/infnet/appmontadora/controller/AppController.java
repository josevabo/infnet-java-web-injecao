package br.edu.infnet.appmontadora.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.appmontadora.model.domain.Funcionario;
import br.edu.infnet.appmontadora.model.service.FuncionarioService;

@SessionAttributes("user")
@Controller
public class AppController {
	
	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping(value = "/")
	public String telaHome() {
		return "home";
	}
	
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		
		Funcionario funcionario = funcionarioService.validar(email, senha);
		
		if(funcionario != null) {
			
			model.addAttribute("user", funcionario);
			
			return "home";
		}
		
		return "login";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		
		status.setComplete();
		
		session.removeAttribute("user");
		
		return "redirect:/";
	}
}