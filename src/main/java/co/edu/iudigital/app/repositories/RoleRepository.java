package co.edu.iudigital.app.repositories;

import co.edu.iudigital.app.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
