package com.app.AylluKuyuy.Controllers;

import java.io.IOException;

import com.app.AylluKuyuy.modelos.Croquis;
import com.app.AylluKuyuy.modelos.FileUploadResponse;
import com.app.AylluKuyuy.modelos.FileUploadUtil;
import com.app.AylluKuyuy.repositories.CroquisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.app.AylluKuyuy.modelos.ImageService.convertImageToBytes;


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
        croquis.setIdcroquis(1);
        croquis.setIdfamilia(1);
        croquis.setPiso(1);

        return croquisRepository.save(croquis);
    }
}
