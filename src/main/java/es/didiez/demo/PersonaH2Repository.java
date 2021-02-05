package es.didiez.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author didiez
 */
@Primary
public interface PersonaH2Repository extends JpaRepository<Persona, Long>, PersonaRepository {
    
}
