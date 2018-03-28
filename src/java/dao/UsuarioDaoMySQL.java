package dao;

import dal.Conexion;
import dto.Contacto;
import dto.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author joseco
 */
public class UsuarioDaoMySQL extends UsuarioDao{


    @Override
    public Usuario get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM contacto WHERE contactoId = " + id;
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                Usuario obj = getUsuarioFromResultSet(objResultSet);
                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    @Override
    public Usuario getByUserName(String userName, String Password) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM usuario WHERE nombreUsuario = '" + userName + "' and password = '" + Password + "'";
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) { 
                
                Usuario obj = getUsuarioFromResultSet(objResultSet);
                return obj;
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }
    

    private Usuario getUsuarioFromResultSet(ResultSet objResultSet) throws SQLException{
        Usuario obj = new Usuario();
        int _usuarioId = objResultSet.getInt("usuarioId");
        obj.setUsuarioId(_usuarioId);

        String _nombre = objResultSet.getString("nombreCompleto");
        obj.setNombreCompleto(_nombre);

        String _userName = objResultSet.getString("nombreUsuario");
        obj.setUserName(_userName);

        String _password = objResultSet.getString("password");
        obj.setPassword(_password);
        
        String _fechaIngreso = objResultSet.getString("fechaIngreso");
        obj.setFechaIngreso(_fechaIngreso);
        
        String Direccion = objResultSet.getString("direccion");
        obj.setDireccion(Direccion);
        
        String nroTarjeta = objResultSet.getString("NroTarjeta");
        obj.setNroTarjeta(nroTarjeta);
        
        return obj;
    }

    @Override
    public int RegistrarUsuario(String nombreCompleto, String nombreUsuario, String Password, String Direccion, String fechaIngreso, String NroTarjeta) {
//insert  into `usuario`(`nombreCompleto`,`nombreUsuario`,`password`,`direccion`,`fechaIngreso`,`NroTarjeta`) values 
//('Juan Perez','jperez','jperez','Av. Banzer','20/02/2016',"123456789"),
        try {
//            insert  into `usuario`(`nombreCompleto`,`nombreUsuario`,`password`,`direccion`,`fechaIngreso`,`NroTarjeta`) values 
//('Nahim terazas','NahimT','123','Av el remanzo','18/06/2016','Av el remanzo');

            
            
            Conexion objConexion = Conexion.getOrCreate();

            
            String prueba = "SELECT * FROM usuario WHERE nombreUsuario  = '" + nombreUsuario + "'";
            ResultSet objResultSet = objConexion.ejecutar(prueba);
            if (objResultSet.next()) {
                Usuario obj = getUsuarioFromResultSet(objResultSet);
                return 2;
            }
            
            
            
            
            String query = "insert  into `usuario`(`nombreCompleto`,`nombreUsuario`,`password`,`direccion`,`fechaIngreso`,`NroTarjeta`) values ";
             query += "('"+nombreCompleto+"','"+nombreUsuario+"','"+Password+"','"+Direccion+"','"+fechaIngreso+"','"+NroTarjeta+"')";
             objConexion.ejecutarInsert(query);
             return 1;
//                objConexion.ejecutarInsert(query);
//            String query = "SELECT * FROM usuario WHERE username = '" + nombreUsuario + "'";
//            ResultSet objResultSet = objConexion.ejecutar(query);
//            if (objResultSet.next()) {
//                Usuario obj = getUsuarioFromResultSet(objResultSet);
//                return 2;
//            }else{
//             query = "insert  into `usuario`(`nombreCompleto`,`nombreUsuario`,`password`,`direccion`,`fechaIngreso`,`NroTarjeta`) values ";
//             query += "('"+nombreCompleto+"','"+nombreUsuario+"','"+Password+"','"+Direccion+"','"+fechaIngreso+"','"+NroTarjeta+"')";
//             objConexion.ejecutar(query);
////                objConexion.ejecutarInsert(query);
//            }
        } catch (Exception ex) {
            return 2;
//            throw new UnsupportedOperationException(ex);
        }

//        return 1;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
