package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.modelos.Integrantes;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FamilyController {
    @Autowired
    FamiliasRepository familiasRepository;

    @PostMapping("/ingresar")
    public Map<String, Object> validarLogin(@RequestBody Familias familias) {
        Map<String, Object> json = new HashMap<>();
        int cod_fammiliar = familias.getCodigo_familiar();
        int password = familias.getContrasena();

        if (familiasRepository.buscarFamiliar(cod_fammiliar, password) == null){
            json.put("error", true);
            json.put("detalles", "Credenciales Inválidas");
        }else {
            json.put("error", false);
            json.put("detalles", "Inicio de sesión exitoso");
        }
        return json;
    }




    @PostMapping("/registrar")
    public Map<String, Object> registrar(@RequestBody Familias familias) {

        try {

            Map<String, Object> json = new HashMap<>();
            json.put("error", false);
            json.put("detalles", "Registro exitoso");
            return json;

        }catch (Exception e){

            //Cath no funciona pero el Codigo Si xd
            Map<String, Object> json = new HashMap<>();
            json.put("error", true);
            json.put("detalles", "Error de Registro");
            return json;

        }
    }


    @GetMapping("/home")
    public Map<String, Object> obtenerInformacionFamiliar(@RequestParam("codigo_familiar") int codFamiliar) {
        Map<String, Object> json = new HashMap<>();
        String datos = familiasRepository.findByCodigoFamiliar(codFamiliar);
        String[] partes1 = datos.split(",");
        String dato1 = partes1[0];
        String dato2 = partes1[1];

        List<Integrantes> lista = familiasRepository.findByObjIntegrantes(codFamiliar);

        if (familiasRepository.findByObjIntegrantes(codFamiliar) == null){
            json.put("error", true);
            json.put("detalles", "Error en home");
            return json;
        }else {
            json.put("codigo_familiar", dato1);
            json.put("nombre_familia", dato2);
            json.put("integrantes",lista);
        }
        return json;

    }


}










