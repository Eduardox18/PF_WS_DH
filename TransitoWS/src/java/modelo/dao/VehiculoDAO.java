/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.IOException;
import java.util.List;
import modelo.mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import servicios.pojos.Vehiculo;

/**
 *
 * @author yamii
 */
public class VehiculoDAO {
    
    /** 
     * Guarda los datos del objeto Vehiculo en la base de datos
     * @param vehiculo Objeto vehiculo con los datos que se van a registrar
     * @return True en caso de que se haya registrado correctmente y false si ocurrió algún error
     * @throws java.io.IOException
     */
    public static boolean agregarVehiculo(Vehiculo vehiculo) throws IOException {
        boolean resultado = false;
        if (vehiculo != null) {
            try(SqlSession conn = MyBatisUtils.getSession()) {
                conn.insert("Vehiculo.agregarVehiculo", vehiculo);
                conn.commit();
                resultado = true;
            }
        }
        return resultado;
    }  
    
    public static List<Vehiculo> consultarVehiculos(Integer idConductor) throws Exception {
        List<Vehiculo> vehiculos;
        try(SqlSession conn = MyBatisUtils.getSession()) {
            vehiculos = conn.selectList("Vehiculo.consultarVehiculos", idConductor); 
        }
        return vehiculos;
    }
    
    public static Vehiculo consultarVehiculo(String noPlaca) throws Exception {
        Vehiculo vehiculo;
        try(SqlSession conn = MyBatisUtils.getSession()) {
            vehiculo = conn.selectOne("Vehiculo.consultarVehiculo", noPlaca); 
        }
        return vehiculo;
    }
    
    public static Integer consultarUltimo() throws Exception {
        Integer idVehiculo;
        try(SqlSession conn = MyBatisUtils.getSession()) {
            idVehiculo = conn.selectOne("Vehiculo.consultarUltimo"); 
        }
        return idVehiculo;
    }
}
