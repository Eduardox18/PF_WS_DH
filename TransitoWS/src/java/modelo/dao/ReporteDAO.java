package modelo.dao;

import java.util.List;
import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Reporte;
import servicios.pojos.ResultadoReporte;

public class ReporteDAO {
    
    public static boolean levantarReporte(Reporte reporte) throws Exception {
        boolean flag = false;
        try(SqlSession conn = MyBatisUtils.getSession()) {
            conn.insert("Reporte.agregarReporte", reporte);
            conn.commit();
            flag = true;
        } 
        return flag;
    }
    
    public static List<ResultadoReporte> recuperarReportes(String idConductor) throws Exception {
        List<ResultadoReporte> reportes = null;
        try(SqlSession conn = MyBatisUtils.getSession()) {
            reportes = conn.selectList("Reporte.recuperarReportes", idConductor);
        }
        return reportes;
    }
    
    public static Integer consultarUltimo() throws Exception {
        Integer idReporte;
        try(SqlSession conn = MyBatisUtils.getSession()) {
            idReporte = conn.selectOne("Reporte.recuperarUltimo"); 
        }
        return idReporte;
    }
}
