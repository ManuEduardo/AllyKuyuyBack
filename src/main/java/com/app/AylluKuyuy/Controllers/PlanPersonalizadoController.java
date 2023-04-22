package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.modelos.Plan_Personalizado;
import com.app.AylluKuyuy.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/plan")
public class PlanPersonalizadoController {

    @Autowired
    PlanRepository planRepository;

    @GetMapping
    public ArrayList<Plan_Personalizado> getPlanes(@RequestBody Familias familias){
        return planRepository.getPlanes(familias.getCodigo_familiar());
    }

    @PostMapping("/paso")
    public Plan_Personalizado registrarPaso(@RequestBody Plan_Personalizado plan){
        return planRepository.save(plan);
    }

    @DeleteMapping("/paso")
    public HashMap<String, Object> eliminarPaso(@RequestBody Plan_Personalizado plan){
        HashMap<String, Object> json = new HashMap<>();
        int id = plan.getIdplan();
        planRepository.deleteById(id);
        json.put("idplan", id);
        return json;
    }
}
