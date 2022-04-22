package com.example.ExamenFinal.service.impl;

import com.example.ExamenFinal.mapper.UsuarioMapper;
import com.example.ExamenFinal.modelDto.UsuarioDto;
import com.example.ExamenFinal.modelEntity.Usuario;
import com.example.ExamenFinal.repository.UsuarioRepository;
import com.example.ExamenFinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;


    @Override
    public void create(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.map(usuarioDto);

        if(usuarioDto.getNombres() != null){
            usuario.setNombres(usuarioDto.getNombres());
        }
        if(usuarioDto.getApellidos() != null){
            usuario.setApellidos(usuarioDto.getApellidos());
        }
        if(usuarioDto.getEdad() != null){
            usuario.setEdad(usuarioDto.getEdad());
        }
        if(usuarioDto.getNickname() != null){
            usuario.setNickname(usuarioDto.getNickname());
        }
        if(usuarioDto.getPassword() != null){
            usuario.setPassword(usuarioDto.getPassword());
        }
        if(usuarioDto.isStatus() == false){
            usuario.setStatus(usuarioDto.isStatus());
        }

        usuarioRepository.save(usuario);
    }

    @Override
    public List<UsuarioDto> listUsuario() {
        return usuarioMapper.map(usuarioRepository.findAll());
    }

    @Override
    public void edit(Long id, UsuarioDto usuarioDto) {
        try {
            Optional<Usuario> usuario = usuarioRepository.findById(id);

            if(usuario != null){
                if(usuarioDto.getNombres() != null){
                    usuario.get().setNombres(usuarioDto.getNombres());
                }
                if(usuarioDto.getApellidos() != null){
                    usuario.get().setApellidos(usuarioDto.getApellidos());
                }
                if(usuarioDto.getEdad() != null){
                    usuario.get().setEdad(usuarioDto.getEdad());
                }
                if(usuarioDto.getNickname() != null){
                    usuario.get().setNickname(usuarioDto.getNickname());
                }
                if(usuarioDto.getPassword() != null){
                    usuario.get().setPassword(usuarioDto.getPassword());
                }
                if(usuarioDto.isStatus()){
                    usuario.get().setStatus(usuarioDto.isStatus());
                }

                usuarioRepository.save(usuario.orElse(null));
            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "notFound");
        }
    }

    @Override
    public UsuarioDto findById(Long id) {
        Optional<Usuario> client = usuarioRepository.findById(id);
        return usuarioMapper.map(client.orElse(null));

    }

    @Override
    public Boolean exists(Long id) {
        return null;
    }

    public boolean isAdmin(String nickName,String password) {
        Optional<Usuario> clientNick = usuarioRepository.findByNickname(nickName);
        Optional<Usuario> clientPass = usuarioRepository.findByPassword(password);


        if (clientNick.get().isAdmin() && clientNick.isPresent() && clientPass.isPresent()) {
            return true;
        }
    return  false;
    }

}


