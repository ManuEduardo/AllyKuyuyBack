package com.app.AylluKuyuy.repositories;
import com.app.AylluKuyuy.modelos.Familias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliasRepository extends JpaRepository<Familias, Integer>{
    @Query("SELECT f FROM Familias f WHERE f.codigo_familiar = :codigoFamiliar AND f.contrasena = :contrasena")
    Familias buscarFamiliar(@Param("codigoFamiliar") int codigoFamiliar, @Param("contrasena") int contrasena);

    @Query("select f.idfamilia from Familias f where f.codigo_familiar=:codigo_familiar")
    int getIdFamiliaByCodFamilia(@Param("codigo_familiar") int codigo_familiar);
}

//@Repository
//public interface FamiliaRepository extends JpaRepository<Familias, Integer> {
//
//    // Método para buscar una familia por su código de familiar
//
//    @Query("SELECT f.codigo_familiar, f.nombre_familia, CONCAT(i.nombre, ' ', i.apellido) AS integrante FROM familias INNER JOIN integrantes i ON i.idfamilia = f.idfamilia WHERE f.codigo_familiar = '1707'")
//    ///@Query("SELECT f FROM Familias f WHERE f.codigo_familiar = :codigoFamiliar AND f.contrasena = :contrasena")
//    Familias findByCodigoFamiliar(int codFamiliar);
//}
