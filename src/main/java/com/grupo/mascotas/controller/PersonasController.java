/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.mascotas.controller;

import com.grupo.mascotas.dto.PersonaDTO;
import com.grupo.mascotas.model.PersonaEntity;
import com.grupo.mascotas.service.PersonaService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SI-PEDRO-HERNANDEZ
 */
@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin(origins = "https://mascotas-9d984.web.app/")
public class PersonasController {
    @Autowired
    private PersonaService personaService;
    
    @GetMapping(value = "/obtenerPersonas")
    public List<PersonaEntity> obtenerPersonas(){
        return personaService.obtenerPersonas();
    }
    
    @GetMapping(value = "/obtenerPersona/{id_persona}")
    public PersonaEntity obtenerPersonas(@PathVariable Long id_persona){
        return personaService.obtenerPersona(id_persona);
    }
    @PostMapping(value = "/agregarPersona")
    public PersonaEntity agregarPersona(@RequestBody PersonaEntity personaRequest){
        return personaService.agregarPersona(personaRequest);
    }
    
    @PutMapping(value = "/modificarPersona/{id_persona}")
    public PersonaEntity modificarPersona(@PathVariable Long id_persona, @RequestBody PersonaDTO personaRequest){
        return personaService.modificarPersona(id_persona,personaRequest);
    }
    @DeleteMapping(value = "/borrarPersona/{id_persona}")
    public Map<String,String> borrarPersona(@PathVariable Long id_persona){
        return personaService.borrarPersona(id_persona);
    }
}
