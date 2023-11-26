package co.edu.iudigital.app.services;

import co.edu.iudigital.app.models.Caso;
import co.edu.iudigital.app.repositories.CasoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasoService {

    @Autowired
    private CasoRepository casoRepository;

    public List<Caso> getAllCasos() {
        return casoRepository.findAll();
    }

    public Caso getCasoById(Long id) {
        Optional<Caso> casoOptional = casoRepository.findById(id);
        return casoOptional.orElse(null);
    }

    public Caso createCaso(Caso caso) {
        // Implementa la lógica para crear un nuevo caso
        return casoRepository.save(caso);
    }

    public Caso updateCaso(Long id, Caso caso) {
        // Implementa la lógica para actualizar un caso existente
        if (casoRepository.existsById(id)) {
            caso.setId(id);
            return casoRepository.save(caso);
        }
        return null;
    }

    public void deleteCaso(Long id) {
        // Implementa la lógica para eliminar un caso por ID
        casoRepository.deleteById(id);
    }
}
