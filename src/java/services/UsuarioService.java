/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.UsuarioDao;
import dao.UsuarioDaoMySQL;
import dto.Contacto;
import dto.Usuario;
import factory.FactoryDao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
//import  javax.org.json;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author josec
 */
@Path("/usuario")
public class UsuarioService {

//    @GET
//    @Path("/")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Usuario getContactos() {
//        UsuarioDao dao = FactoryDao.getFactoryInstance().getNewUsuarioDao();
//        return dao.get(5);
//    }

    
    @POST
    @Path("/RegistrarUsuario")
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
        String respuesta= " ";
        if (retorno == 1) {
            respuesta = "{\"nro\":1}";
        } else {
            respuesta = "{\"nro\":2}";
        }
        return respuesta;
    }

    @POST
    @Path("/getUsuario")
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
        Usuario retorno = dao.getByUserName(userName,password);
//        valor = {"qty":999,"name":"iPad 3"};
//        String respuesta= " ";
          if(retorno == null){
              retorno= new Usuario();
              retorno.setUsuarioId(0);
          }
//       Gson gson = new Gson(); 
        return gson.toJson(retorno);
    }    
    
    
    
//    @POST @Consumes("application/json")
//@Path("/create")
//public void create(final MyJaxBean input) {
//    System.out.println("param1 = " + input.param1);
//    System.out.println("param2 = " + input.param2);
//}
//            @POST
//        @Produces(MediaType.TEXT_HTML)
//        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//        public void newTodo(@FormParam("id") String id,
}
