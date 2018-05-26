package modelo.dao;

import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Reporte;

public class ReporteDAO {
    public static boolean levantarReporte(Reporte reporte) throws Exception {
        boolean flag = false;
        SqlSession conn = null;
        try {
            conn.insert("Reporte.levantarReporte", reporte);
            conn.commit();
            flag = true;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return flag;
    }
}
