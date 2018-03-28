package dto;

/**
 *
 * @author joseco
 */
public class Usuario {
   
    private int usuarioId;
    private String nombreCompleto;
    private String userName;
    private String password;
    private String direccion;
    private String fechaIngreso;
    private String NroTarjeta;

//insert  into `usuario`(`usuarioId`,`nombreCompleto`,`nombreUsuario`,`password`,`direccion`,`fechaIngreso`,`NroTarjeta`) values 
//(1,'Juan Perez','jperez','jperez','Av. Banzer','20/02/2016',123456789),

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNroTarjeta() {
        return NroTarjeta;
    }

    public void setNroTarjeta(String NroTarjeta) {
        this.NroTarjeta = NroTarjeta;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
