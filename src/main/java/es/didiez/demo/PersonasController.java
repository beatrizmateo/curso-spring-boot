package es.didiez.demo;

import java.util.List;
import static java.util.stream.Collectors.toList;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author didiez
 */
@Controller
@RequiredArgsConstructor
public class PersonasController {
    
    private final PersonaRepository personaRepository;
    
    @GetMapping("/personas")
    String personas(Model model){
        final List<PersonaVista> personas = personaRepository.findAll().stream()
                .map(this::toPersonaVista)
                .collect(toList());
        model.addAttribute("personas", personas);        
        return "personas/listado";
    }
    
    private PersonaVista toPersonaVista(Persona persona){
        String[] apellidosNombre = persona.getNombre().split(",");
        return new PersonaVista(persona.getId(), apellidosNombre[1], apellidosNombre[0]);
    }
    
    @Value
    static class PersonaVista {
        Long id;
        String nombre;
        String apellidos;
    }
}
