package br.edu.infnet.appmontadora.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tsobremesa")
public class Caminhao extends Veiculo {
	private int eixos;
	private float cargaMaxima;
	private int comprimento;
	
	public Caminhao() {

	}
	
	public Caminhao(Integer id) {
		super(id);
	}

	public Caminhao(String modelo, float custo, int eixos, float cargaMaxima, int comprimento) {
		super(modelo, custo);
		this.eixos = eixos;
		this.cargaMaxima = cargaMaxima;
		this.comprimento = comprimento;
	}

	@Override
	public String toString() {
		return String.format("%s;%.2f;%s;%s", 
				super.toString(),
				eixos,
				cargaMaxima,
				comprimento
			);
	}

	public int getEixos() {
		return eixos;
	}

	public void setEixos(int eixos) {
		this.eixos = eixos;
	}

	public float getCargaMaxima() {
		return cargaMaxima;
	}

	public void setCargaMaxima(float cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}

	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}
}