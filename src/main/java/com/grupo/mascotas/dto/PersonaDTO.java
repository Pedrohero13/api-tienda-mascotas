/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.mascotas.dto;

import lombok.Data;

/**
 *
 * @author SI-PEDRO-HERNANDEZ
 */
@Data
public class PersonaDTO {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String direccion;
    private String telefono; 
    private String email;
}
