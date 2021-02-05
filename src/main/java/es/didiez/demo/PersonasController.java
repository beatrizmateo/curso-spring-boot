package es.didiez.demo;

import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author didiez
 */
@Controller
@RequiredArgsConstructor
public class PersonasController {
    
    private final PersonaRepository personaRepository;
    
    @GetMapping("/personas")
    String personas(Model model, @ModelAttribute Filtros filtros){
        final List<PersonaVista> personas = personaRepository.findAll().stream()
                .map(this::toPersonaVista)
                .filter(filtros::filter)
                .collect(toList());
        model.addAttribute("personas", personas);
        model.addAttribute("filtros", filtros);
        return "personas/listado";
    }
    
    private PersonaVista toPersonaVista(Persona persona){
        return new PersonaVista(persona.getId(), persona.getNombre(), persona.getApellidos());
    }
    
    @Value
    static class Filtros {
        String nombre;
        String apellidos;
        
        /**
         * Filtra con todos los campos como AND
         * @param persona
         * @return 
         */
        boolean filter(PersonaVista persona){
            return containsIgnoreCase(persona.getNombre(), nombre)
                    && containsIgnoreCase(persona.getApellidos(), apellidos);
        }
        
        private boolean containsIgnoreCase(String cadena, @Nullable String fragmento){
            return cadena.toLowerCase().contains(Optional.ofNullable(fragmento).map(String::toLowerCase).orElse(""));
        }
    }
    
    @Value
    static class PersonaVista {
        Long id;
        String nombre;
        String apellidos;
    }
}
