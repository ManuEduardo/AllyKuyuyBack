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
    public ArrayList<HashMap<String, Object>> getPlanes(@RequestParam("codigo_familiar") int codigo){
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

    @PostMapping("/paso")
    public Plan_Personalizado registrarPaso(@RequestBody HashMap<String, Object> plan){
        int codigo = Integer.parseInt((String)plan.get("codigo_familiar"));
        int idfamilia = familiasRepository.getIdFamiliaByCodFamilia(codigo);

        Plan_Personalizado obj = new Plan_Personalizado();
        obj.setIdfamilia(idfamilia);
        obj.setPlan((String) plan.get("detalle"));

        return planRepository.save(obj);
    }

    @DeleteMapping("/paso")
    public ArrayList<HashMap<String, Object>> eliminarPaso(@RequestBody HashMap<String, Object> plan){

        int id = Integer.parseInt((String)plan.get("idPaso"));
        planRepository.deleteById(id);

        int codigo = Integer.parseInt((String)plan.get("codigo_familiar"));

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
