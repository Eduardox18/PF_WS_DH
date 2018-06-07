package servicios;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import modelo.dao.ColorDAO;
import servicios.pojos.Color;

/**
 * REST Web Service
 *
 * @author lalo
 */
@Path("color")
public class ColorWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ColorWS
     */
    public ColorWS() {
    }

    @Path("consultarColores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Color> consultarColores() {
        List<Color> colores = null;
        try {
            colores = ColorDAO.recuperarColores();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return colores;
    }
}
