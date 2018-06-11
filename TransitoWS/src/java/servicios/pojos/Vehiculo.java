package servicios.pojos;

public class Vehiculo {
    private Integer idVehiculo;
    private String noPlaca;
    private String modelo;
    private Integer anio;
    private String noPolizaSeguro;
    private Integer idMarca;
    private Integer idAseguradora;
    private Integer idColor;
    private String idConductor;

    public Vehiculo() {
    }

    public Vehiculo(String noPlaca, String modelo, Integer anio, String noPolizaSeguro, Integer idMarca, Integer idAseguradora, Integer idColor, String idConductor) {
        this.noPlaca = noPlaca;
        this.modelo = modelo;
        this.anio = anio;
        this.noPolizaSeguro = noPolizaSeguro;
        this.idMarca = idMarca;
        this.idAseguradora = idAseguradora;
        this.idColor = idColor;
        this.idConductor = idConductor;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNoPlaca() {
        return noPlaca;
    }

    public void setNoPlaca(String noPlaca) {
        this.noPlaca = noPlaca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getNoPolizaSeguro() {
        return noPolizaSeguro;
    }

    public void setNoPolizaSeguro(String noPolizaSeguro) {
        this.noPolizaSeguro = noPolizaSeguro;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getIdAseguradora() {
        return idAseguradora;
    }

    public void setIdAseguradora(Integer idAseguradora) {
        this.idAseguradora = idAseguradora;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public String getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(String idConductor) {
        this.idConductor = idConductor;
    }
}
