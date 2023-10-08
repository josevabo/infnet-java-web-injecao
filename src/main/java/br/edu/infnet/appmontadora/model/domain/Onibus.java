package br.edu.infnet.appmontadora.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TOnibus")
public class Onibus extends Veiculo {

	private int assentos;
	private int capacidadeTotal;
	private boolean acessivelCadeirantes;
	
	public Onibus() {

	}
	
	public Onibus(Integer id) {
		super(id);
	}

	public Onibus(String modelo, float custo, int assentos, int capacidadeTotal, boolean acessivelCadeirantes) {
		super(modelo, custo);
		this.assentos = assentos;
		this.capacidadeTotal = capacidadeTotal;
		this.acessivelCadeirantes = acessivelCadeirantes;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%s;%.2f;%s", 
				super.toString(),
				assentos,
				capacidadeTotal,
				acessivelCadeirantes
			);
	}

	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}

	public int getCapacidadeTotal() {
		return capacidadeTotal;
	}

	public void setCapacidadeTotal(int capacidadeTotal) {
		this.capacidadeTotal = capacidadeTotal;
	}

	public boolean isAcessivelCadeirantes() {
		return acessivelCadeirantes;
	}

	public void setAcessivelCadeirantes(boolean acessivelCadeirantes) {
		this.acessivelCadeirantes = acessivelCadeirantes;
	}
}