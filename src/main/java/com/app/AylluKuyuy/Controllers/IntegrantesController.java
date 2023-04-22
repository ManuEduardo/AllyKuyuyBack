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
    @Autowired
    FamiliasRepository familiasRepository;


    @PostMapping("/familia")
    public Integrantes registrarFamilia(@RequestBody HashMap<String, Object> integrantes) {
        int codigo=(int) integrantes.get("codigo_familiar");
        int id_familia = familiasRepository.getIdFamiliaByCodFamilia(codigo);
        Integrantes obj = new Integrantes();
        obj.setIdfamilia(id_familia);
        obj.setNombre((String) integrantes.get("nombre"));
        obj.setApellido((String) integrantes.get("apellido"));
        obj.setDni((int) integrantes.get("dni"));
        obj.setTelefono((int) integrantes.get("telefono"));
        obj.setLider((boolean) integrantes.get("lider"));
        obj.setMascota((boolean) integrantes.get("mascota"));
        obj.setDiscapacitado((boolean) integrantes.get("discapacidad"));
        obj.setRoles((String) integrantes.get("roles"));

        return integrantesRepository.save(obj);
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
