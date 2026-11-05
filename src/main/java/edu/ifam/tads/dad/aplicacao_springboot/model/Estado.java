package edu.ifam.tads.dad.aplicacao_springboot.model;

import jakarta.persistence.*;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(nullable = false,unique = true)
    private String ibge;
    @Column(nullable = false,unique = true)
    private String sigla;

    public Estado() {
    }

    public Estado(String nome, String ibge, String sigla) {
        this.nome = nome;
        this.ibge = ibge;
        this.sigla = sigla;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "nome='" + nome + '\'' +
                ", ibge='" + ibge + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
