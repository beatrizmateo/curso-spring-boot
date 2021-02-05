package es.didiez.demo;

import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author didiez
 */
@Repository
public class PersonaInMemoryRepository implements PersonaRepository {
    
//    private final List<Persona> PERSONAS = List.of(
//            new Persona(1L, "Doe, Jane"),
//            new Persona(2L, "Doe, John"),
//            new Persona(3L, "Smith, John")
//    );
    
    @Override
    public List<Persona> findAll(){
        return Collections.emptyList();
    }
    
}
