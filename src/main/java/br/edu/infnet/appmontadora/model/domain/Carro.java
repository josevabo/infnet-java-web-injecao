package br.edu.infnet.appmontadora.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tcarro")
public class Carro extends Veiculo {
	private int cilindrada;
	private boolean cambioAutomatico;
	private boolean arCondicionado;
	private String tipoDirecao;
	private boolean eletrico;
	
	public Carro() {

	}
	
	public Carro(Integer id) {
		super(id);
	}

	public Carro(String modelo, float custo, int cilindrada, boolean cambioAutomatico, boolean arCondicionado, String tipoDirecao, boolean eletrico) {
		super(modelo, custo);
		this.cilindrada = cilindrada;
		this.cambioAutomatico = cambioAutomatico;
		this.arCondicionado = arCondicionado;
		this.tipoDirecao = tipoDirecao;
		this.eletrico = eletrico;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%.2f;%s;%s", 
				super.toString(),
				cilindrada,
				cambioAutomatico,
				arCondicionado,
				tipoDirecao,
				eletrico
			);
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public boolean isCambioAutomatico() {
		return cambioAutomatico;
	}

	public void setCambioAutomatico(boolean cambioAutomatico) {
		this.cambioAutomatico = cambioAutomatico;
	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public String getTipoDirecao() {
		return tipoDirecao;
	}

	public void setTipoDirecao(String tipoDirecao) {
		this.tipoDirecao = tipoDirecao;
	}

	public boolean isEletrico() {
		return eletrico;
	}

	public void setEletrico(boolean eletrico) {
		this.eletrico = eletrico;
	}
}