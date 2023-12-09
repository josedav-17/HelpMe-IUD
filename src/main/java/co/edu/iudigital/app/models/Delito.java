package co.edu.iudigital.app.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "delitos")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(
            name = "nombre",
            nullable = false, unique = true, length = 120
    )
    String nombre;

    @Column(name = "descripcion", length = 120)
    String descripcion;

}
