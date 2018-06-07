/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import modelo.dao.VehiculoDAO;
import servicios.pojos.Mensaje;
import servicios.pojos.Vehiculo;

/**
 * REST Web Service
 *
 * @author José Andrés Domínguez González
 */
@Path("vehiculo")
public class VehiculoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VehiculoWS
     */
    public VehiculoWS() {
    }

    /**
     * Agrega vehículo a la base de datos. 
     * @param noPlaca
     * @param modelo
     * @param anio
     * @param noPolizaSeguro
     * @param idMarca
     * @param idAseguradora
     * @param idColor
     * @param idConductor
     * @return 
     */
    @Path("agregarVehiculo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje agregarUsuario(
        @FormParam("noPlaca") String noPlaca,
        @FormParam("modelo") String modelo,
        @FormParam("anio") Integer anio,
        @FormParam("noPolizaSeguro") String noPolizaSeguro,
        @FormParam("idMarca") Integer idMarca,
        @FormParam("idAseguradora") Integer idAseguradora,
        @FormParam("idColor") Integer idColor,
        @FormParam("idConductor") Integer idConductor) {
        Mensaje mensajeRespuesta = new Mensaje();
        
        if (noPolizaSeguro.equals("null")) {
            noPolizaSeguro = null;
        }
        
        if (idAseguradora == 11) {
            idAseguradora = null;
        }

        Vehiculo vehiculo = new Vehiculo(noPlaca, modelo, anio, noPolizaSeguro,
            idMarca, idAseguradora, idColor, idConductor);

        boolean exito;
        try {
            exito = VehiculoDAO.agregarVehiculo(vehiculo);
            if (exito) {
                mensajeRespuesta.setStatusMensaje(300);
                mensajeRespuesta.setMensaje("El vehículo se agregó correctamente");
            } else {
                mensajeRespuesta.setStatusMensaje(301);
                mensajeRespuesta.setMensaje("El vehículo no se pudo agregar");
            }
        } catch (Exception ex) {
            mensajeRespuesta.setStatusMensaje(1);
            mensajeRespuesta.setMensaje("La placa ingresada ya se encuentra registrada");
        }
        return mensajeRespuesta;
    }
}
