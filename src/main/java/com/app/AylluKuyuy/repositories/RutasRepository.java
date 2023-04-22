package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Rutas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface RutasRepository extends JpaRepository<Rutas, Integer> {

    @Query("select r from Rutas r inner join Familias f on f.idfamilia=r.idfamilia where f.codigo_familiar=:codigo_familiar")
    ArrayList<Rutas> getAllRutas(@Param("codigo_familiar") int codigo_fmailiar);


}
