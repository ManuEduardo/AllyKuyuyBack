package com.app.AylluKuyuy.Controllers;

import java.io.File;
import java.io.IOException;

import com.app.AylluKuyuy.modelos.Croquis;
import com.app.AylluKuyuy.modelos.FileDownloadUtil;
import com.app.AylluKuyuy.modelos.ImageService;
import com.app.AylluKuyuy.repositories.CroquisRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadController {

    @Autowired
    private CroquisRepository croquisRepository;

    @GetMapping("/verImg")
    public Croquis downloadFile() {
        FileDownloadUtil downloadUtil = new FileDownloadUtil();

        // Obtener los bytes de imagen desde donde sea que los obtienes (por ejemplo, de una base de datos)
        Croquis croquis = croquisRepository.findById(1).get();

//        // Convertir los bytes de imagen a un archivo
//        String fileName = "image.jpg"; // Nombre de archivo para la imagen
//        try {
//            File imageFile = imageService.convertBytesToImage(imageBytes, fileName);
//
//            // Cargar el archivo convertido como recurso
//            Resource resource = new ByteArrayResource(FileUtils.readFileToByteArray(imageFile));
//
//            // Configurar el encabezado de la respuesta HTTP
//            String contentType = "application/octet-stream";
//            String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
//
//            return ResponseEntity.ok()
//                    .contentType(MediaType.parseMediaType(contentType))
//                    .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
//                    .body(resource);
//        } catch (IOException e) {
//            return ResponseEntity.internalServerError().build();
//        }

        return croquis;
    }
}
