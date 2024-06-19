/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.mascotas.repository;

import com.grupo.mascotas.model.MascotasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author SI-PEDRO-HERNANDEZ
 */
public interface MascotasRepository extends JpaRepository<MascotasEntity, Long>{
    
}
