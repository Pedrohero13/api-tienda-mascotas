/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.mascotas.controller;

import com.grupo.mascotas.dto.MascotaDTO;
import com.grupo.mascotas.model.MascotasEntity;
import com.grupo.mascotas.service.MascotaService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SI-PEDRO-HERNANDEZ
 */
@RestController
@RequestMapping(value = "api/v1")
public class MascotasController {
    @Autowired
    private MascotaService mascotasService;
    
    @GetMapping(value = "/obtenerMascotas")
    public List<MascotasEntity> obtenerMascotas(){
        return mascotasService.obtenerMascotas();
    }
    
    @GetMapping(value = "/obtenerMascota/{id}")
    public MascotasEntity obtenerMascotas(@RequestParam("id") Long id_mascota){
        return mascotasService.obtenerMascota(id_mascota);
    }
    @PostMapping(value = "/agregarMascota")
    public MascotasEntity agregarMascota(@RequestBody MascotasEntity mascotaRequest){
        return mascotasService.agregarMascota(mascotaRequest);
    }
    
    @PutMapping(value = "/modificarMascota/{id}")
    public MascotasEntity modificarMascota(@RequestParam("id") Long id_mascota, @RequestBody MascotaDTO mascotaRequest){
        return mascotasService.modificarMascota(id_mascota,mascotaRequest);
    }
    @DeleteMapping(value = "/borrarMascota/{id}")
    public Map<String,String> borrarMascota(@RequestParam("id") Long id_mascota){
        return mascotasService.borrarMascota(id_mascota);
    }
}
