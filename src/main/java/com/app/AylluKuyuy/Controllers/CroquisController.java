package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Croquis;
import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.modelos.Rutas;
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

    @Autowired
    FamiliasRepository familiasRepository;

    @PostMapping("/piso")
    public Croquis registrarPiso(@RequestBody HashMap<String, Object> json) {
        int codigo = (int) json.get("codigo_familiar");
        int idfamilia = familiasRepository.getIdFamiliaByCodFamilia(codigo);

        Croquis croquis = new Croquis();
        croquis.setIdfamilia(idfamilia);
        croquis.setPiso((Integer) json.get("num_piso"));
        croquis.setMapa((byte[]) json.get("foto"));

        return croquisRepository.save(croquis);
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
