package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Mochila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MochilasRepository extends JpaRepository<Mochila, Integer> {
}
