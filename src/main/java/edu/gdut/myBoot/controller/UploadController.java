package edu.gdut.myBoot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Jun on 2018/8/29.
 */
public class UploadController {

    private static String UPLOAD_PATH = "E:/tmp";

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file")MultipartFile file,
                             RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addAttribute("message", "Please select a file to upload");
            return "redirect:/uploadStatus";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_PATH + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addAttribute("message",
                    "Successfully upload " + file.getOriginalFilename());


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }
}
