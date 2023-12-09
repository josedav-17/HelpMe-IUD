package co.edu.iudigital.app.services.ifaces;

import co.edu.iudigital.app.dtos.CasoDTO;

import java.util.List;

public interface ICasoService {
    List<CasoDTO> getAllCasos();
    CasoDTO getCasoById(Long id);
    CasoDTO createCaso(CasoDTO casoDTO);
    CasoDTO updateCaso(Long id, CasoDTO casoDTO);
    void deleteCaso(Long id);
}
