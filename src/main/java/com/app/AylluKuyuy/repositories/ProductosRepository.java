package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {
}
