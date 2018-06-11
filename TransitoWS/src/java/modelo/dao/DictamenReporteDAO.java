package modelo.dao;

import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.ResultadoDictamen;

public class DictamenReporteDAO {
    
    public static ResultadoDictamen recuperarDictamen(String idReporte) throws Exception {
        ResultadoDictamen dictamen = null;
        try(SqlSession conn = MyBatisUtils.getSession()) {
            dictamen = conn.selectOne("DictamenReporte.recuperarDictamen", idReporte);
        }
        return dictamen;
    }
    
}
