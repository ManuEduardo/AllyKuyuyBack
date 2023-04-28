package com.app.AylluKuyuy.Controllers;

import com.app.AylluKuyuy.modelos.Croquis;
import com.app.AylluKuyuy.modelos.Familias;
import com.app.AylluKuyuy.modelos.Rutas;
import com.app.AylluKuyuy.repositories.CroquisRepository;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CroquisController {

    @Autowired
    CroquisRepository croquisRepository;

    @Autowired
    FamiliasRepository familiasRepository;

    @PostMapping("/piso")
    public ResponseEntity<byte[]> registrarPiso(@RequestParam("file") MultipartFile multipartFile, @RequestParam("codigo_familiar") int codigo) {
        int idfamilia = familiasRepository.getIdFamiliaByCodFamilia(Integer.parseInt(String.valueOf(codigo)));

        Croquis croquis = new Croquis();
        croquis.setIdfamilia(idfamilia);
        croquis.setPiso(1);
        byte[] mapa = null;
        try {
            mapa = multipartFile.getBytes();
            System.out.println(mapa);
            croquis.setMapa(multipartFile.getBytes());
            croquisRepository.save(croquis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(mapa.length);
        return new ResponseEntity<>(mapa, headers, HttpStatus.OK);
    }


    @GetMapping(value = "/piso")
    public ResponseEntity<byte[]> getAllPisos(@RequestParam("codigo_familiar") int codigo) {
        Croquis croquisList = croquisRepository.getCroquisByCodFamiliar(codigo);
        byte[] mapa = null;
        HttpHeaders headers = new HttpHeaders();
        try {
            mapa = croquisList.getMapa();
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentLength(mapa.length);
        }catch (Exception e){

        }

        return new ResponseEntity<>(mapa, headers, HttpStatus.OK);
    }




    @DeleteMapping("/piso")
    public HashMap<String, Object> eliminarPiso(@RequestBody Croquis croquis){
        croquisRepository.deleteById(croquis.getIdcroquis());
        HashMap<String, Object> json = new HashMap<>();
        json.put("idpiso", croquis.getIdcroquis());
        return json;
    }
}
