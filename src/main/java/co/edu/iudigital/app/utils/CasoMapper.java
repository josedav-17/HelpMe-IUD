package co.edu.iudigital.app.utils;

import co.edu.iudigital.app.dtos.CasoDTO;
import co.edu.iudigital.app.models.Caso;
import co.edu.iudigital.app.models.Delito;
import co.edu.iudigital.app.models.Usuario;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public class CasoMapper {

    public static final CasoMapper INSTANCE = new CasoMapper();

    private CasoMapper() {
        // Constructor privado para asegurar un patrón singleton
    }

    @Mapping(target = "id", ignore = true)
    public Caso toEntity(CasoDTO casoDTO) {
        if (casoDTO == null) {
            return null;
        }

        Caso caso = new Caso();
        caso.setId(casoDTO.getId());
        caso.setFechaHora(casoDTO.getFechaHora());
        caso.setLatitud(casoDTO.getLatitud());
        caso.setLongitud(casoDTO.getLongitud());
        caso.setAltitud(casoDTO.getAltitud());
        caso.setIsVisible(casoDTO.getIsVisible());
        caso.setDetalle(casoDTO.getDetalle());
        caso.setUrlMap(casoDTO.getUrlMap());
        caso.setRmiUrl(casoDTO.getRmiUrl());

        if (caso.getDelito() != null) {
            casoDTO.setDelitoId(caso.getDelito().getId());
        }

        if (caso.getUsuario() != null) {
            casoDTO.setUsuarioId(caso.getUsuario().getId());
        }

        return caso;
    }

    public CasoDTO toDto(Caso caso) {
        if (caso == null) {
            return null;
        }

        return new CasoDTO(
                caso.getId(),
                caso.getFechaHora(),
                caso.getLatitud(),
                caso.getLongitud(),
                caso.getAltitud(),
                caso.getIsVisible(),
                caso.getDetalle(),
                caso.getUrlMap(),
                caso.getRmiUrl(),
                (caso.getDelito() != null) ? caso.getDelito().getId() : null,
                (caso.getUsuario() != null) ? caso.getUsuario().getId() : null
        );
    }

    public List<CasoDTO> toCasosDTO(List<Caso> casos) {
        return casos.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<Caso> toCasos(List<CasoDTO> casosDTO) {
        return casosDTO.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
