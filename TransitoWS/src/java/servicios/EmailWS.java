/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import gateway.email.JavaMail;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import servicios.pojos.RespuestaEmailSMS;

/**
 * REST Web Service
 *
 * @author José Andrés Domínguez González
 */
@Path("email")
public class EmailWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmailWS
     */
    public EmailWS() {
    }

    @POST
    @Path("enviar")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaEmailSMS enviarEmail(
            @FormParam("email") String email,
            @FormParam("asunto") String asunto,
            @FormParam("mensaje") String mensaje) 
    {
        RespuestaEmailSMS res = new RespuestaEmailSMS();
        boolean enviado = JavaMail.send(email, asunto, mensaje);
        res.setEmailStatus(enviado);
        return res;
    }
}
