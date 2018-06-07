package modelo.dao;

import java.util.List;
import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Marca;

public class MarcaDAO {
    
    public static List<Marca> recuperarMarcas() throws Exception {
        List<Marca> marcas;
        try (SqlSession conn = MyBatisUtils.getSession()) {
            marcas = conn.selectList("Marca.recuperarMarcas");
        }
        return marcas;
    }
}
