package edu.ifam.tads.dad.aplicacao_springboot.controller;

import edu.ifam.tads.dad.aplicacao_springboot.dto.CidadeInputDto;
import edu.ifam.tads.dad.aplicacao_springboot.dto.CidadeOutputDto;
import edu.ifam.tads.dad.aplicacao_springboot.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CidadeOutputDto>> list() {
        return ResponseEntity.ok(cidadeService.list());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CidadeOutputDto> create(@RequestBody CidadeInputDto cidadeInputDto) {
        CidadeOutputDto novaCidade = cidadeService.create(cidadeInputDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novaCidade.getId())
                .toUri();

        return ResponseEntity.created(uri).body(novaCidade);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CidadeOutputDto> getById(@PathVariable Long id) {
        Optional<CidadeOutputDto> possivelCidade = cidadeService.getById(id);

        if (possivelCidade.isPresent()) {
            return ResponseEntity.ok(possivelCidade.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}