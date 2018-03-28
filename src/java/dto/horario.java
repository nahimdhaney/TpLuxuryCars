package dto;

/**
 *
 * @author Jose Carlos Gutierrez
 */

public class horario {

    private String fecha;
    private String hora;
    private int id;
    private int cliente;
//            horario.fecha= fecha; 
//        horario.hora = hora;
//        horario.id = obj; // Id del producto que va a realizar el test-drive
//        horario.cliente = cliente; // Id 

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public horario(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    public horario() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
