package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Productos_Mochila;
import com.app.AylluKuyuy.modelos.Rutas;
import com.app.AylluKuyuy.repositories.ProductosMochilaR;
import com.app.AylluKuyuy.repositories.RutasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductosMochilaController {

    @Autowired
    ProductosMochilaR productosMochilaR;

    @PostMapping("/mochila/item")
    public String registrarItemMochila(@RequestBody Productos_Mochila productosMochila) {
        productosMochilaR.save(productosMochila);
        return "Producto Mochila Registrada :D";
    }


}
