package co.edu.iudigital.app.services.impl;

import co.edu.iudigital.app.dtos.DelitoDTO;
import co.edu.iudigital.app.models.Delito;
import co.edu.iudigital.app.repositories.IDelitoRepository;
import co.edu.iudigital.app.services.ifaces.IDelitoService;
import co.edu.iudigital.app.utils.DelitoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IDelitoServiceImpl implements IDelitoService {

    @Autowired
    private IDelitoRepository iDelitoRepository;

    @Autowired
    private DelitoMapper mapper;

    @Override
    public List<DelitoDTO> getAllDelitos() {
        return iDelitoRepository.findAll().stream()
                .map(mapper::toDelitoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DelitoDTO getDelitoById(Long id) {
        return iDelitoRepository.findById(id)
                .map(mapper::toDelitoDTO)
                .orElse(null);
    }

    @Override
    public DelitoDTO createDelito(DelitoDTO delitoDTO) {
        Delito delito = mapper.toDelito(delitoDTO);
        Delito nuevoDelito = iDelitoRepository.save(delito);
        return mapper.toDelitoDTO(nuevoDelito);
    }

    @Override
    public DelitoDTO updateDelito(Long id, DelitoDTO delitoDTO) {
        if (iDelitoRepository.existsById(id)) {
            Delito delito = mapper.toDelito(delitoDTO);
            delito.setId(id);
            return mapper.toDelitoDTO(iDelitoRepository.save(delito));
        }
        return null;
    }

    @Override
    public void deleteDelito(Long id) {
        iDelitoRepository.deleteById(id);
    }
}
