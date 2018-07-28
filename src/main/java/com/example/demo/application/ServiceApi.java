package com.example.demo.application;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@RestController
public class ServiceApi {

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String index(@RequestPart MultipartFile sourceFile) throws IOException {
        String sourceFileName = sourceFile.getOriginalFilename();
        String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();

        File convertFile = new File("/Users/arthur/Downloads"+sourceFile.getOriginalFilename());
        byte[] bytes = sourceFile.getBytes();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(convertFile));

        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();

        return "file";
    }
}
