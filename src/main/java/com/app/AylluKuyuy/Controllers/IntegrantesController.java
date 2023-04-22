package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.modelos.Integrantes;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import com.app.AylluKuyuy.repositories.IntegrantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class IntegrantesController {

    @Autowired
    IntegrantesRepository integrantesRepository;

    @PostMapping("/familia")
    public String registrarFamilia(@RequestBody Integrantes integrantes) {
        integrantesRepository.save(integrantes);
        return "Integrante Registrado :D";
    }

    @GetMapping("/familia")
    public Map<String, Object> obtenerInformacionFamiliar(@RequestBody Familias familias) {
        Map<String, Object> json = new HashMap<>();
        List<Integrantes> lista = integrantesRepository.findByObjIntegrantes(familias.getCodigo_familiar());
        json.put("integrante",lista);
        return json;
    }

    @DeleteMapping("/familia")
    public HashMap<String, Object> eliminarFamiliar(@RequestBody Integrantes integrante){
        integrantesRepository.deleteById(integrante.getIdintegrante());
        HashMap<String, Object> json = new HashMap<>();
        json.put("idIntegrante", integrante.getIdintegrante());
        return json;
    }

}
