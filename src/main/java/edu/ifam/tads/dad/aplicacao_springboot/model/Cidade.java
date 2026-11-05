package edu.ifam.tads.dad.aplicacao_springboot.model;

import jakarta.persistence.*;

@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(nullable = false,unique = true)
    private String ibge;
    @ManyToOne
    private Estado estado;

    public Cidade() {
    }

    public Cidade(Long id, String nome, String ibge, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.ibge = ibge;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
