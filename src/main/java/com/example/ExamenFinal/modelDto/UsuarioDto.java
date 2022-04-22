package com.example.ExamenFinal.modelDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.intellij.lang.annotations.Pattern;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private String nombres;
    private String apellidos;
    private Integer edad;
    private String nickname;
    private String password;
    private boolean status;

}