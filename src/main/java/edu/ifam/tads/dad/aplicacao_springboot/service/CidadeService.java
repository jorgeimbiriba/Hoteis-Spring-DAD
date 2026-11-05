package edu.ifam.tads.dad.aplicacao_springboot.service;

import edu.ifam.tads.dad.aplicacao_springboot.dto.CidadeInputDto;
import edu.ifam.tads.dad.aplicacao_springboot.dto.CidadeOutputDto;
import edu.ifam.tads.dad.aplicacao_springboot.model.Cidade;
import edu.ifam.tads.dad.aplicacao_springboot.repository.CidadeRepository;
import edu.ifam.tads.dad.aplicacao_springboot.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<CidadeOutputDto> list() {
        List<Cidade> cidades = cidadeRepository.findAll();
        List<CidadeOutputDto> dtos = new ArrayList<>();

        for (Cidade cidade : cidades) {
            dtos.add(new CidadeOutputDto(cidade));
        }

        return dtos;
    }

    public CidadeOutputDto create(CidadeInputDto inputDto) {
        Cidade cidade = inputDto.build(estadoRepository);
        Cidade salva = cidadeRepository.save(cidade);
        return new CidadeOutputDto(salva);
    }

    public Optional<CidadeOutputDto> getById(Long id) {
        return cidadeRepository.findById(id).map(CidadeOutputDto::new);
    }
}