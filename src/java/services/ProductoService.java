/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.ProductoDao;
import dao.UsuarioDao;
import dto.Producto;
import dto.Usuario;
import factory.FactoryDao;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author L855
 */
@Path("/producto")
public class ProductoService {

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String getContactos() {
        ProductoDao dao = FactoryDao.getFactoryInstance().getNewProductoDao();
        //  return dao.get(5);
        // String Marca, String modelo, int desde, int hasta, int kmInicial, int kmFinal
        List<Producto> lista = dao.getLista("", "", 123, 123, 123, 123);
        Gson gson = new Gson();
        return gson.toJson(lista);
    }
    @GET
    @Path("/Saludo")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSaludo() {
        return "HOLA";
    }
//    @GET
//    @Path("/Busqueda/{marca}/{modelo}/{desde}/{hasta}/{kmInicial}/{kmFinal}")
//    @Produces(MediaType.TEXT_HTML)
//    @Consumes(MediaType.TEXT_PLAIN)
//    public String getProductos(@PathParam("Marca") String marca,
//            @PathParam("modelo") String modelo,
//            @PathParam("desde") int desde,
//            @PathParam("hasta") int hasta,
//            @PathParam("kmInicial") int kmInicial,
//            @PathParam("kmFinal") int kmFinal
//    ){
//        ProductoDao dao = FactoryDao.getFactoryInstance().getNewProductoDao();
//      //  return dao.get(5);
//      // String Marca, String modelo, int desde, int hasta, int kmInicial, int kmFinal
//      List<Producto> lista = dao.getLista(marca,modelo,desde,hasta,kmInicial,kmFinal); 
//        Gson gson = new Gson(); 
//       return gson.toJson(lista);
//    } sclect  
    // post insert 
    @GET
    @Path("/Busqueda/{marca}/{modelo}/{desde}/{hasta}/{kmInicial}/{kmFinal}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String getProductos(@PathParam("marca") String marca,
            @PathParam("modelo") String modelo,
            @PathParam("desde") int desde,
            @PathParam("hasta") int hasta,
            @PathParam("kmInicial") int kmInicial,
            @PathParam("kmFinal") int kmFinal
    ) {
        if (marca == null) {
            marca = "xx";
        }
        if (modelo.contains("Todos")) {
            modelo = "xx";
        }
        marca = marca.replace("_", " ");
        modelo = modelo.replace("_", " ");

        ProductoDao dao = FactoryDao.getFactoryInstance().getNewProductoDao();
        //  return dao.get(5);
        // String Marca, String modelo, int desde, int hasta, int kmInicial, int kmFinal
        List<Producto> lista = dao.getLista(marca, modelo, desde, hasta, kmInicial, kmFinal);
        Gson gson = new Gson();
        return gson.toJson(lista);
    }

//    @GET
//    @Path("/Busqueda/{marca}/{modelo}/{desde}/{hasta}/{kmInicial}/{kmFinal}")
//    @Produces(MediaType.TEXT_PLAIN)
//    @Consumes(MediaType.TEXT_PLAIN)
//    public String getProductosFromID(@PathParam("marca") String marca,
//            @PathParam("modelo") String modelo,
//            @PathParam("desde") int desde,
//            @PathParam("hasta") int hasta,
//            @PathParam("kmInicial") int kmInicial,
//            @PathParam("kmFinal") int kmFinal
//    ) {
//        if (marca == null) {
//            marca = "xx";
//        }
//        if (modelo.contains("Todos")) {
//            modelo = "xx";
//        }
    
//        marca = marca.replace("_", " ");
//        modelo = modelo.replace("_", " ");
//
//        ProductoDao dao = FactoryDao.getFactoryInstance().getNewProductoDao();
//        //  return dao.get(5);
//        // String Marca, String modelo, int desde, int hasta, int kmInicial, int kmFinal
//        List<Producto> lista = dao.getLista(marca, modelo, desde, hasta, kmInicial, kmFinal);
//        Gson gson = new Gson();
//        return gson.toJson(lista);
//    }
    @POST
    @Path("/getFromID")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String GetProducto(String productos) {
//        Usuario usuari1= usuario;
        Gson gson = new Gson();
        List<Producto> lista = new LinkedList();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(productos);
        JsonObject obj = element.getAsJsonObject(); //since you know it's a JsonObject
        Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();//will return members of your object
        for (Map.Entry<String, JsonElement> entry : entries) {
            ProductoDao dao = FactoryDao.getFactoryInstance().getNewProductoDao();
//            System.out.println(entry.getKey());
                Producto pro = dao.getProductoByID(entry.getKey());
                lista.add(pro);
        }


        return gson.toJson(lista);
    }

    @GET
    @Path("/prueba2")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String Prueba2(@PathParam("name") String name) {
        Producto pro = new Producto();
        System.out.println(name);
        pro.setNombre("HOLA");
        return "Hola";
    }

//        @GET
//    @Path("/cat/{idCategoria}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getContactos(@PathParam("idCategoria")  int categoriaId){
//        ProductoDao dao = FactoryDao.getFactoryInstance().getNewProductoDao();
//      //  return dao.get(5);
//      List<Producto> lista = dao.getLista("hola","hola", 0, 0, 0, 0); 
//        Gson gson = new Gson(); 
//       return gson.toJson(lista);
//    }
//    
    //    public HotelRESTInfo read(@PathParam("hotelId") long hotelId) {
    //    (...)
    //}
//    @Path("json")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void consumeJSONRequest(Student s)
//    {
//       System.out.println("**Received JSON request**");
//       System.out.println(" Name : "+s.getName());
//       System.out.println(" Age  : "+s.getAge());
//    }
//        {
//      "one": "Singular sensation",
//      "two": "Beady little eyes",
//      "three": "Little birds pitch by my doorstep"
//    }
}

//@Path("/usuario")
//public class UsuarioService{
//    
//    @GET
//    @Path("/")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Usuario getContactos(){
//        UsuarioDao dao = FactoryDao.getFactoryInstance().getNewUsuarioDao();
//        return dao.get(5);
//    }
//    
