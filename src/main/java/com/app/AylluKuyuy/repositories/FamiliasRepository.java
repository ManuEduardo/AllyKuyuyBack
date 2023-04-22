package com.app.AylluKuyuy.repositories;
import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.modelos.Integrantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamiliasRepository extends JpaRepository<Familias, Integer>{
    @Query("SELECT f FROM Familias f WHERE f.codigo_familiar = :codigoFamiliar AND f.contrasena = :contrasena")
    Familias buscarFamiliar(@Param("codigoFamiliar") int codigoFamiliar, @Param("contrasena") int contrasena);

    @Query("select f.idfamilia from Familias f where f.codigo_familiar=:codigo_familiar")
    int getIdFamiliaByCodFamilia(@Param("codigo_familiar") int codigo_familiar);




    //@Query("SELECT f.codigo_familiar, f.nombre_familia, CONCAT(i.nombre, ' ', i.apellido) AS integrante FROM Familias f INNER JOIN Integrantes i ON i.idfamilia = f.idfamilia WHERE f.codigo_familiar = :codFamiliar")
    @Query("SELECT f.codigo_familiar, f.nombre_familia FROM Familias f WHERE f.codigo_familiar = :codFamiliar")
    String findByCodigoFamiliar(@Param("codFamiliar") int codFamiliar);

    @Query("SELECT i FROM Integrantes i INNER JOIN Familias f on f.idfamilia = i.idfamilia WHERE f.codigo_familiar = :codFamiliar")
    List<Integrantes> findByObjIntegrantes(@Param("codFamiliar") int codFamiliar);

    @Query("SELECT f.cantidad,f.codigo_familiar,CONCAT(i.nombre,' ',i.apellido) ,f.nombre_familia FROM Familias f INNER JOIN Integrantes i on i.idfamilia = f.idfamilia WHERE f.codigo_familiar = :codFamiliar AND i.lider = true")
    List<String> findByInformacionFamilia(@Param("codFamiliar") int codFamiliar);




}


