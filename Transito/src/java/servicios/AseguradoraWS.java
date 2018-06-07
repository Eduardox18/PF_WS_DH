/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import modelo.dao.AseguradoraDAO;
import servicios.pojos.Aseguradora;

/**
 * REST Web Service
 *
 * @author lalo
 */
@Path("aseguradora")
public class AseguradoraWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AseguradoraWS
     */
    public AseguradoraWS() {
    }

    @Path("consultarAseguradoras")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aseguradora> consultarMarcas() {
        List<Aseguradora> aseguradoras = null;
        try {
            aseguradoras = AseguradoraDAO.recuperarAseguradoras();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return aseguradoras;
    }
}
