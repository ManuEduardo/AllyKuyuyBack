package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Croquis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface CroquisRepository extends JpaRepository<Croquis, Integer> {
    @Query("select c from Croquis c inner join Familias f on f.idfamilia=c.idfamilia where f.codigo_familiar=:codigo_familiar")
    ArrayList<Croquis> getCroquisByCodFamiliar(@Param("codigo_familiar") int codigo_familiar);
}
