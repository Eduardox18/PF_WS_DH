/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import modelo.dao.ReporteDAO;
import servicios.pojos.Mensaje;
import servicios.pojos.Reporte;
import servicios.pojos.ResultadoReporte;

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

        if (apMaternoSiniestro.equals("")) {
            apMaternoSiniestro = null;
        }

        Mensaje mensaje = new Mensaje();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaHora = sdf.format(new Date());
            Reporte reporte = new Reporte(latitud, longitud, nombreSiniestro, apPaternoSiniestro,
                    apMaternoSiniestro, fechaHora, idConductor, idVehiculoConductor, idVehiculoSiniestro);
            boolean exito = ReporteDAO.levantarReporte(reporte);
            if (exito) {
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

    @POST
    @Path("recuperarReportes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResultadoReporte> recuperarReportes(
            @FormParam("idConductor") String idConductor
    ) {
        List<ResultadoReporte> reportes = null;
        try {
            reportes = ReporteDAO.recuperarReportes(idConductor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reportes;
    }
    
    @GET
    @Path("recuperarTodosReportes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reporte> recuperarTodosReportes(
    ) {
        List<Reporte> reportes = null;
        try {
            reportes = ReporteDAO.recuperarTodosReportes();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reportes;
    }
    
    
    @GET
    @Path("ultimoReporte")
    @Produces(MediaType.APPLICATION_JSON)
    public Reporte consultarUltimo() {
        Reporte reporte = new Reporte();
        try {
            reporte.setIdReporte(ReporteDAO.consultarUltimo());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reporte;
    }
}
