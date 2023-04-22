package com.app.AylluKuyuy.repositories;
import com.app.AylluKuyuy.modelos.Familias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FamiliasRepository extends JpaRepository<Familias, Integer>{
    /*@Query("select codigo_famiiar, contrasena from familias where codigo_famiiar = :cod_familiar and contrasena = :password")
    void buscarFamiliar(@Param("cod_familiar") int cod_familiar, @Param("password") int password);*/


}
