package com.app.AylluKuyuy.modelos;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageService {

    // Método para convertir una imagen en bytes
     public static byte[] convertImageToBytes(MultipartFile imageFile) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.copy(imageFile.getInputStream(), outputStream);
        return outputStream.toByteArray();
    }

    public static File convertBytesToImage(byte[] imageBytes, String fileName) throws IOException {
        File file = new File(fileName);
        FileUtils.writeByteArrayToFile(file, imageBytes);
        return file;
    }
}
