/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author L855
 */
public class Pedido {
//    insert  into `Pedido`(`usuarioId`,`fecha`,`total`) values 
//(22,'22/06/2016',170000);
    private int usuarioId;
    private String fecha;
    private int total;
    private List<DetallePedido> detalle;
    public int getUsuarioId() {
        return usuarioId;
    }

    public List<DetallePedido> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetallePedido> detalle) {
        this.detalle = detalle;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Pedido() {
    }

    public Pedido(int usuarioId, String fecha, int total) {
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.total = total;
    }
}
