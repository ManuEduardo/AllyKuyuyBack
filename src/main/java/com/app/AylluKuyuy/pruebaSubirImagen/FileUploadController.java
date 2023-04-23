package com.app.AylluKuyuy.pruebaSubirImagen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.app.AylluKuyuy.modelos.Croquis;
import com.app.AylluKuyuy.repositories.CroquisRepository;
import com.app.AylluKuyuy.repositories.FamiliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.app.AylluKuyuy.pruebaSubirImagen.ImageService.convertImageToBytes;


@RestController
public class FileUploadController {
    @Autowired
    CroquisRepository croquisRepository;
    @Autowired
    FamiliasRepository familiasRepository;

    @PostMapping("/uploadFile")
    public Croquis subircroquis(@RequestParam("file") MultipartFile multipartFile, @RequestParam("piso") int piso, @RequestParam("codigo_familiar") int codigo)
            throws IOException {
        int idfamilia = familiasRepository.getIdFamiliaByCodFamilia(codigo);
        Croquis croquis = new Croquis();
        croquis.setMapa(convertImageToBytes(multipartFile));
        croquis.setIdfamilia(idfamilia);
        croquis.setPiso(piso);

        return croquisRepository.save(croquis);
    }

    /*@GetMapping("/mapa")
    public ResponseEntity<byte[]> devolverImagen(@RequestParam("codigo_familiar") int codigo){
        ArrayList<Croquis> croquis = croquisRepository.getCroquisByCodFamiliar(codigo);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        byte[] map = croquis.get(0).getMapa();
        headers.setContentLength(map.length);
        return new ResponseEntity<>(map, headers, HttpStatus.OK);
    }*/

    @GetMapping("/mapa")
    public ArrayList<ResponseEntity<byte[]>> devolverImagen(@RequestParam("codigo_familiar") int codigo){
        ArrayList<ResponseEntity<byte[]>> responseEntities = new ArrayList<>();
        ArrayList<Croquis> croquis = croquisRepository.getCroquisByCodFamiliar(codigo);
        for (Croquis croqui : croquis) {
            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.IMAGE_JPEG);
            header.setContentLength(croqui.getMapa().length);
            responseEntities.add(new ResponseEntity<>(croqui.getMapa(), header, HttpStatus.OK));
        }

        return responseEntities;
    }

    /*@GetMapping("/mapa")
    public ResponseEntity<byte[]> uploadFile(){
        Croquis croquis = croquisRepository.findById(1).get();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(croquis.getMapa().length);
        return new ResponseEntity<>(croquis.getMapa(), headers, HttpStatus.OK);
    }*/

    @PostMapping("/pruebita")
    public String uploadFile2(@RequestParam("file") MultipartFile file) throws IOException {
        Croquis croquis = new Croquis();
        croquis.setMapa(convertImageToBytes(file));
        croquis.setIdcroquis(1);
        croquis.setIdfamilia(1);
        croquis.setPiso(1);

        //return croquisRepository.save(croquis);
        return "wenass";
    }
}
