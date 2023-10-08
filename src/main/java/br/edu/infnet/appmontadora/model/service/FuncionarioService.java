package br.edu.infnet.appmontadora.model.service;

import java.util.Collection;

import br.edu.infnet.appmontadora.model.domain.Fabrica;
import br.edu.infnet.appmontadora.model.domain.Funcionario;
import br.edu.infnet.appmontadora.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Collection<Funcionario> obterLista(){

		return (Collection<Funcionario>) funcionarioRepository.findAll();
	}
	public Collection<Funcionario> obterLista(Fabrica fabrica){

		return (Collection<Funcionario>) funcionarioRepository.listByFabrica(fabrica.getId());
	}
	
	public void incluir(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	
	public void excluir(Integer id) {
		
		funcionarioRepository.deleteById(id);
	}

	public Funcionario validar(String email, String senha) {

		Funcionario funcionario = funcionarioRepository.findByEmail(email);

		if(funcionario != null && senha.equals(funcionario.getSenha())) {
			return funcionario;
		}

		return null;
	}

}