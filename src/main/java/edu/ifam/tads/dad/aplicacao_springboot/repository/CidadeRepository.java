package edu.ifam.tads.dad.aplicacao_springboot.repository;

import edu.ifam.tads.dad.aplicacao_springboot.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {
}
