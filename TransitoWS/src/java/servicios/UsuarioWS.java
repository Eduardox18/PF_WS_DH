package servicios;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import modelo.Cifrado;
import modelo.dao.ConductorDAO;
import modelo.dao.UsuarioDAO;
import modelo.mybatis.MyBatisUtils;
import servicios.pojos.Conductor;
import servicios.pojos.Mensaje;
import servicios.pojos.Usuario;

/**
 *
 * @author yamii
 */
@Path("usuario")
public class UsuarioWS {

    @Context
    private UriInfo context;

    public UsuarioWS() {
    }

    /**
     * Registra un usuario a la base de datos de acuerdo a su cargo 
     * (administrativo, perito, soporte, atención)
     * @param nombre nombre del usuario
     * @param apPaterno apellido paterno del usuario
     * @param apMaterno apellido materno del usuario
     * @param username nombre de usuario para ingreso al sistema
     * @param password contraseña de usuario
     * @param idCargo cargo que tiene (de los mencionados arriba)
     * @return 
     */
    @Path("registrarUsuario")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarUsuario(
        @FormParam("nombre") String nombre,
        @FormParam("apPaterno") String apPaterno,
        @FormParam("apMaterno") String apMaterno,
        @FormParam("username") String username,
        @FormParam("password") String password,
        @FormParam("idCargo") Integer idCargo) {
        Mensaje mensaje = new Mensaje();

        Usuario usuario = new Usuario(nombre, apPaterno, apMaterno, username,
            Cifrado.cifrarCadena(password), idCargo);

        try {
            UsuarioDAO.agregarUsuario(usuario);
            mensaje.setMensaje("El usuario se agregó correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            mensaje.setMensaje("Ocurrió un error al registrar el usuario");
        }
        return mensaje;
    }
    
    /**
     * Verifica los datos del usuario que trata de iniciar sesión, en caso de ser correctos, lo deja
     * continuar en la aplicación
     * @param nombreUsuario El nombre del usuario que trata de ingresar
     * @param password La contreaseña cifrada del usuario
     * @return Mensaje con el estado correspondiente según el resultado
     */
    @Path("iniciarSesion")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje iniciarSesion(
            @FormParam("nombreUsuario") String nombreUsuario,
            @FormParam("password") String password){
        Mensaje mensaje = new Mensaje();
        Usuario usuarioConsultado = null;
        Integer status;
        
        try {
            if (nombreUsuario != null && password != null) {
                usuarioConsultado = UsuarioDAO.iniciarSesion(nombreUsuario);
                if (usuarioConsultado != null) {
                    if(usuarioConsultado.getUsername().equals(nombreUsuario) && 
                            usuarioConsultado.getPassword().equals(password)){
                        mensaje.setMensaje("Inicio exitoso");
                        mensaje.setStatusMensaje(250);
                    } else {
                        mensaje.setMensaje("Los datos del usuario son incorrectos");
                        mensaje.setStatusMensaje(251);
                    }
                } else {
                    mensaje.setMensaje("El usuario no se encuentra registrado");
                    mensaje.setStatusMensaje(253);
                }
            }
        } catch (Exception ex) {
            mensaje.setMensaje(ex.getMessage());
            mensaje.setStatusMensaje(1);
        }
        return mensaje;
    }

}
