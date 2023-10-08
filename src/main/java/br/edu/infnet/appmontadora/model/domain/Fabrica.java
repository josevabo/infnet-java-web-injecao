package br.edu.infnet.appmontadora.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tfabrica")
public class Fabrica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String endereco;
	@OneToMany
	@JoinColumn(name = "idFabrica")
	private List<Lote> lotes;
	@OneToMany
	@JoinColumn(name = "idFabrica")
	private List<Funcionario> funcionarios;
	
	public Fabrica() {

	}
	
	public Fabrica(Integer id) {
		this.id = id;
	}

	public Fabrica(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%s;%s", nome, endereco);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setUsuario(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}