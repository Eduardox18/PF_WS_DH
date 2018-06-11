package servicios.pojos;

public class Fotografia {
    private Integer idFotografia;
    private byte[] foto;
    private String idReporte;
    private String fechaHora;

    public Fotografia() {
    }

    public Fotografia(byte[] foto, String idReporte, String fechaHora) {
        this.foto = foto;
        this.idReporte = idReporte;
        this.fechaHora = fechaHora;
    }

    public Integer getIdFotografia() {
        return idFotografia;
    }

    public void setIdFotografia(Integer idFotografia) {
        this.idFotografia = idFotografia;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    
}
