package servicios;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import modelo.Cifrado;
import modelo.dao.UsuarioDAO;
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
                            usuarioConsultado.getPassword().equals(Cifrado.cifrarCadena(password))){
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
    
    @Path("eliminarUsuario")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarnota(
        @FormParam("idUsuario") Integer idUsuario
    ) {
        Mensaje mensaje = new Mensaje();
        boolean exito = false;
        
        try {
            exito = UsuarioDAO.eliminarUsuario(idUsuario);
            if (exito) {
                mensaje.setMensaje("Se eliminó el usuario");
            } else {
                mensaje.setMensaje("No se pudo eliminar el usuario");
            }
            
        } catch (Exception ioEx) {
            ioEx.printStackTrace();
            mensaje.setStatusMensaje(1);
            mensaje.setMensaje("Error al eliminar: " + ioEx.getMessage());
        }
        return mensaje;
    }
    
    @PUT
    @Path("actualizarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje actualizarUsuario(
        @FormParam("idUsuario") Integer idUsuario,
        @FormParam("nombre") String nombre,
        @FormParam("apPaterno") String apPaterno,
        @FormParam("apMaterno") String apMaterno,
        @FormParam("username") String username
    ) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        usuario.setNombre(nombre);
        usuario.setApPaterno(apPaterno);
        usuario.setApMaterno(apMaterno);
        usuario.setUsername(username);
        Mensaje mensaje = new Mensaje();
        try {
            UsuarioDAO.actualizarUsuario(usuario);
            mensaje.setMensaje("Se actualizó el usuario correctamente");
        } catch (Exception ioEx) {
            ioEx.printStackTrace();
            mensaje.setStatusMensaje(1);
            mensaje.setMensaje("Error al actualizar: " + ioEx.getMessage());
        }
        return mensaje;
    }

}
