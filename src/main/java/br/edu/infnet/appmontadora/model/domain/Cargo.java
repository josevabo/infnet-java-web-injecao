package br.edu.infnet.appmontadora.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "tcargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private boolean gerencial;

    public Cargo() {
    }
    public Cargo(Integer id) {
        this.id = id;
    }

    public Cargo(String nome, boolean gerencial) {
        this.nome = nome;
        this.gerencial = gerencial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isGerencial() {
        return gerencial;
    }

    public void setGerencial(boolean gerencial) {
        this.gerencial = gerencial;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", gerencial=" + gerencial +
                '}';
    }
}
