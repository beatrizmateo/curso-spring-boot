package es.didiez.demo;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner populatePersonas(PersonaH2Repository personaH2Repository){
//        return args -> {
//            personaH2Repository.saveAll(List.of(
//            new Persona(1L, "Doe, Jane"),
//            new Persona(2L, "Doe, John"),
//            new Persona(3L, "Smith, John")));
//        };
//    }
    
}
