/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import dal.Conexion;
import dal.ConexionMySQL;
import dao.ProductoDao;
import dao.UsuarioDao;
import dto.Pedido;
import dto.Usuario;
import dto.horario;
import factory.FactoryDao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author josec
 */
@Path("/pedido")
public class PedidoService {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getContactos() {
        UsuarioDao dao = FactoryDao.getFactoryInstance().getNewUsuarioDao();
        return dao.get(5);
    }

    @POST
    @Path("/RegistrarPedido")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String RegistrarUsuario(String usu) {
//        Usuario usuari1= usuario;
        Gson gson = new Gson();
        String todayAsString = new SimpleDateFormat("ddMMyyyy").format(new Date());
        //  Datos.getInstancia().InsertarPlato(new Plato(23,"Papas, ensalada, pollo frito ","Pollo Broasted"));               
        Usuario usuario = gson.fromJson(usu, Usuario.class);
//          Usuario usu = json;
        UsuarioDao dao = FactoryDao.getFactoryInstance().getNewUsuarioDao();
//        return 1;
        int retorno = dao.RegistrarUsuario(usuario.getNombreCompleto(), usuario.getUserName(), usuario.getPassword(),
                usuario.getDireccion(), todayAsString, usuario.getNroTarjeta());
//        valor = {"qty":999,"name":"iPad 3"};
        String respuesta = " ";
        if (retorno == 1) {
            respuesta = "{\"nro\":1}";
        } else {
            respuesta = "{\"nro\":2}";
        }


        return respuesta;
    }

    @POST
    @Path("/getPedido")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String GetUsuario(String usu) {
//        Usuario usuari1= usuario;
        Gson gson = new Gson();
        //  Datos.getInstancia().InsertarPlato(new Plato(23,"Papas, ensalada, pollo frito ","Pollo Broasted"));               
        Usuario usuario = gson.fromJson(usu, Usuario.class);
//          Usuario usu = json;
        UsuarioDao dao = FactoryDao.getFactoryInstance().getNewUsuarioDao();
//        return 1;
        String userName = usuario.getUserName();
        String password = usuario.getPassword();
        Usuario retorno = dao.getByUserName(userName, password);
//        valor = {"qty":999,"name":"iPad 3"};
//        String respuesta= " ";
        if (retorno == null) {
            retorno = new Usuario();
            retorno.setUsuarioId(0);
        }
//       Gson gson = new Gson(); 
        return gson.toJson(retorno);
    }

    @POST
    @Path("/RegistrarTestDrive")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String RegistrarTestDrive(String gsonHorario) {
//        Usuario usuari1= usuario;
//'02:00:00'
        Gson gson = new Gson();
//        String todayAsString = new SimpleDateFormat("ddMMyyyy").format(new Date());
        //  Datos.getInstancia().InsertarPlato(new Plato(23,"Papas, ensalada, pollo frito ","Pollo Broasted"));               
        horario horario = gson.fromJson(gsonHorario, horario.class);
        horario.setHora("0" + horario.getHora().substring(0, 1) + ":00:00");
//          Usuario usu = json;
        ProductoDao dao = FactoryDao.getFactoryInstance().getNewProductoDao();
//02 p.m.:00:00
//        return 1;
        int retorno = dao.ProgramarTestDrive(horario.getId(), horario.getFecha(), horario.getHora(), horario.getCliente());
//        valor = {"qty":999,"name":"iPad 3"};
        String respuesta = " ";
        if (retorno == 1) {
            respuesta = "{\"nro\":1}";
        } else {
            respuesta = "{\"nro\":2}";
        }
        return respuesta;
    }

    @POST
    @Path("/RealizarCompra")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String RealizarCompra(String gsonPedido) {
        Gson gson = new Gson();
        Pedido pedido = null;
        try {
            pedido = gson.fromJson(gsonPedido, Pedido.class);

        } catch (Exception e) {
            System.out.println(e);
        }
        ProductoDao dao = FactoryDao.getFactoryInstance().getNewProductoDao();
        int retorno = dao.RealizarPedido(pedido);
        String respuesta;
        if (retorno == 1) {
            respuesta = "{\"nro\":1}";
        } else {
            respuesta = "{\"nro\":2}";
        }
        return respuesta;
    }

}
