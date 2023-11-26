package co.edu.iudigital.app.services;

import co.edu.iudigital.app.models.Delito;
import co.edu.iudigital.app.repositories.DelitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DelitoService {

    @Autowired
    private DelitoRepository delitoRepository;

    public List<Delito> getAllDelitos() {
        return delitoRepository.findAll();
    }

    public Delito getDelitoById(Long id) {
        return delitoRepository.findById(id).orElse(null);
    }

    public Delito createDelito(Delito delito) {
        return delitoRepository.save(delito);
    }

    public Delito updateDelito(Long id, Delito delito) {
        if (delitoRepository.existsById(id)) {
            delito.setId(id);
            return delitoRepository.save(delito);
        }
        return null;
    }

    public void deleteDelito(Long id) {
        delitoRepository.deleteById(id);
    }
}
