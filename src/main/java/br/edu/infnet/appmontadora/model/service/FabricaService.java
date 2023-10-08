package br.edu.infnet.appmontadora.model.service;

import java.util.Collection;

import br.edu.infnet.appmontadora.model.domain.Fabrica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmontadora.model.domain.Funcionario;
import br.edu.infnet.appmontadora.model.repository.FabricaRepository;

@Service
public class FabricaService {
	
	@Autowired
	private FabricaRepository fabricaRepository;

	public Collection<Fabrica> obterLista(){
		
		return (Collection<Fabrica>) fabricaRepository.findAll();
	}

	public void incluir(Fabrica solicitante) {

		fabricaRepository.save(solicitante);
	}
	
	public void excluir(Integer id) {

		fabricaRepository.deleteById(id);
	}	
}