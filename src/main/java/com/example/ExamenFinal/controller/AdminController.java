package com.example.ExamenFinal.controller;

import com.example.ExamenFinal.modelDto.UsuarioDto;
import com.example.ExamenFinal.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//@CrossOrigin
@RestController
public class AdminController {

    @Autowired
    private UsuarioServiceImpl usuarioService;


    private boolean isAdmin = true;

    @PostMapping("/admin/login/{nickname}/{password}")
    public ResponseEntity<?> login(@PathVariable String nickname,@PathVariable String password){

        try {
            isAdmin = usuarioService.isAdmin(nickname,password);
            System.out.println("isAdmin" + isAdmin);
            if (isAdmin) {
                return ResponseEntity.ok("Soy admin");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NotFound");

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping("/admin/logout")
    public ResponseEntity<?> logout(@PathVariable String msj){

        try {
            if(!msj.isEmpty()){
                return ResponseEntity.ok("Me fui");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NotFound");

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
