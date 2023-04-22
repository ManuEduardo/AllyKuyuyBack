package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.modelos.Productos_Mochila;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import com.app.AylluKuyuy.repositories.ProductosMochilaR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

        String fechaStr = (String) item.get("fecha");
        Date fecha = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            fecha = dateFormat.parse(fechaStr);
        } catch (ParseException e) {

            e.printStackTrace();
        }


        int idFamilia = familiasRepository.getIdFamiliaByCodFamilia(codigo);
        int idProducto = productosMochilaR.getIdProducto(nombre);

        Productos_Mochila productosMochila = new Productos_Mochila();
        int idmochila = productosMochilaR.getidMochila(idFamilia);
        productosMochila.setIdmochila(idmochila);
        productosMochila.setIdproducto(idProducto);
        productosMochila.setFecha_caducidad(fecha);
        productosMochila.setCaducable(caduce);

        return productosMochilaR.save(productosMochila);
    }

    @DeleteMapping("/mochila/item")
    public HashMap<String, Object> eliminarMochila(@RequestBody Productos_Mochila item){
        productosMochilaR.deleteById(item.getIdproducto_mochila());
        HashMap<String, Object> json = new HashMap<>();
        json.put("idItem", item.getIdproducto_mochila());
        return json;
    }

    @GetMapping("/mochila")
    public Map<String, Object> obtenerInformacionHogar(@RequestBody Familias familias) {
        Map<String, Object> json = new HashMap<>();
        int codFamiliar = (int) familias.getCodigo_familiar();

        String data = productosMochilaR.findByInformacionMochila(codFamiliar);
        String [] aux = data.split(",");

        json.put("id_item",aux[0]);
        json.put("nombre",aux[1]);
        json.put("caduce",Boolean.valueOf(aux[2]));
        json.put("fecha", aux[3]);
        return json;

    }

}
