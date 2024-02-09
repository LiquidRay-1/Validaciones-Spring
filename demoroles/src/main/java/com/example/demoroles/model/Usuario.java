package com.example.demoroles.model;

import com.example.demoroles.model.enums.RolEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El campo usuario no puede estar vacío")
    private String username;
    @NotBlank(message = "El campo de la contraseña no puede estar vacío")
    private String password;

    @Enumerated(EnumType.STRING)
    private RolEnum rol;
}
