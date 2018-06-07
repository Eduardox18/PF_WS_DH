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
import modelo.dao.MarcaDAO;
import servicios.pojos.Marca;

/**
 * REST Web Service
 *
 * @author lalo
 */
@Path("marca")
public class MarcaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MarcaWS
     */
    public MarcaWS() {
    }

    @Path("consultarMarcas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Marca> consultarMarcas() {
        List<Marca> marcas = null;
        try {
            marcas = MarcaDAO.recuperarMarcas();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return marcas;
    }
}
