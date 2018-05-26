/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.IOException;
import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Usuario;

/**
 *
 * @author yamii
 */
public class UsuarioDAO {

    /** 
     * Guarda los datos del objeto Usuario en la base de datos
     * @param usuario Objeto usuario con los datos que se van a registrar
     * @return True en caso de que se haya registrado correctmente y false si ocurrió algún error
     * @throws java.io.IOException
     */
    public static boolean agregarUsuario(Usuario usuario) throws IOException {
        boolean resultado = false;
        if (usuario != null) {
            try(SqlSession conn = MyBatisUtils.getSession()) {
                conn.insert("Usuario.agregarUsuario", usuario);
                conn.commit();
                resultado = true;
            }
        }
        return resultado;
    }
}
