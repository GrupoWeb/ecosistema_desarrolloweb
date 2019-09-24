package com.votacion.votacion.repository;

// import com.votacion.votacion.model.respuesta;
import com.votacion.votacion.model.resultado;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacionesRepository extends CrudRepository<resultado, Integer >{
    
}