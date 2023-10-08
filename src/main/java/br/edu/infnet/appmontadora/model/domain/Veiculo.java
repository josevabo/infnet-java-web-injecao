package br.edu.infnet.appmontadora.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tveiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String modelo;
	private float custo;
	@ManyToMany(mappedBy = "veiculos")
	private List<Lote> lotes;

	public Veiculo() {

	}
	
	public Veiculo(Integer id) {
		this.id = id;
	}
	
	public Veiculo(String modelo, float custo) {
		this.modelo = modelo;
		this.custo = custo;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%.2f;%d", modelo, custo);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		this.custo = custo;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

}