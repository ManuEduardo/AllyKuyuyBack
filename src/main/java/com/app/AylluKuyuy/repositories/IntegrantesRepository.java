package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Integrantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IntegrantesRepository extends JpaRepository<Integrantes, Integer> {

    @Query("SELECT i FROM Integrantes i INNER JOIN Familias f on f.idfamilia = i.idfamilia WHERE f.codigo_familiar = :codFamiliar")
    List<Integrantes> findByObjIntegrantes(@Param("codFamiliar") int codFamiliar);

}
