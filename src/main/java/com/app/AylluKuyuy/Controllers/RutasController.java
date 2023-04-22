package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Croquis;
import com.app.AylluKuyuy.modelos.Rutas;
import com.app.AylluKuyuy.repositories.CroquisRepository;
import com.app.AylluKuyuy.repositories.RutasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RutasController {

    @Autowired
    RutasRepository rutasRepository;

    @PostMapping("/zonas")
    public String registrarZona(@RequestBody Rutas rutas) {
        rutasRepository.save(rutas);
        return "Zona Registrada :D";
    }
}
