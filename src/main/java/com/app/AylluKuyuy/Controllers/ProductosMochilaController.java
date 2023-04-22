package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Productos_Mochila;
import com.app.AylluKuyuy.modelos.Rutas;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import com.app.AylluKuyuy.repositories.ProductosMochilaR;
import com.app.AylluKuyuy.repositories.RutasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@RestController
public class ProductosMochilaController {

    @Autowired
    ProductosMochilaR productosMochilaR;

    @Autowired
    FamiliasRepository familiasRepository;

    @PostMapping("/mochila/item")
    public Productos_Mochila registrarItemMochila(@RequestBody HashMap<String, Object> item) {
        int codigo = (int) item.get("codigo_familiar");
        String nombre = (String) item.get("nombre");
        boolean caduce = (boolean) item.get("caduce");
        Date fecha = (Date) item.get("fecha");

        int idFamilia = familiasRepository.getIdFamiliaByCodFamilia(codigo);
        int idProducto = productosMochilaR.getIdProducto(nombre);

        Productos_Mochila productosMochila = new Productos_Mochila();
        productosMochila.setIdMochila(idFamilia);
        productosMochila.setIdProducto(idProducto);
        productosMochila.setFecha_caducidad(fecha);
        productosMochila.setCaducable(caduce);

        return productosMochilaR.save(productosMochila);
    }

    @DeleteMapping("/mochila/item")
    public HashMap<String, Object> eliminarMochila(@RequestBody Productos_Mochila item){
        HashMap<String, Object> json = new HashMap<>();
        json.put("idItem", item.getIdproducto_mochila());
        return json;
    }

}
