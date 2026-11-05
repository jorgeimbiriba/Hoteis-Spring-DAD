package edu.ifam.tads.dad.aplicacao_springboot.dto;


import edu.ifam.tads.dad.aplicacao_springboot.model.Cidade;

public class CidadeOutputDto {
    private Long id;
    private String nome;
    private String ibge;
    private String estado;

    public CidadeOutputDto(Cidade cidade) {

        setId(cidade.getId());
        setNome(cidade.getNome());
        setIbge(cidade.getIbge());
        setEstado(cidade.getEstado().getSigla());

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
