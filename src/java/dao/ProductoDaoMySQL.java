/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.Conexion;
import dal.ConexionMySQL;
import dto.DetallePedido;
import dto.Pedido;
import dto.Producto;
//import dto.C;
import dto.Usuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import services.PedidoService;

/**
 *
 * @author L855
 */
public class ProductoDaoMySQL extends ProductoDao {

    @Override
    public Producto get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> getLista(String Marca, String modelo, int desde, int hasta, int kmInicial, int kmFinal) {

        try {
            Conexion objConexion = Conexion.getOrCreate();
//            String query = "SELECT * FROM usuario WHERE username = '" + Marca + "'";
            String query = "select p.*, c.nombreCategoria as marca from producto p join categoria c on "
                    + " p.categoriaId = c.categoriaId ";

            String query2 = "select p.*, c.nombreCategoria as marca from producto p join categoria c on "
                    + " p.categoriaId = c.categoriaId where ";
//       modelo, int desde, int hasta, int kmInicial, int kmFinal
            if (!modelo.equals("xx")) {
                query2 += "nombre like '" + modelo + "' and ";
            }
            if (!Marca.equals("xx")) {
                query2 += "c.nombreCategoria like '" + Marca + "' and ";
            }
            if (desde != 123) {
                query2 += "anho >= " + desde + " and ";
            }
            if (hasta != 123) {
                query2 += "anho <= " + hasta + " and ";
            }
            if (kmInicial != 123) {
                query2 += "kilometros >= " + kmInicial + " and ";
            }
            if (kmFinal != 123) {
                query2 += "kilometros <= " + kmFinal + " and ";
            }

            if (query2.endsWith("and ")) {
                query2 = query2.subSequence(0, query2.length() - 4) + "";
            }

            if (query2.endsWith("where ")) {
                query2 = query2.subSequence(0, query2.length() - 6) + "";
            }
            query2 += " and estado = 0";

//select p.*, c.nombreCategoria as marca from producto p left join categoria c on 
//p.categoriaId = c.categoriaId where nombre like 'serie 5' and precio >= 10 and precio <= 100000 
//and anho >= 2012 and anho <= 2012 and 
//c.nombreCategoria like 'Audi'
//;            
            ResultSet objResultSet = objConexion.ejecutar(query2);
            List<Producto> productos = new LinkedList<>();

            while (objResultSet.next()) {
                Producto obj = getProductoFromResultSet(objResultSet);
                productos.add(obj);
            }
            return productos;
        } catch (Exception ex) {

        }
        return null;

    }

    private Producto getProductoFromResultSet(ResultSet objResultSet) throws SQLException {

//  `productoId` int(6) NOT NULL AUTO_INCREMENT,
//  `nombre` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
//  `descripcion` text COLLATE utf8_spanish_ci NOT NULL,
//  `precio` decimal(10,2) NOT NULL,
//  `categoriaId` int(11) NOT NULL, // categoria es la Marca
//  `anho` int(4) NOT NULL,
//  `imagen` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
//  `kilometros` int(7),
        Producto obj = new Producto();
        int _productoId = objResultSet.getInt("productoId");
        obj.setProductoId(_productoId);

        int km = objResultSet.getInt("kilometros");
        obj.setKilometros(km);

        int anho = objResultSet.getInt("anho");
        obj.setAnho(anho);

        String imagen = objResultSet.getString("imagen");
        obj.setImagen(imagen);

        String _nombre = objResultSet.getString("nombre");
        obj.setNombre(_nombre);

        String _descripcion = objResultSet.getString("descripcion");
        obj.setDescripcion(_descripcion);

        String _categoria = objResultSet.getString("marca");
        obj.setMarca(_categoria);

        double _precio = objResultSet.getDouble("precio");
        obj.setPrecio(_precio);

        return obj;
    }

    @Override
    public int ProgramarTestDrive(int idProducto, String fecha, String hora, int idUsuario) {
        try {
            // la fecha deberia no deberia estar entre 2 horas despues del otro
            Conexion objConexion = Conexion.getOrCreate();
// select * from testDrive where

// productoId = 4 and fecha= '2017-06-01' and (hora ='05:00:00' or hora ='01:00:00' or hora ='01:00:00');
            int hora2 = (Integer.parseInt(hora.substring(1, 2)) - 1);
            int hora3 = (Integer.parseInt(hora.substring(1, 2)) + 1);
            String query = "select COUNT(*) tamano from testDrive where "
                    + "productoId = " + idProducto + " and "
                    + "fecha= '" + fecha + "' "
                    + "and (hora ='" + hora + "' or hora ='0" + hora2 + ":00:00' or hora ='0" + hora3 + ":00:00')";
            ResultSet objResultSet = objConexion.ejecutar(query);
            int tamaño = 2;

            if (objResultSet.next()) {
                tamaño = objResultSet.getInt("tamano");
            }

            if (tamaño == 0) {// bien                
                // aqui hacer el Insert
                String query2 = "insert  into `testDrive`(`productoId`,`fecha`,`hora`,`usuarioId`) values \n"
                        + "(" + idProducto + ",'" + fecha + "','" + hora + "'," + idUsuario + ")";
                objConexion.ejecutarInsert(query2);
                return 1;

//                query += "('" + nombreCompleto + "','" + nombreUsuario + "','" + Password + "','" + Direccion + "','" + fechaIngreso + "','" + NroTarjeta + "')";
//                objConexion.ejecutarInsert(query);
            } else { // ocupado 
                return 2;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
            return 2;
        }
//        return 4;
    }

    @Override
    public Producto getProductoByID(String id) {
        Conexion objConexion = Conexion.getOrCreate();

        String query = "select p.*, c.nombreCategoria as marca from producto p join categoria c on "
                + " p.categoriaId = c.categoriaId where productoId = " + id;
        query += " and estado = 0";
        ResultSet objResultSet = objConexion.ejecutar(query);

        try {
            while (objResultSet.next()) {
                return getProductoFromResultSet(objResultSet);
//                productos.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int RealizarPedido(Pedido pedido) {
        Conexion objConexion = Conexion.getOrCreate();
//    insert  into `pedido`(`usuarioId`,`fecha`,`total`) values 
//    (22,'22/06/2016',170000);
        try {
            // ejecucion insert Pedido
            String query = "insert  into `pedido`(`usuarioId`,`fecha`,`total`) values "
                    + "(" + pedido.getUsuarioId() + ",'" + pedido.getFecha() + "'," + pedido.getTotal() + ")";
            int nroPedido = objConexion.ejecutarInsert(query);
            // ejecucion insert DetallePedido
            List<DetallePedido> detallesPedidos = pedido.getDetalle();
            for (DetallePedido detallesPedido : detallesPedidos) {
                detallesPedido.setPedidoId(nroPedido);
                String query2 = "insert  into `detallepedido`(`pedidoId`,`productoId`,`cantidad`,`precio`,`subtotal`) values "
                        + "(" + nroPedido + "," + detallesPedido.getProductoId() + "," + 1 + "," + detallesPedido.getPrecio() + "," + detallesPedido.getPrecio() + ")";
                objConexion.ejecutarInsert(query2);
                String query3 = "    update producto set estado = 1 "
                        + "    where productoId=" + detallesPedido.getProductoId();
                objConexion.ejecutarSimple(query3);
            }

            try {
                System.setProperty("java.awt.headless", "true");
//            JasperReport reporte = (JasperReport) JRLoader.loadObject("C:\\Program Files (x86)\\JDBC SQL SERVER\\sqljdbc_6.0\\esn\\TPFactura.jasper");
//                File file = new File();




//                JasperReport reporte = (JasperReport) JRLoader.loadObject("C://Users//L855//Documents//NetBeansProjects//LuxuryCars/reportePedido.jasper");
//                HashMap<String, Object> parameters = new HashMap<>();
////                parameters.put("nro", "6" );
//                ConexionMySQL conexion = (ConexionMySQL) Conexion.getOrCreate();
////                conexion.estaConectado()
//                JasperPrint jasperPrint;
//                Connection conexion2 = conexion.getConec(); 
//                
////                boolean valido = conexion2.isValid(3);
//                jasperPrint = JasperFillManager.fillReport(reporte, null, conexion2);
////                File pdf = File.createTempFile("C:\\Users\\L855\\Documents\\NetBeansProjects\\LuxuryCars\\web\\carrito\\jasper", ".pdf");
////                JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
//                // report112
//
//                JRExporter exporter = new JRPdfExporter();
//                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream("C:\\Users\\L855\\Documents\\NetBeansProjects\\LuxuryCars\\example" + ".pdf")); // your output goes here
//                exporter.exportReport();

                
                
                
                // TODO add your handling code here:
            } catch (Throwable ex) {
                String exc = ex.getMessage();
//            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            } //            objConexion.ejecutarSimple(query)
            // ejecucion update Vehiculo DetallePedido
            return 1;
        } catch (Exception e) {
            return 2;
        }
//        return 1;
//    insert  into `detallepedido`(`pedidoId`,`productoId`,`cantidad`,`precio`,`subtotal`) values 

//        pedido.get
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
