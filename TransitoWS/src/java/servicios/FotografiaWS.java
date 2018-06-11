/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.dao.FotografiaDAO;
import servicios.pojos.Fotografia;
import servicios.pojos.Mensaje;

/**
 * REST Web Service
 *
 * @author lalo
 */
@Path("fotografia")
public class FotografiaWS {

    @Context
    private UriInfo context;

    public FotografiaWS() {
    }
    
    private final String PATH = "/Users/lalo/Desktop/";

    @POST
    @Path("subir/{idReporte}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public Mensaje subirImagen(
            @PathParam("idReporte") String idReporte, byte[] bytes){
        Mensaje mensajeRespuesta = new Mensaje();
        try{
            if(bytes!=null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaHora = sdf.format(new Date());
                
                Fotografia foto = new Fotografia(
                        bytes,
                        idReporte,
                        fechaHora
                );
                
                FotografiaDAO.guardarFoto(foto);
                
                mensajeRespuesta.setStatusMensaje(700);
                mensajeRespuesta.setMensaje("Foto guardada con éxito");
                
            }else{
                mensajeRespuesta.setStatusMensaje(1);
                mensajeRespuesta.setMensaje("No se recibio flujo de datos...");
            }            
        }catch(Exception ex){
            mensajeRespuesta.setStatusMensaje(1);
            mensajeRespuesta.setMensaje(ex.getMessage());
        }
        return mensajeRespuesta;
    }
}
