package com.example.ExamenFinal.modelEntity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Usuario {
    //el entity es aquel que tiene la logica de negocio y o es el reflejo de la
    //base de datos en el codigo de java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String nombres;
    @Column
    private boolean admin;
    @Column
    private String apellidos;
    @Column
    private String password;
    @Column
    private String nickname;
    @Column
    private Integer edad;
    @Column
    private boolean status;
}



