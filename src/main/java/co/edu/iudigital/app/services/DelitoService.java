package co.edu.iudigital.app.services;

import co.edu.iudigital.app.dtos.DelitoDTO;
import co.edu.iudigital.app.models.Delito;
import co.edu.iudigital.app.repositories.DelitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DelitoService {

    @Autowired
    private DelitoRepository delitoRepository;

    public List<DelitoDTO> getAllDelitos() {
        return ((List<Delito>) delitoRepository.findAll())
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public DelitoDTO getDelitoById(Long id) {
        Delito delito = delitoRepository.findById(id).orElse(null);
        return (delito != null) ? mapEntityToDto(delito) : null;
    }

    public DelitoDTO createDelito(DelitoDTO delitoDTO) {
        Delito delito = mapDtoToEntity(delitoDTO);
        Delito nuevoDelito = delitoRepository.save(delito);
        return mapEntityToDto(nuevoDelito);
    }

    public DelitoDTO updateDelito(Long id, DelitoDTO delitoDTO) {
        if (delitoRepository.existsById(id)) {
            Delito delito = mapDtoToEntity(delitoDTO);
            delito.setId(id);
            return mapEntityToDto(delitoRepository.save(delito));
        }
        return null;
    }

    public void deleteDelito(Long id) {
        delitoRepository.deleteById(id);
    }

    // Funciones de mapeo
    private DelitoDTO mapEntityToDto(Delito delito) {
        return new DelitoDTO(
                delito.getId(),
                delito.getNombre(),
                delito.getDescripcion()
        );
    }

    private Delito mapDtoToEntity(DelitoDTO delitoDTO) {
        Delito delito = new Delito();
        delito.setNombre(delitoDTO.getNombre());
        delito.setDescripcion(delitoDTO.getDescripcion());
        return delito;
    }
}
