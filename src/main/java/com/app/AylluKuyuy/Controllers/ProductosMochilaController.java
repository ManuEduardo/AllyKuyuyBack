package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Productos;
import com.app.AylluKuyuy.modelos.Productos_Mochila;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import com.app.AylluKuyuy.repositories.ProductosMochilaR;
import com.app.AylluKuyuy.repositories.ProductosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductosMochilaController {

    @Autowired
    ProductosMochilaR productosMochilaR;

    @Autowired
    FamiliasRepository familiasRepository;

    @Autowired
    ProductosRepository productosRepository;


    @PostMapping("/mochila/item")
    public HashMap<String, Object> registrarItemMochila(@RequestBody HashMap<String, Object> item) {
        int codigo = Integer.parseInt((String) item.get("codigo_familiar"));
        String nombre = (String) item.get("nombre");
        boolean caduce = (boolean) item.get("caduce");
        boolean disponible = false;

        String fechaStr = (String) item.get("fecha");
        Date fecha = null;

        if (fechaStr == "null") {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                fecha = dateFormat.parse(fechaStr);
            } catch (ParseException e) {

                e.printStackTrace();
            }
        }


        int idFamilia = familiasRepository.getIdFamiliaByCodFamilia(codigo);

        Productos producto = new Productos();
        producto.setNombre(nombre);
        Productos newProduct = productosRepository.save(producto);

        int idProducto = productosRepository.getid().get(0);

        Productos_Mochila productosMochila = new Productos_Mochila();
        int idmochila = productosMochilaR.getidMochila(idFamilia);
        productosMochila.setIdmochila(idmochila);
        productosMochila.setIdproducto(idProducto);
        productosMochila.setFecha_caducidad(fecha);
        productosMochila.setCaducable(caduce);
        productosMochila.setDisponible(disponible);
        productosMochilaR.save(productosMochila);


        HashMap<String, Object> json = new HashMap<>();
        json.put("idproducto_mochila", productosMochila.getIdproducto_mochila());
        json.put("idproducto", idProducto);
        json.put("idmochila", idmochila);
        json.put("caducable", caduce);

        json.put("fecha_caducidad", fechaStr);
        json.put("disponible", disponible);

        return json;
    }

    @GetMapping("/productos")
    public ArrayList<HashMap<String, Object>> getAllProductos() {
        ArrayList<String> nombres = productosRepository.findAllByNombre();
        ArrayList<HashMap<String, Object>> json = new ArrayList<>();
        for (String nombre : nombres) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("nombre", nombre);
            json.add(map);
        }
        return json;
    }

    @PostMapping("/mochila/item/disponible")
    @Transactional
    public void colocarCheck(@RequestParam("idItem") int idItem, @RequestParam("disponible") boolean disponible) {
        productosMochilaR.cambio(idItem, disponible);
    }

    @DeleteMapping("/mochila/item")
    public HashMap<String, Object> eliminarMochila(@RequestParam("idproducto_mochila") int idproducto_mochila) {
        productosMochilaR.deleteById(idproducto_mochila);
        HashMap<String, Object> json = new HashMap<>();
        json.put("idItem", idproducto_mochila);
        return json;
    }

    @GetMapping("/mochila")
    public ArrayList<Map<String, Object>> obtenerInformacionHogar(@RequestParam("codigo_familiar") int codigo) throws ParseException {
        ArrayList<Map<String, Object>> jsonArray = new ArrayList<>();
        ArrayList<String> data = productosMochilaR.findByInformacionMochila(codigo);

        for (String item : data) {
            String[] aux = item.split(",");
            Map<String, Object> json = new HashMap<>();

            json.put("id_item", aux[0]);
            json.put("nombre", aux[1]);
            json.put("caduce", Boolean.valueOf(aux[2]));

            String fechaOriginal = aux[3];
            if (fechaOriginal == null) {
                json.put("fecha", aux[3]);
            } else {
                SimpleDateFormat formatoOriginal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                SimpleDateFormat nuevoFormato = new SimpleDateFormat("yyyy-MM-dd");
                if (!fechaOriginal.equalsIgnoreCase("null")) {
                    Date fecha = formatoOriginal.parse(fechaOriginal);
                    json.put("fecha", nuevoFormato.format(fecha));
                    json.put("caduco", caduco(fecha));
                } else {
                    json.put("fecha", "null");
                    json.put("caduco", false);
                }
            }

            json.put("disponible", Boolean.valueOf(aux[4]));
            jsonArray.add(json);

        }

        return jsonArray;
    }


    public boolean caduco(Date fecha) {
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoy = LocalDate.now();
        return hoy.compareTo(localDate) >= 0;
    }

}
