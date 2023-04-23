package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.modelos.Rutas;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import com.app.AylluKuyuy.repositories.RutasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class RutasController {

    @Autowired
    RutasRepository rutasRepository;

    @Autowired
    FamiliasRepository familiasRepository;

    @PostMapping("/zona")
    public Rutas registrarZona(@RequestBody HashMap<String, Object> json) {
        int codigo = Integer.parseInt((String)json.get("codigo_familiar"));
        int idfamilia = familiasRepository.getIdFamiliaByCodFamilia(codigo);

        Rutas rutas = new Rutas();
        rutas.setIdfamilia(idfamilia);
        rutas.setDetalle((String) json.get("detalle"));
        rutas.setNombre((String) json.get("nombre"));
        rutas.setTipo((String) json.get("tipo"));

        return rutasRepository.save(rutas);
    }

    @GetMapping("/zona")
    public ArrayList<Rutas> getAllRutas(@RequestParam("codigo_familiar") int codigo){
        return rutasRepository.getAllRutas(codigo);
    }

    @DeleteMapping("/zona")
    public HashMap<String, Object> eliminarRutas(@RequestBody Rutas rutas){
        HashMap<String, Object> json = new HashMap<>();
        rutasRepository.deleteById(rutas.getIdruta());
        json.put("idzona", rutas.getIdruta());
        return json;
    }
}