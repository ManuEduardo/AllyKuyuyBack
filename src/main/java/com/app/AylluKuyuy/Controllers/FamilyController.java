package com.app.AylluKuyuy.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/familia")
public class FamilyController {

    @GetMapping("/hello/{id}")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name, @PathVariable(name = "id") int id) {
        return String.format("Hello %s!" +
                "", id);
    }

//    @PostMapping("/ingresar")
//    public String getStart(@RequestBody prueba leo){
//        return model.save(leo);
//    }
}
