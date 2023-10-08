package br.edu.infnet.appmontadora.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tlote")
public class Lote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime data;
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idFabrica")
	private Fabrica fabrica;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Veiculo> veiculos;
	@ManyToOne
	@JoinColumn(name = "idResponsavel")
	private Funcionario responsavel;
	
	public Lote() {
		data = LocalDateTime.now();
		veiculos = new ArrayList<>();
	}

	public Lote(Fabrica fabrica, List<Veiculo> veiculos, Funcionario responsavel) {
		this();
		this.fabrica = fabrica;
		this.veiculos = veiculos;
		this.responsavel = responsavel;
	}
	
	@Override
	public String toString() {
		return data + ";" + fabrica + ";" + responsavel + ";" + veiculos.size();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Fabrica getFabrica() {
		return fabrica;
	}

	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public void incluiVeiculo(Veiculo veiculo){
		this.veiculos.add(veiculo);
	}

}