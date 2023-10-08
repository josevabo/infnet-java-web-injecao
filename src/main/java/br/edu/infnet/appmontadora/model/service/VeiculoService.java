package br.edu.infnet.appmontadora.model.service;

import java.util.Collection;

import br.edu.infnet.appmontadora.model.domain.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmontadora.model.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	public Collection<Veiculo> obterLista(){
		
		return (Collection<Veiculo>) veiculoRepository.findAll();
	}

	public void incluir(Veiculo veiculo) {

		veiculoRepository.save(veiculo);
	}
	
	public void excluir(Integer id) {

		veiculoRepository.deleteById(id);
	}	
}