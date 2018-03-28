package dao;

import dto.Usuario;
import java.util.ArrayList;

/**
 *
 * @author joseco
 */
public abstract class UsuarioDao {


    public abstract Usuario get(int id);
    
    public abstract Usuario getByUserName(String userName, String Password);
    public abstract int RegistrarUsuario(String nombreCompleto, String nombreUsuario, String Password, String Direccion,String fechaIngreso,String NroTarjeta);
//    `nombreCompleto`,`nombreUsuario`,`password`,`direccion`,`fechaIngreso`,`NroTarjeta`
//`usuarioId`,`nombreCompleto`,`nombreUsuario`,`password`,`direccion`,`fechaIngreso`,`NroTarjeta`
}
