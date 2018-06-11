/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.dao.DictamenReporteDAO;
import servicios.pojos.Mensaje;
import servicios.pojos.ResultadoDictamen;
import servicios.pojos.DictamenReporte;

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
    
    @POST
    @Path("dictaminarReporte")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje dictaminarReporte(
            @FormParam("descripcion") String descripcion,
            @FormParam("estado") String estado,
            @FormParam("idReporte") Integer idReporte,
            @FormParam("idPerito") Integer idPerito) {
        
        Mensaje mensaje = new Mensaje();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean resultado = false;
        String fechaHora = sdf.format(new Date());
        DictamenReporte dictamen  = new DictamenReporte(descripcion, 
                estado, fechaHora, idReporte, idPerito);
        
        try {
            resultado = DictamenReporteDAO.dictaminarReporte(dictamen);
            if (resultado) {
                mensaje.setStatusMensaje(500);
                mensaje.setMensaje("Reporte registrado con éxito");
            } else {
                mensaje.setStatusMensaje(501);
                mensaje.setMensaje("No se pudo registrar el reporte");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            mensaje.setStatusMensaje(1);
            mensaje.setMensaje("Error al levantar el reporte: " + ex.getMessage());
        } 
        return mensaje;
    }
}
