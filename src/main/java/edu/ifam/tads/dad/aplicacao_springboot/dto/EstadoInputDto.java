package edu.ifam.tads.dad.aplicacao_springboot.dto;

import edu.ifam.tads.dad.aplicacao_springboot.model.Estado;

public class EstadoInputDto {
    private String nome;
    private String ibge;
    private String sigla;

    public EstadoInputDto() {
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

    public Estado build() {
        Estado estado = new Estado();
        estado.setNome(getNome());
        estado.setIbge(getIbge());
        estado.setSigla(getSigla());
        return estado;
    }
}