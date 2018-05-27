package modelo.dao;

import java.io.IOException;
import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Conductor;

public class ConductorDAO {
    
    /**
     * 
     * Guarda los datos del objeto Conductor en la base de datos
     * @param conductor Objeto conductor con los datos que se van a registrar
     * @return True en caso de que se haya registrado correctmente y false si ocurrió algún error
     * @throws java.io.IOException
     */
    public static boolean agregarConductor(Conductor conductor) throws Exception {
        boolean resultado = false;
        if (conductor != null) {
            try(SqlSession conn = MyBatisUtils.getSession()) {
                conn.insert("Conductor.agregarConductor", conductor);
                conn.commit();
                resultado = true;
            }
        }
        
        return resultado;
    }
    
    public static Conductor iniciarSesion(String telCelular) throws Exception {
        Conductor conductorConsultado = null;
        if (telCelular != null) {
            try(SqlSession conn = MyBatisUtils.getSession()) {
                conductorConsultado = conn.selectOne("Conductor.iniciarSesion", telCelular);
            }
        }
        return conductorConsultado;
    }
    
    public static Integer consultarStatus(String telCelular) throws Exception {
        Integer status = 0;
        try (SqlSession conn = MyBatisUtils.getSession()) {
            status = conn.selectOne("Conductor.consultarStatus", telCelular);
        }
        return status;
    }
    
    public static Integer consultarCodigoVerificacion(String telCelular) throws Exception {
        Integer codigoVerificacion;
        try (SqlSession conn = MyBatisUtils.getSession()) {
            codigoVerificacion = conn.selectOne("Conductor.recuperarCodigoVerificacion", 
                    telCelular);
        }
        return codigoVerificacion;
    }
    
    public static boolean disponibilidadConductor(Conductor conductor) 
            throws Exception {
        boolean disponible = true;
        try (SqlSession conn = MyBatisUtils.getSession()) {
            Integer idConductor = conn.selectOne("Conductor.disponibilidadConductor", conductor);
            if (idConductor != null) {
                disponible = false;
            }
        }
        return disponible;
    }
    
    public static boolean activarConductor(String telCelular) throws Exception {
        boolean exito = false;
        try (SqlSession conn = MyBatisUtils.getSession()) {
            conn.update("Conductor.activarConductor", telCelular);
            conn.commit();
            exito = true;
        }
        return exito;
    }
}
