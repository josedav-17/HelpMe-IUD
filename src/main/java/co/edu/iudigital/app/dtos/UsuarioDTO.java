    package co.edu.iudigital.app.dtos;

    import co.edu.iudigital.app.models.Role;

    import java.time.LocalDate;
    import java.util.List;

    public class UsuarioDTO {

        private Long id;
        private String username;
        private String nombre;
        private String apellido;
        private String password;
        private LocalDate fechaNacimiento;
        private Boolean enabled;
        private String image;
        private Boolean redSocial;
        private List<Role> roles;

        // Constructores, getters y setters

        public UsuarioDTO() {
            // Constructor vacío necesario para la deserialización (si es necesario)
        }

        // Constructor para convertir desde una entidad Usuario
        public UsuarioDTO(Long id, String username, String nombre, String apellido, String password, LocalDate fechaNacimiento, Boolean enabled, String image, Boolean redSocial, List<Role> roles) {
            this.id = id;
            this.username = username;
            this.nombre = nombre;
            this.apellido = apellido;
            this.password = password;
            this.fechaNacimiento = fechaNacimiento;
            this.enabled = enabled;
            this.image = image;
            this.redSocial = redSocial;
            this.roles = roles;
        }


        // Getters y setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Boolean getRedSocial() {
            return redSocial;
        }

        public void setRedSocial(Boolean redSocial) {
            this.redSocial = redSocial;
        }

        public List<Role> getRoles() {
            return roles;
        }
        public void setRoles(List<Role> roles) {
            this.roles = roles;
        }
    }
