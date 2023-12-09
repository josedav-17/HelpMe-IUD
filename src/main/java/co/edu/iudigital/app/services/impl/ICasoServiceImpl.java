package co.edu.iudigital.app.services.impl;

import co.edu.iudigital.app.dtos.CasoDTO;
import co.edu.iudigital.app.models.Caso;
import co.edu.iudigital.app.repositories.ICasoRepository;
import co.edu.iudigital.app.services.ifaces.ICasoService;
import co.edu.iudigital.app.utils.CasoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ICasoServiceImpl implements ICasoService {

    @Autowired
    private ICasoRepository casoRepository;

    @Override
    public List<CasoDTO> getAllCasos() {
        Iterable<Caso> casos = casoRepository.findAll();
        return StreamSupport.stream(casos.spliterator(), false)
                .map(CasoMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CasoDTO getCasoById(Long id) {
        Optional<Caso> casoOptional = casoRepository.findById(id);
        return casoOptional.map(CasoMapper.INSTANCE::toDto).orElse(null);
    }

    @Override
    public CasoDTO createCaso(CasoDTO casoDTO) {
        Caso caso = CasoMapper.INSTANCE.toEntity(casoDTO);
        Caso nuevoCaso = casoRepository.save(caso);
        return CasoMapper.INSTANCE.toDto(nuevoCaso);
    }

    @Override
    public CasoDTO updateCaso(Long id, CasoDTO casoDTO) {
        if (casoRepository.existsById(id)) {
            Caso caso = CasoMapper.INSTANCE.toEntity(casoDTO);
            caso.setId(id);
            return CasoMapper.INSTANCE.toDto(casoRepository.save(caso));
        }
        return null;
    }


    @Override
    public void deleteCaso(Long id) {
        casoRepository.deleteById(id);
    }
}
