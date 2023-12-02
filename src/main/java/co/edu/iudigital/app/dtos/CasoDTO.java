package co.edu.iudigital.app.dtos;

import lombok.Getter;

import java.time.LocalDateTime;

public class CasoDTO {

    @Getter
    private Long id;
    @Getter
    private LocalDateTime fechaHora;
    @Getter
    private Float latitud;
    @Getter
    private Float longitud;
    @Getter
    private Float altitud;
    private Boolean isVisible;
    @Getter
    private String detalle;
    @Getter
    private String urlMap;
    @Getter
    private String rmiUrl;
    @Getter
    private Long delitoId;
    @Getter
    private Long usuarioId;

    // Constructores, getters y setters

    public CasoDTO() {
        // Constructor vacío necesario para la deserialización (si es necesario)
    }

    // Constructor para convertir desde una entidad Caso
    public CasoDTO(Long id, LocalDateTime fechaHora, Float latitud, Float longitud,
                   Float altitud, Boolean isVisible, String detalle, String urlMap,
                   String rmiUrl, Long delitoId, Long usuarioId) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.latitud = latitud;
        this.longitud = longitud;
        this.altitud = altitud;
        this.isVisible = isVisible;
        this.detalle = detalle;
        this.urlMap = urlMap;
        this.rmiUrl = rmiUrl;
        this.delitoId = delitoId;
        this.usuarioId = usuarioId;
    }

    // Getters y setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public void setAltitud(Float altitud) {
        this.altitud = altitud;
    }

    public Boolean getVisible() {
        return isVisible;
    }

    public void setVisible(Boolean visible) {
        isVisible = visible;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setUrlMap(String urlMap) {
        this.urlMap = urlMap;
    }

    public void setRmiUrl(String rmiUrl) {
        this.rmiUrl = rmiUrl;
    }

    public void setDelitoId(Long delitoId) {
        this.delitoId = delitoId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
