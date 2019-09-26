package com.example.demo.repository;

import com.example.demo.model.Demobook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemobookRepository
        extends CrudRepository<Demobook, String> {

}