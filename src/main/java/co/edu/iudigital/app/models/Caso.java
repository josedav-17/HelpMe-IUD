package co.edu.iudigital.app.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "casos")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Caso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "fecha_hora", nullable = false)
    LocalDateTime fechaHora;

    @Column(nullable = false)
    Float latitud;

    @Column(nullable = false)
    Float longitud;

    @Column(nullable = false)
    Float altitud;

    @Column(name = "is_visible", nullable = false)
    Boolean isVisible;

    @Column(nullable = false, length = 255)
    String detalle;

    @Column(name = "url_map", length = 255)
    String urlMap;

    @Column(name = "mi_url", length = 255)
    String miUrl;

    @ManyToOne
    @JoinColumn(name = "delitos_id", nullable = false)
    Delito delito;

    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = false)
    Usuario usuario;
}
