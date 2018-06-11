package servicios;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("transito")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(servicios.AseguradoraWS.class);
        resources.add(servicios.ColorWS.class);
        resources.add(servicios.ConductorWS.class);
        resources.add(servicios.DictamenReporteWS.class);
        resources.add(servicios.EmailWS.class);
        resources.add(servicios.FotografiaWS.class);
        resources.add(servicios.MarcaWS.class);
        resources.add(servicios.ReporteWS.class);
        resources.add(servicios.SmsWS.class);
        resources.add(servicios.UsuarioWS.class);
        resources.add(servicios.VehiculoWS.class);
    }
    
}
