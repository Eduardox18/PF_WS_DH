/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import modelo.dao.ReporteDAO;
import servicios.pojos.Mensaje;
import servicios.pojos.Reporte;

@Path("reporte")
public class ReporteWS {

    @Context
    private UriInfo context;

    public ReporteWS() {
    }

    @POST 
    @Path("levantarReporte")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje levantarReporte(
        @FormParam("latitud") Float latitud,
        @FormParam("longitud") Float longitud,
        @FormParam("nombreSiniestro") String nombreSiniestro,
        @FormParam("apPaternoSiniestro") String apPaternoSiniestro,
        @FormParam("apMaternoSiniestro") String apMaternoSiniestro,
        @FormParam("idConductor") Integer idConductor,
        @FormParam("idVehiculoConductor") String idVehiculoConductor,
        @FormParam("idVehiculoSiniestro") String idVehiculoSiniestro
    ) {
        
        Mensaje mensaje = new Mensaje();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaHora = sdf.format(new Date());
            Reporte reporte = new Reporte(latitud, longitud, nombreSiniestro, apPaternoSiniestro, 
            apMaternoSiniestro, fechaHora, idConductor, idVehiculoConductor, idVehiculoSiniestro);
            boolean exito = ReporteDAO.levantarReporte(reporte);
            if (exito) {
                mensaje.setMensaje("Reporte registrado con éxito");
            } else {
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
