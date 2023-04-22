package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Productos_Mochila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductosMochilaR extends JpaRepository<Productos_Mochila, Integer> {
    @Query("SELECT pm.idProducto from Productos_Mochila pm inner join Productos p on p.idproducto=pm.idProducto where p.nombre=:nombre")
    int getIdProducto(@Param("nombre") String nombre);

}
