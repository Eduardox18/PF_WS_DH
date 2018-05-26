package servicios;

import gateway.sms.JaxSms;
import java.io.IOException;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import modelo.dao.ConductorDAO;
import servicios.pojos.Conductor;
import servicios.pojos.Mensaje;
import servicios.pojos.RespuestaEmailSMS;
import java.util.Random;
import modelo.Cifrado;
import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

@Path("conductor")
public class ConductorWS {

    @Context
    private UriInfo context;

    public ConductorWS() {
    }

    @Path("agregarConductor")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje agregarUsuario(
            @FormParam("nombre") String nombre,
            @FormParam("apPaterno") String apPaterno,
            @FormParam("apMaterno") String apMaterno,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("noLicencia") String noLicencia,
            @FormParam("telCelular") String telCelular,
            @FormParam("password") String password) {
        Mensaje mensajeRespuesta = new Mensaje();
        Cifrado cifrador = new Cifrado();
        Conductor conductor = new Conductor(nombre, apPaterno, apMaterno, fechaNacimiento,
                noLicencia, telCelular, cifrador.cifrarCadena(password));
        try {
            ConductorDAO.agregarConductor(conductor);
            mensajeRespuesta.setStatusMensaje(0);
            //Envía SMS
            Random rand = new Random();

            int number = rand.nextInt(9999) + 1111;
            RespuestaEmailSMS res = new RespuestaEmailSMS();
            JaxSms jax = new JaxSms();
            String respuesta = jax.enviar(telCelular, Integer.toString(number));
            mensajeRespuesta.setSmsCode(respuesta);
            // Fin SMS
            mensajeRespuesta.setMensaje("El usuario se agregó correctamente");
        } catch (IOException ex) {
            ex.printStackTrace();
            mensajeRespuesta.setStatusMensaje(1);
            mensajeRespuesta.setMensaje("Ocurrió un error al registrar el usuario");
        }
        return mensajeRespuesta;
    }

    @Path("ingresarApp")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje ingresarApp(
            @FormParam("telCelular") String telCelular,
            @FormParam("password") String password) {
        Mensaje mensajeRespuesta = new Mensaje();

        Cifrado cifrado = new Cifrado();
        String passwordIngresado = cifrado.cifrarCadena(password);

        Conductor conductorConsultado = null;
        Integer status;
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            if (telCelular != null && password != null) {
                status = ConductorDAO.consultarStatus(telCelular);

                if (status != null) {
                    if (status == 1) {
                        conductorConsultado = ConductorDAO.iniciarSesion(telCelular);
                        if (conductorConsultado != null) {
                            if (conductorConsultado.getPassword().equals(passwordIngresado)) {
                                mensajeRespuesta.setMensaje("Inicio exitoso");
                                mensajeRespuesta.setStatusMensaje(250);
                                mensajeRespuesta.setConductor(conductorConsultado);
                            } else {
                                mensajeRespuesta.setMensaje("Los datos del conductor son incorrectos");
                                mensajeRespuesta.setStatusMensaje(251);
                            }
                        } else {
                            mensajeRespuesta.setMensaje("El usuario no se encuentra registrado");
                            mensajeRespuesta.setStatusMensaje(253);
                        }
                    } else {
                        mensajeRespuesta.setMensaje("El usuario no ha activado su cuenta");
                        mensajeRespuesta.setStatusMensaje(252);
                    }
                } else {
                    mensajeRespuesta.setMensaje("El usuario no se encuentra registrado");
                    mensajeRespuesta.setStatusMensaje(253);
                }
            }
        } catch (IOException ex) {
            mensajeRespuesta.setMensaje("Error al iniciar");
            mensajeRespuesta.setStatusMensaje(1);
        }
        return mensajeRespuesta;
    }

}
