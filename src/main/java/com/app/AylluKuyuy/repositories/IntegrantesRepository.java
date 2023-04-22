package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Integrantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IntegrantesRepository extends JpaRepository<Integrantes, Integer> {

}
