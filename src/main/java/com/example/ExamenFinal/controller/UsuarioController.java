package com.example.ExamenFinal.controller;

import com.example.ExamenFinal.modelDto.UsuarioDto;
import com.example.ExamenFinal.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//@CrossOrigin
@RestController
public class UsuarioController {

        @Autowired
        private UsuarioServiceImpl usuarioService;

        @PostMapping("admin/usuario/post")
        public ResponseEntity<?> postUsuario(@RequestBody UsuarioDto usuarioDto){
            try {
                usuarioService.create(usuarioDto);
                return ResponseEntity.ok("Se creo correctamente");
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }

        @GetMapping("admin/usuario/all")
        public ResponseEntity<?> getAllUsuario(){
            try {
                return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listUsuario());
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
        }
        @GetMapping("admin/usuario/{id}")
        public ResponseEntity<?> getUsuarioId(@PathVariable("id") Long id){
            try {
                return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,  e.getMessage());
            }
        }

        @PutMapping("admin/usuario/put/{id}")
        public ResponseEntity<?> putUsuario(@RequestBody UsuarioDto usuarioDto, @PathVariable("id") Long id){
            try {
                usuarioService.edit(id, usuarioDto);
                return ResponseEntity.ok("Se edito correctamente");

            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }



        }


    }
