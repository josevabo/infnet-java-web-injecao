package br.edu.infnet.appmontadora.model.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.edu.infnet.appmontadora.model.domain.Lote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.appmontadora.model.domain.Funcionario;
import br.edu.infnet.appmontadora.model.repository.LoteRepository;

@Service
public class LoteService {
	
	@Autowired
	private LoteRepository loteRepository;

	public Collection<Lote> obterLista(){
		
		return (Collection<Lote>) loteRepository.findAll();
	}
	
	public Collection<Lote> obterLista(Funcionario funcionario){
		
		List<Lote> lista = loteRepository.obterLista(funcionario.getId());
		
		if(lista.isEmpty()) {
			return Collections.emptyList();
		}
		
		return lista;
	}

	public void incluir(Lote pedido) {

		loteRepository.save(pedido);
	}
	
	public void excluir(Integer id) {

		loteRepository.deleteById(id);
	}	
}