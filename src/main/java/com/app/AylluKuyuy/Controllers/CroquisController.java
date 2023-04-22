package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Croquis;
import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.repositories.CroquisRepository;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CroquisController {

    @Autowired
    CroquisRepository croquisRepository;

    @PostMapping("/piso")
    public Map<String, Object> registrarPiso(@RequestBody Croquis croquis) {
        Map<String, Object> json = new HashMap<>();
        croquisRepository.save(croquis);
        json.put("error", false);
        return json;
    }

    @GetMapping("/piso")
    public ArrayList<Croquis> getAllPisos(@RequestBody Familias familias){
        return croquisRepository.getCroquisByCodFamiliar(familias.getCodigo_familiar());
    }

    @DeleteMapping("/piso")
    public HashMap<String, Object> eliminarPiso(@RequestBody Croquis croquis){
        croquisRepository.deleteById(croquis.getIdcroquis());
        HashMap<String, Object> json = new HashMap<>();
        json.put("idpiso", croquis.getIdcroquis());
        return json;
    }
}
