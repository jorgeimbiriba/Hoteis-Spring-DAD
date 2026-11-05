package edu.ifam.tads.dad.aplicacao_springboot.dto;

import edu.ifam.tads.dad.aplicacao_springboot.model.Estado;

public class EstadoOutputDto {
    private Long id;
    private String nome;
    private String ibge;
    private String sigla;

    public EstadoOutputDto(Estado estado) {
        setId(estado.getId());
        setNome(estado.getNome());
        setIbge(estado.getIbge());
        setSigla(estado.getSigla());
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
}