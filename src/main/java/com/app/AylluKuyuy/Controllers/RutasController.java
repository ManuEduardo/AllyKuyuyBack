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
        int codigo = (int) json.get("codigo_familiar");
        int idfamilia = familiasRepository.getIdFamiliaByCodFamilia(codigo);

        Rutas rutas = new Rutas();
        rutas.setIdfamilia(idfamilia);
        rutas.setDetalle((String) json.get("detalle"));
        rutas.setNombre((String) json.get("nombre"));
        rutas.setTipo((String) json.get("tipo"));

        return rutasRepository.save(rutas);
    }

    @GetMapping("/zona")
    public ArrayList<Rutas> getAllRutas(@RequestBody Familias familias){
        return rutasRepository.getAllRutas(familias.getCodigo_familiar());
    }

    @DeleteMapping("/zona")
    public HashMap<String, Object> eliminarRutas(@RequestBody Rutas rutas){
        HashMap<String, Object> json = new HashMap<>();
        rutasRepository.delete(rutas);
        json.put("idzona", rutas.getIdruta());
        return json;
    }
}