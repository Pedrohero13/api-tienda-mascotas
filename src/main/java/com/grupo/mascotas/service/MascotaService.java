/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.mascotas.service;

import com.grupo.mascotas.dto.MascotaDTO;
import com.grupo.mascotas.model.MascotasEntity;
import com.grupo.mascotas.model.PersonaEntity;
import com.grupo.mascotas.repository.MascotasRepository;
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
public class MascotaService {

    @Autowired
    private MascotasRepository mascotasRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public List<MascotasEntity> obtenerMascotas() {
        return mascotasRepository.findAll();
    }

    public MascotasEntity obtenerMascota(Long id_mascota) {
        return mascotasRepository.findById(id_mascota).get();
    }

    public MascotasEntity agregarMascota(MascotaDTO mascotaRequest) {
        MascotasEntity mascotaPersis = new MascotasEntity();
        mascotaPersis.setNombre(mascotaRequest.getNombre());
        mascotaPersis.setFechaNacimiento(mascotaRequest.getFechaNacimiento());
        
        PersonaEntity persona =  personaRepository.findByEmail(mascotaRequest.getEmailPersona()).get();
        mascotaPersis.setPersona(persona);
        return mascotasRepository.save(mascotaPersis);
    }

    public MascotasEntity modificarMascota(Long id_mascota, MascotaDTO mascotaRequest) {
        return mascotasRepository.findById(id_mascota).map(mascota -> {
            mascota.setNombre(mascotaRequest.getNombre());
            mascota.setFechaNacimiento(mascotaRequest.getFechaNacimiento());
            return mascotasRepository.save(mascota);
        }).get();
    }

    public Map<String, String> borrarMascota(Long id_mascota) {
        MascotasEntity mascota = mascotasRepository.findById(id_mascota).get();

        Map<String, String> response = new HashMap<>();
        if (Objects.nonNull(mascota)) {
            mascotasRepository.deleteById(id_mascota);
            response.put("id", "1");
            response.put("mensaje", "Se borro correctamente");
        } else {
            response.put("id", "2");
            response.put("mensaje", "Ocurrio un error al borrar la entidad");
        }
        return response;
    }
}
