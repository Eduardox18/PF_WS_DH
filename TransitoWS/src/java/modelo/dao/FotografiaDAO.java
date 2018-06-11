/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Fotografia;

/**
 *
 * @author lalo
 */
public class FotografiaDAO {
    public static boolean guardarFoto(Fotografia foto) throws Exception {
        boolean exito = false;
        try (SqlSession conn = MyBatisUtils.getSession()) {
            conn.insert("Fotografia.guardarFoto", foto);
            conn.commit();
            exito = true;
        }
        return exito;
    }
}
