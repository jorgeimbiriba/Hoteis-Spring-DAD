package br.edu.ifam.turismo.hotel_service.repository;
import br.edu.ifam.turismo.hotel_service.entity.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
