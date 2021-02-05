package es.didiez.demo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author didiez
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA
public class Persona implements Serializable {
    @Id
    private Long id;
    private String nombre;
    private String apellidos;
}
