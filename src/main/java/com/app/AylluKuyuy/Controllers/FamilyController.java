package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FamilyController {
    @Autowired
    FamiliasRepository familiasRepository;

    @PostMapping("/ingresar")
    public String validarLogin(@RequestBody Familias familias) {
        int cod_fammiliar = familias.getCodigo_familiar();
        int password = familias.getContrasena();
        familiasRepository.buscarFamiliar(cod_fammiliar, password);
        return "Sida";
    }

    @PostMapping("/registrar")
    public String registrar(@RequestBody Familias familias) {
        familiasRepository.save(familias);
        return "Registrado :D";
    }







}
