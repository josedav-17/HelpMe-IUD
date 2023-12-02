# HelpMe-IUD
  ## Proyecto diplomado HelpMe-IUD - Back-End

# Integrantes del equipo
Julian Valencia.
  
Mateo Arango Rodriguez.
  
John Alejandro Vallejo Ramirez.
  
José David Cardona.

# Configuración del Proyecto

### Requisitos Previos

Asegúrate de tener instalados los siguientes elementos antes de ejecutar la aplicación:

- Java Development Kit (JDK) 8 o superior: [Descargar JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- Maven: [Descargar Maven](https://maven.apache.org/download.cgi)
- Base de datos (por ejemplo, MySQL): [Descargar MySQL](https://dev.mysql.com/downloads/)

### Configuración de la Base de Datos

1. Crea una base de datos en tu servidor de MySQL. Puedes utilizar la siguiente configuración en tu archivo `application.properties` para Spring Boot:
   
   spring.datasource.url=jdbc:mysql://localhost:3306/tu_basedatos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   
2. Asegúrate de que las tablas se creen automáticamente al iniciar la aplicación. Puedes configurar esto en el archivo application.properties también:
   
   spring.jpa.hibernate.ddl-auto=update


# Ejecutar la Aplicación

1. Abre una terminal y navega al directorio del proyecto
   
2. Ejecuta la aplicación usando Maven:
    mvn spring-boot:run

# Estructura del Proyecto
La estructura del proyecto sigue una convención común de proyectos Spring Boot. A continuación, se presenta una descripción general de los directorios y paquetes más relevantes:

- **src/main/java/co.edu.iudigital.app.controllers**: Contiene las clases controladoras que gestionan las solicitudes HTTP.
- **src/main/java/co.edu.iudigital.app.models**: Define las entidades del modelo de datos de la aplicación.
- **src/main/java/co.edu.iudigital.app.repositories**: Contiene las interfaces de repositorio para interactuar con la base de datos.
- **src/main/java/co.edu.iudigital.app.services**: Alberga las interfaces y las implementaciones de los servicios de la aplicación.
- **src/main/resources**: Contiene archivos de configuración y recursos estáticos, como plantillas HTML.

# Tecnologías Utilizadas
- Java
- Spring Boot
- MySQL (OPCIONAL, MOTOR DE BASE DE DATOS DE PREFERENCIA)
- Hibernate 
- HTML/CSS (PARA FUTURA VERSIÓN WEB)

# Modelo de Datos

La aplicación HelpMeIUD utiliza las siguientes entidades principales:

### Delito

- **id**: Identificador único del delito (Primary Key)
- **nombre**: Nombre del delito
- **descripcion**: Descripción del delito

### Role

- **id**: Identificador único del rol (Primary Key)
- **nombre**: Nombre del rol
- **descripcion**: Descripción del rol

### Usuario

- **id**: Identificador único del usuario (Primary Key)
- **username**: Nombre de usuario único
- **nombre**: Nombre del usuario
- **apellido**: Apellido del usuario
- **password**: Contraseña del usuario
- **fechaNacimiento**: Fecha de nacimiento del usuario
- **enabled**: Indica si el usuario está habilitado o deshabilitado
- **image**: URL de la imagen del usuario
- **redSocial**: Indica si el usuario se registró a través de una red social

### Caso

- **id**: Identificador único del caso (Primary Key)
- **fechaHora**: Fecha y hora del caso
- **latitud**: Latitud del caso
- **longitud**: Longitud del caso
- **altitud**: Altitud del caso
- **isVisible**: Indica si el caso es visible públicamente
- **detalle**: Detalle del caso
- **urlMap**: URL del mapa asociado al caso
- **miUrl**: URL personalizada del caso
- **delito**: Relación con la entidad Delito (Many-to-One)
- **usuario**: Relación con la entidad Usuario (Many-to-One)

# contacto
UNIVERSIDAD DIGITAL DE ANTIOQUIA - DIPLOMADO EN PROGRAMACION WEB - 2023 





