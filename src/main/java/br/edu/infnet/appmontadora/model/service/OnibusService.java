package br.edu.infnet.appmontadora.model.service;

import java.util.Collection;

import br.edu.infnet.appmontadora.model.domain.Onibus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmontadora.model.repository.OnibusRepository;

@Service
public class OnibusService {
	
	@Autowired
	private OnibusRepository onibusRepository;

	public Collection<Onibus> obterLista(){
		
		return (Collection<Onibus>) onibusRepository.findAll();
	}

	public void incluir(Onibus onibus) {

		onibusRepository.save(onibus);
	}
	
	public void excluir(Integer id) {

		onibusRepository.deleteById(id);
	}	
}