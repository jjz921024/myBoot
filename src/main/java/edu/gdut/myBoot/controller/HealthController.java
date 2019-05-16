package edu.gdut.myBoot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Jun on 2018/8/14.
 */
@Controller
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity health() {
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
