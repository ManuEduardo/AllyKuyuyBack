package com.app.AylluKuyuy.pruebaSubirImagen;

import java.io.IOException;

import com.app.AylluKuyuy.modelos.Croquis;
import com.app.AylluKuyuy.repositories.CroquisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.app.AylluKuyuy.pruebaSubirImagen.ImageService.convertImageToBytes;


@RestController
public class FileUploadController {
    @Autowired
    CroquisRepository croquisRepository;

    @PostMapping("/uploadFile")
    public Croquis uploadFile(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {

        Croquis croquis = new Croquis();
        croquis.setMapa(convertImageToBytes(multipartFile));
        croquis.setIdfamilia(1);
        croquis.setPiso(1);

        return croquisRepository.save(croquis);
    }

    @GetMapping("/mapa")
    public Croquis uploadFile(){
        return croquisRepository.findById(1).get();
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
