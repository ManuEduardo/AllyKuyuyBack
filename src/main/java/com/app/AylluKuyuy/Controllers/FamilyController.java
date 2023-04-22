package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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


//    @GetMapping("/home")
//    public Map<String, Object> obtenerInformacionFamiliar(@RequestParam("cod_familiar") int codFamiliar) {
//
//        // Lógica para obtener información del familiar según el código enviado
//        Familia familia = familiaRepository.buscarFamiliaPorCodFamiliar(codFamiliar); // Ejemplo de método para buscar la familia en el repositorio
//
//        // Verificar si se encontró la familia
//        if (familia != null) {
//            // Crear objeto JSON con la información de retorno
//            Map<String, Object> json = new HashMap<>();
//            json.put("error", false);
//            json.put("detalles", "Consulta exitosa");
//            json.put("cod_familia", familia.getCodigoFamilia());
//            json.put("nombre_familiar", familia.getNombreFamiliar());
//            json.put("integrantes", familia.getIntegrantes());
//            return ResponseEntity.ok(json); // Retornar respuesta exitosa con los datos de la familia
//        } else {
//            // Crear objeto JSON con el mensaje de error
//            Map<String, Object> json = new HashMap<>();
//            json.put("error", true);
//            json.put("detalles", "Familiar no encontrado");
//            return ResponseEntity.ok(json); // Retornar respuesta exitosa con el mensaje de error
//        }
//    }


}










