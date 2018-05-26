package servicios;

import gateway.sms.JaxSms;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import servicios.pojos.RespuestaEmailSMS;

/**
 * REST Web Service
 *
 * @author lalo
 */
@Path("sms")
public class SmsWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SmsWS
     */
    public SmsWS() {
    }

    @POST
    @Path("enviar")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaEmailSMS enviarSMS (
        @FormParam("numero") String numero,
        @FormParam("mensaje") String mensaje
    ) {
        RespuestaEmailSMS res = new RespuestaEmailSMS();
        JaxSms jax = new JaxSms();
        String respuesta = jax.enviar(numero, mensaje);
        res.setSmscode(respuesta);
        return res;
    }
}
