package dao;

import dto.Pedido;
import dto.Usuario;
import dto.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseco
 */
public abstract class ProductoDao {


    public abstract Producto get(int id);
    public abstract int ProgramarTestDrive(int id,String fecha, String hora, int idUsuario);
    public abstract int RealizarPedido(Pedido pedido);
//    String Marca, String modelo, int desde, int hasta, int kmInicial, int kmFinal
    public abstract List<Producto> getLista(String Marca, String modelo, int desde, int hasta, int kmInicial, int kmFinal);
    public abstract Producto getProductoByID(String id);
}
