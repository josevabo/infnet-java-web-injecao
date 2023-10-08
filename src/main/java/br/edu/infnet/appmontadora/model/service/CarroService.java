package br.edu.infnet.appmontadora.model.service;

import java.util.Collection;

import br.edu.infnet.appmontadora.model.domain.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmontadora.model.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;

	public Collection<Carro> obterLista(){
		
		return (Collection<Carro>) carroRepository.findAll();
	}

	public void incluir(Carro carro) {

		carroRepository.save(carro);
	}
	
	public void excluir(Integer id) {

		carroRepository.deleteById(id);
	}	
}