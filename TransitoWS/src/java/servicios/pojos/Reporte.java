package servicios.pojos;

public class Reporte {
    private Integer idReporte;
    private Float latitud;
    private Float longitud;
    private String nombreSiniestro;
    private String apPaternoSiniestro;
    private String apMaternoSiniestro;
    private String fechaHora;
    private Integer idConductor;
    private String idVehiculoConductor;
    private String idVehiculoSiniestro;

    public Reporte() {
    }

    public Reporte(Integer idReporte, Float latitud, Float longitud, String nombreSiniestro, String apPaternoSiniestro, String apMaternoSiniestro, String fechaHora, Integer idConductor, String idVehiculoConductor, String idVehiculoSiniestro) {
        this.idReporte = idReporte;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombreSiniestro = nombreSiniestro;
        this.apPaternoSiniestro = apPaternoSiniestro;
        this.apMaternoSiniestro = apMaternoSiniestro;
        this.fechaHora = fechaHora;
        this.idConductor = idConductor;
        this.idVehiculoConductor = idVehiculoConductor;
        this.idVehiculoSiniestro = idVehiculoSiniestro;
    }

    public Reporte(Float latitud, Float longitud, String nombreSiniestro, String apPaternoSiniestro, String apMaternoSiniestro, String fechaHora, Integer idConductor, String idVehiculoConductor, String idVehiculoSiniestro) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombreSiniestro = nombreSiniestro;
        this.apPaternoSiniestro = apPaternoSiniestro;
        this.apMaternoSiniestro = apMaternoSiniestro;
        this.fechaHora = fechaHora;
        this.idConductor = idConductor;
        this.idVehiculoConductor = idVehiculoConductor;
        this.idVehiculoSiniestro = idVehiculoSiniestro;
    }
    
    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float Longitud) {
        this.longitud = Longitud;
    }

    public String getNombreSiniestro() {
        return nombreSiniestro;
    }

    public void setNombreSiniestro(String nombreSiniestro) {
        this.nombreSiniestro = nombreSiniestro;
    }

    public String getApPaternoSiniestro() {
        return apPaternoSiniestro;
    }

    public void setApPaternoSiniestro(String apPaternoSiniestro) {
        this.apPaternoSiniestro = apPaternoSiniestro;
    }

    public String getApMaternoSiniestro() {
        return apMaternoSiniestro;
    }

    public void setApMaternoSiniestro(String apMaternoSiniestro) {
        this.apMaternoSiniestro = apMaternoSiniestro;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public String getIdVehiculoConductor() {
        return idVehiculoConductor;
    }

    public void setIdVehiculoConductor(String idVehiculoConductor) {
        this.idVehiculoConductor = idVehiculoConductor;
    }

    public String getIdVehiculoSiniestro() {
        return idVehiculoSiniestro;
    }

    public void setIdVehiculoSiniestro(String idVehiculoSiniestro) {
        this.idVehiculoSiniestro = idVehiculoSiniestro;
    }
}
