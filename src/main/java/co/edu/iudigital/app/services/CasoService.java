package co.edu.iudigital.app.services;

import co.edu.iudigital.app.dtos.CasoDTO;
import co.edu.iudigital.app.models.Caso;
import co.edu.iudigital.app.models.Delito;
import co.edu.iudigital.app.models.Usuario;
import co.edu.iudigital.app.repositories.CasoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CasoService {

    @Autowired
    private CasoRepository casoRepository;

    // Obtener todos los casos
    public List<CasoDTO> getAllCasos() {
        return ((List<Caso>) casoRepository.findAll())
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    // Obtener un caso por ID
    public CasoDTO getCasoById(Long id) {
        Optional<Caso> casoOptional = casoRepository.findById(id);
        return casoOptional.map(this::mapEntityToDto).orElse(null);
    }

    // Crear un nuevo caso
    public CasoDTO createCaso(CasoDTO casoDTO) {
        Caso caso = mapDtoToEntity(casoDTO);
        Caso nuevoCaso = casoRepository.save(caso);
        return mapEntityToDto(nuevoCaso);
    }

    // Actualizar un caso existente
    public CasoDTO updateCaso(Long id, CasoDTO casoDTO) {
        if (casoRepository.existsById(id)) {
            Caso caso = mapDtoToEntity(casoDTO);
            caso.setId(id);
            return mapEntityToDto(casoRepository.save(caso));
        }
        return null;
    }

    // Eliminar un caso por ID
    public void deleteCaso(Long id) {
        casoRepository.deleteById(id);
    }

    // Funciones de mapeo
    private CasoDTO mapEntityToDto(Caso caso) {
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

    private Caso mapDtoToEntity(CasoDTO casoDTO) {
        Caso caso = new Caso();
        caso.setFechaHora(casoDTO.getFechaHora());
        caso.setLatitud(casoDTO.getLatitud());
        caso.setLongitud(casoDTO.getLongitud());
        caso.setAltitud(casoDTO.getAltitud());
        caso.setIsVisible(casoDTO.getVisible());
        caso.setDetalle(casoDTO.getDetalle());
        caso.setUrlMap(casoDTO.getUrlMap());
        caso.setRmiUrl(casoDTO.getRmiUrl());

        if(casoDTO.getDelitoId() != null) {
            Delito delito = new Delito();
            delito.setId(casoDTO.getDelitoId());
            caso.setDelito(delito);
        }

        if (casoDTO.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(casoDTO.getUsuarioId());
            caso.setUsuario(usuario);
        }

        return caso;
    }
}
