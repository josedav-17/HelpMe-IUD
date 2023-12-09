package co.edu.iudigital.app.services.ifaces;

import co.edu.iudigital.app.dtos.DelitoDTO;

import java.util.List;

public interface IDelitoService {
    List<DelitoDTO> getAllDelitos();

    DelitoDTO getDelitoById(Long id);

    DelitoDTO createDelito(DelitoDTO delitoDTO);

    DelitoDTO updateDelito(Long id, DelitoDTO delitoDTO);

    void deleteDelito(Long id);
}
