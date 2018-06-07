package modelo.dao;

import java.util.List;
import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Aseguradora;

public class AseguradoraDAO {
    
    public static List<Aseguradora> recuperarAseguradoras() throws Exception {
        List<Aseguradora> aseguradoras;
        try (SqlSession conn = MyBatisUtils.getSession()) {
            aseguradoras = conn.selectList("Aseguradora.recuperarAseguradoras");
        }
        return aseguradoras;
    }
    
}
