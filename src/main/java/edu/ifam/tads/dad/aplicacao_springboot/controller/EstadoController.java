package edu.ifam.tads.dad.aplicacao_springboot.controller;

import edu.ifam.tads.dad.aplicacao_springboot.dto.EstadoInputDto;
import edu.ifam.tads.dad.aplicacao_springboot.dto.EstadoOutputDto;
import edu.ifam.tads.dad.aplicacao_springboot.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstadoOutputDto>> list() {
        return ResponseEntity.ok(estadoService.list());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoOutputDto> create(@RequestBody EstadoInputDto estadoInputDto) {
        EstadoOutputDto novoEstado = estadoService.create(estadoInputDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoEstado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(novoEstado);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoOutputDto> getById(@PathVariable Long id) {
        Optional<EstadoOutputDto> possivelEstado = estadoService.getById(id);

        if (possivelEstado.isPresent()) {
            return ResponseEntity.ok(possivelEstado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}