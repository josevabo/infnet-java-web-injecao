package br.edu.infnet.appmontadora.model.service;

import br.edu.infnet.appmontadora.model.domain.Fabrica;
import br.edu.infnet.appmontadora.model.domain.Cargo;
import br.edu.infnet.appmontadora.model.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	public Collection<Cargo> obterLista(){

		return (Collection<Cargo>) cargoRepository.findAll();
	}
	
	public void incluir(Cargo cargo) {
		
		cargoRepository.save(cargo);
	}

}