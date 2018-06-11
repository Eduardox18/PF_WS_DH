package servicios.pojos;

public class DictamenReporte {
    private Integer folio;
    private String descripcion;
    private String estado;
    private String fechaHora;
    private Integer idReporte;
    private Integer idPerito;

    public DictamenReporte() {
    }

    public DictamenReporte(Integer folio, String descripcion, String estado, String fechaHora, Integer idReporte, Integer idPerito) {
        this.folio = folio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.idReporte = idReporte;
        this.idPerito = idPerito;
    }

    public DictamenReporte(String descripcion, String estado, String fechaHora, Integer idReporte, Integer idPerito) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.idReporte = idReporte;
        this.idPerito = idPerito;
    }
    

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public Integer getIdPerito() {
        return idPerito;
    }

    public void setIdPerito(Integer idPerito) {
        this.idPerito = idPerito;
    }
    
    
}
