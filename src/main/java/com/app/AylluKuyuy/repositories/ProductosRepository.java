package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Date;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    @Query("select p.nombre,pm.fecha_caducidad from Productos p inner join Productos_Mochila pm on p.idproducto = pm.idproducto inner join Mochila m on m.idmochila = pm.idmochila inner join Familias f on f.idfamilia = m.idfamilia where f.codigo_familiar = :codigo and pm.fecha_caducidad >:fecha")
    ArrayList<String> findAllByNombre(@Param("codigo") int codigo,@Param("fecha") Date fecha);


    @Query("select p.idproducto from Productos p order by p.idproducto desc")
    ArrayList<Integer> getid();
}
