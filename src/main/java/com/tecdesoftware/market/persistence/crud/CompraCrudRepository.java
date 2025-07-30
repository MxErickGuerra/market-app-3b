package com.tecdesoftware.market.persistence.crud;

import com.tecdesoftware.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    // Cambiado de String a Integer para coincidir con la entidad
    Optional<List<Compra>> findByIdCliente(Integer idCliente);
}