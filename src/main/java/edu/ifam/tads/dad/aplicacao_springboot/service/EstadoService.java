package edu.ifam.tads.dad.aplicacao_springboot.service;

import edu.ifam.tads.dad.aplicacao_springboot.dto.EstadoInputDto;
import edu.ifam.tads.dad.aplicacao_springboot.dto.EstadoOutputDto;
import edu.ifam.tads.dad.aplicacao_springboot.model.Estado;
import edu.ifam.tads.dad.aplicacao_springboot.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<EstadoOutputDto> list() {
        List<Estado> estados = estadoRepository.findAll();
        List<EstadoOutputDto> dtos = new ArrayList<>();

        for (Estado estado : estados) {
            dtos.add(new EstadoOutputDto(estado));
        }

        return dtos;
    }

    public EstadoOutputDto create(EstadoInputDto inputDto) {
        Estado estado = inputDto.build();
        Estado salvo = estadoRepository.save(estado);
        return new EstadoOutputDto(salvo);
    }

    public Optional<EstadoOutputDto> getById(Long id) {
        return estadoRepository.findById(id).map(EstadoOutputDto::new);
    }
}