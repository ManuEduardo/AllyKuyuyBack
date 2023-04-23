package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Productos_Mochila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ProductosMochilaR extends JpaRepository<Productos_Mochila, Integer> {
    @Query("SELECT p.idproducto from Productos p where p.nombre=:nombre")
    int getIdProducto(@Param("nombre") String nombre);


    @Query("select m.idmochila from Mochila m where m.idfamilia = :idfamilia")
    int getidMochila(@Param("idfamilia") int idfamilia);

    @Query("SELECT pm.idproducto_mochila,p.nombre,pm.caducable,pm.fecha_caducidad " +
            "FROM Productos_Mochila pm " +
            "INNER JOIN Productos p on p.idproducto = pm.idproducto " +
            "INNER JOIN Mochila m on m.idmochila = pm.idmochila " +
            "INNER JOIN Familias f on f.idfamilia = m.idfamilia " +
            "WHERE f.codigo_familiar = :codigo_familiar")
    ArrayList<String> findByInformacionMochila(@Param("codigo_familiar") int codigo_familiar);

}
