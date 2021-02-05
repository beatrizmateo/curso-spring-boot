package es.didiez.demo;

import lombok.RequiredArgsConstructor;
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
        model.addAttribute("personas", personaRepository.findAll());        
        return "personas/listado";
    }
}
