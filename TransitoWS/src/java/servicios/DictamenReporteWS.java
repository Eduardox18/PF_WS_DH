/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.dao.DictamenReporteDAO;
import servicios.pojos.ResultadoDictamen;

/**
 * REST Web Service
 *
 * @author lalo
 */
@Path("dictamen")
public class DictamenReporteWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DictamenReporteWS
     */
    public DictamenReporteWS() {
    }

    @POST
    @Path("recuperarDictamen")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoDictamen consultarVehiculo(
        @FormParam("idReporte") String idReporte 
    ) {
        ResultadoDictamen dictamen = null;
        try {
            dictamen = DictamenReporteDAO.recuperarDictamen(idReporte);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dictamen;
    } 
    
}
