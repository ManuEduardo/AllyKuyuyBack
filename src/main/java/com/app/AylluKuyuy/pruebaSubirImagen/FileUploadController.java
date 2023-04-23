package com.app.AylluKuyuy.pruebaSubirImagen;

import java.io.IOException;
import java.util.HashMap;

import com.app.AylluKuyuy.modelos.Croquis;
import com.app.AylluKuyuy.repositories.CroquisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.app.AylluKuyuy.pruebaSubirImagen.ImageService.convertImageToBytes;


@RestController
public class FileUploadController {
    @Autowired
    CroquisRepository croquisRepository;

    @PostMapping("/uploadFile")
    public Croquis uploadFile(@RequestParam("file") MultipartFile multipartFile)
            throws IOException {
        Croquis croquis = new Croquis();
        croquis.setMapa(convertImageToBytes(multipartFile));
        croquis.setIdfamilia(1);
        croquis.setPiso(1);

        return croquisRepository.save(croquis);
    }

    /*@GetMapping("/mapa")
    public ResponseEntity<Croquis> uploadFile(){
        Croquis croquis = croquisRepository.findById(1).get();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(croquis.getMapa().length);
        return ResponseEntity.ok().headers(headers).body(croquis);
    }*/

    @GetMapping("/mapa")
    public ResponseEntity<byte[]> uploadFile(){
        Croquis croquis = croquisRepository.findById(1).get();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(croquis.getMapa().length);
        return new ResponseEntity<>(croquis.getMapa(), headers, HttpStatus.OK);
    }

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
