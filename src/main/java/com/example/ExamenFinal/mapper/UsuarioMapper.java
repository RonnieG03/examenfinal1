package com.example.ExamenFinal.mapper;

import com.example.ExamenFinal.modelDto.UsuarioDto;
import com.example.ExamenFinal.modelEntity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioMapper {

        @Autowired
        private ModelMapper modelMapper;

        @Autowired
        public UsuarioMapper(ModelMapper modelMapper){
            this.modelMapper = modelMapper;
        }

        public Usuario map(UsuarioDto UsuarioDto){
            return modelMapper.map(UsuarioDto, Usuario.class);
        }
        public UsuarioDto map(Usuario UsuarioEntity){
            return modelMapper.map(UsuarioEntity,UsuarioDto.class);
        }

        public List<UsuarioDto> map(List<Usuario> UsuarioEntityList){
            List<UsuarioDto> UsuarioDtoList = new ArrayList<>();
            UsuarioEntityList.forEach(Usuario -> UsuarioDtoList.add(map(Usuario)));
            return UsuarioDtoList;
        }
    }

