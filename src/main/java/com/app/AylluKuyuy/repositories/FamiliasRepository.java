package com.app.AylluKuyuy.repositories;
import com.app.AylluKuyuy.modelos.Familias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliasRepository extends JpaRepository<Familias, Integer>{
    @Query("SELECT f FROM Familias f WHERE f.codigo_familiar = :codigoFamiliar AND f.contrasena = :contrasena")
    void buscarFamiliar(@Param("codigoFamiliar") int codigoFamiliar, @Param("contrasena") int contrasena);


}
