package edu.ifam.tads.dad.aplicacao_springboot.dto;


import edu.ifam.tads.dad.aplicacao_springboot.model.Cidade;
import edu.ifam.tads.dad.aplicacao_springboot.repository.EstadoRepository;

public class CidadeInputDto {
    private String nome;
    private String ibge;
    private String estado;

    public CidadeInputDto() {
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

    public Cidade build(EstadoRepository estadoRepository){

        Cidade cidade = new Cidade();
        cidade.setNome(getNome());
        cidade.setIbge(getIbge());
        cidade.setEstado(estadoRepository.findBySigla(getEstado()));
        return cidade;

    }
}
