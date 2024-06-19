/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.mascotas.service;

import com.grupo.mascotas.dto.PersonaDTO;
import com.grupo.mascotas.model.PersonaEntity;
import com.grupo.mascotas.repository.PersonaRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SI-PEDRO-HERNANDEZ
 */
@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personasRepository;
    public List<PersonaEntity> obtenerPersonas (){
        return personasRepository.findAll();
    }
    
    public PersonaEntity obtenerPersona(Long id_persona){
        return personasRepository.findById(id_persona).get();
    }
    public PersonaEntity agregarPersona(PersonaEntity personaRequest){
        return personasRepository.save(personaRequest);
    }
    
   public PersonaEntity modificarPersona(Long id_persona, PersonaDTO personaRequest){
        return personasRepository.findById(id_persona).map(persona ->{
            persona.setNombre(personaRequest.getNombre());
            persona.setFechaNacimiento(personaRequest.getFechaNacimiento());
            return personasRepository.save(persona);
        }).get();
    }
   public Map<String, String> borrarPersona(Long id_persona){
        PersonaEntity persona = personasRepository.findById(id_persona).get();
        
        Map<String, String> response = new HashMap<>();
        if(Objects.nonNull(persona)){
            personasRepository.deleteById(id_persona);
            response.put("id", "1");
            response.put("mensaje","Se borro correctamente");
        }else{
            response.put("id", "2");
            response.put("mensaje","Ocurrio un error al borrar la entidad");
        }
           return response;
    }
}
