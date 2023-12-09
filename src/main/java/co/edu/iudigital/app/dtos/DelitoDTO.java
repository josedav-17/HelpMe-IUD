package co.edu.iudigital.app.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DelitoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
}
