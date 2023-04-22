package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Croquis;
import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.repositories.CroquisRepository;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CroquisController {

    @Autowired
    CroquisRepository croquisRepository;

    @PostMapping("/piso")
    public String registrarPiso(@RequestBody Croquis croquis) {
        croquisRepository.save(croquis);
        return "Registrado :D";
    }



}
