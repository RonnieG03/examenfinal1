package com.example.ExamenFinal.service;

import com.example.ExamenFinal.modelDto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    void create(UsuarioDto usuarioDto);
    List<UsuarioDto> listUsuario();
    void edit(Long id,UsuarioDto usuarioDto);
    UsuarioDto findById(Long id);
    Boolean exists(Long id);



}
