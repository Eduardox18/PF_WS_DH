package modelo.dao;

import java.util.List;
import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Color;

public class ColorDAO {
    
    public static List<Color> recuperarColores() throws Exception{
        List<Color> colores;
        try (SqlSession conn = MyBatisUtils.getSession()) {
            colores = conn.selectList("Color.recuperarColores");
        }
        return colores;
    }
}
