package edu.ifam.tads.dad.aplicacao_springboot.repository;


import edu.ifam.tads.dad.aplicacao_springboot.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado,Long> {

    public Estado findBySigla(String sigla);
}
