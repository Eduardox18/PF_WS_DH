package servicios.pojos;

public class Usuario {
    private Integer idUsuario;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String username;
    private String password;
    private Integer idCargo;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, String apPaterno, String apMaterno, String username, String password, Integer idCargo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.username = username;
        this.password = password;
        this.idCargo = idCargo;
    }

    public Usuario(String nombre, String apPaterno, String apMaterno, String username, String cifrarCadena, Integer idCargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
    
    
}
