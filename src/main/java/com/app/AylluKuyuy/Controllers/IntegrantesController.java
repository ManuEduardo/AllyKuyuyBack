package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.modelos.Integrantes;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import com.app.AylluKuyuy.repositories.IntegrantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class IntegrantesController {

    @Autowired
    IntegrantesRepository integrantesRepository;

    @PostMapping("/familia")
    public String registrarFamilia(@RequestBody Integrantes integrantes) {
        integrantesRepository.save(integrantes);
        return "Integrante Registrado :D";
    }

}
