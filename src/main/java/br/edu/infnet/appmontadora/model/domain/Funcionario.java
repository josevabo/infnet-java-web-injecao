package br.edu.infnet.appmontadora.model.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tfuncionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idCargo")
	private Cargo cargo;
	@OneToMany
	@JoinColumn(name = "idResponsavel")
	private List<Lote> lotesResponsavel;

	@ManyToOne
	@JoinColumn(name = "idFabrica")
	private Fabrica fabrica;

	public Funcionario() {

	}
	
	public Funcionario(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {

		return String.format("%d - %s - %s - %s", id, nome, email, senha);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Lote> getLotesResponsavel() {
		return lotesResponsavel;
	}

	public void setLotesResponsavel(List<Lote> lotesResponsavel) {
		this.lotesResponsavel = lotesResponsavel;
	}

	public Fabrica getFabrica() {
		return fabrica;
	}

	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}
}