package servicios.pojos;

import java.util.Date;

public class ResultadoReporte {
    private String idReporte;
    private String noPlaca;
    private String nombreSiniestro;
    private String apPaternoSiniestro;
    private String fechaHora;

    public ResultadoReporte() {
    }

    public ResultadoReporte(String noPlaca, String nombreSiniestro, String apPaternoSiniestro, String fechaHora) {
        this.noPlaca = noPlaca;
        this.nombreSiniestro = nombreSiniestro;
        this.apPaternoSiniestro = apPaternoSiniestro;
        this.fechaHora = fechaHora;
    }

    public String getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    public String getNoPlaca() {
        return noPlaca;
    }

    public void setNoPlaca(String noPlaca) {
        this.noPlaca = noPlaca;
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

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
}
