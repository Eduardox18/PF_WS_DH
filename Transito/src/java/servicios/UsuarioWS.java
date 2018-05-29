package servicios;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
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
        Mensaje mensajeRespuesta = new Mensaje();

        Usuario usuario = new Usuario(nombre, apPaterno, apMaterno, username,
            Cifrado.cifrarCadena(password), idCargo);

        try {
            UsuarioDAO.agregarUsuario(usuario);
            mensajeRespuesta.setMensaje("El usuario se agregó correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            mensajeRespuesta.setMensaje("Ocurrió un error al registrar el usuario");
        }
        return mensajeRespuesta;
    }

}
