package co.edu.iudigital.app.repositories;

import co.edu.iudigital.app.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Pueden agregar consultas personalizadas si es necesario
}
