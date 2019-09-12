package com.votacion.votacion.controller;

import com.votacion.votacion.repository.VotacionesRepository;

import java.util.List;

import com.votacion.votacion.model.respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class votacionController{
    @Autowired
    VotacionesRepository Repositorio;

    @GetMapping("getData")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<respuesta>> getAllVotos(){
        return ResponseEntity.ok((List)Repositorio.findAll());
    }

    @GetMapping("getDataSupervisor")
    @PreAuthorize("hasAuthority('ROLE_SUPERUSER')")
    public ResponseEntity<List<respuesta>> getAllVotos2(){
        return ResponseEntity.ok((List)Repositorio.findAll());
    }


    @GetMapping("getDataUser")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<respuesta>> getAllVotos3(){
        return ResponseEntity.ok((List)Repositorio.findAll());
    }



}