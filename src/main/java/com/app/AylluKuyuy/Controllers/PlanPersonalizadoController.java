package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.modelos.Plan_Personalizado;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
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

    @Autowired
    FamiliasRepository familiasRepository;

    @GetMapping
    public ArrayList<Plan_Personalizado> getPlanes(@RequestBody Familias familias){
        return planRepository.getPlanes(familias.getCodigo_familiar());
    }

    @PostMapping("/paso")
    public Plan_Personalizado registrarPaso(@RequestBody Plan_Personalizado plan){
        return planRepository.save(plan);
    }

    @DeleteMapping("/paso")
    public ArrayList<HashMap<String, Object>> eliminarPaso(@RequestBody HashMap<String, Object> plan){
        /*int id = (int) plan.get("idPlan");
        planRepository.deleteById(id);*/

        int codigo = (int) plan.get("codigo_familiar");

        ArrayList<Plan_Personalizado> planes = planRepository.getPlanes(codigo);
        ArrayList<HashMap<String, Object>> maps = new ArrayList<>();

        int paso = 1;
        for (Plan_Personalizado plane : planes) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("idPaso", plane.getIdplan());
            map.put("paso", paso);
            map.put("detalle", plane.getPlan());
            maps.add(map);
            paso++;
        }

        return maps;
    }

    private void colocarNumPasos(){

    }

}
