package modelo.dao;

import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.DictamenReporte;
import servicios.pojos.ResultadoDictamen;

public class DictamenReporteDAO {
    
    public static ResultadoDictamen recuperarDictamen(String idReporte) throws Exception {
        ResultadoDictamen dictamen = null;
        try(SqlSession conn = MyBatisUtils.getSession()) {
            dictamen = conn.selectOne("DictamenReporte.recuperarDictamen", idReporte);
        }
        return dictamen;
    }
    
    /**
     * Guarda el dictamen hecho sobre un reporte previamente subido a la base de datos
     * @param dictamen Objeto donde se encuentra toda la información del dictamen
     * @return  true en caso de que la operación sea exitosa y false en el caso contrario
     * @throws Exception 
     */
    public static boolean dictaminarReporte(DictamenReporte dictamen) throws Exception{
        boolean resultado = false;
        try(SqlSession conn = MyBatisUtils.getSession()){
            conn.insert("DictamenReporte.dictaminarReporte", dictamen);
            conn.commit();
            resultado = true;
        }
        return resultado;
    }
}
