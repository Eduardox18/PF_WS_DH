package modelo.dao;

import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Reporte;

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
}
