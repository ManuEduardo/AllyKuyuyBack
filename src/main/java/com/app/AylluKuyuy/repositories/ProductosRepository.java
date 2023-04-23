package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    @Query("select p.nombre from Productos p")
    ArrayList<String> findAllByNombre();


    @Query("select p.idproducto from Productos p order by p.idproducto desc")
    ArrayList<Integer> getid();
}
