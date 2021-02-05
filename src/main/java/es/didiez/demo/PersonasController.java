package es.didiez.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author didiez
 */
@Controller
public class PersonasController {
    
    @GetMapping("/personas")
    String personas(){
        return "personas/listado";
    }
}
