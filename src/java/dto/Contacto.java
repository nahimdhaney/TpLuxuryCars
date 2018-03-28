package dto;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class Contacto {

    private int contactoId;
    private String nombre;
    private String telefono;
    private String email;
    private String sexo;
    private String imagen;

    public Contacto() {
        ;
    }

    public void setContactoId(int contactoId) {
        this.contactoId = contactoId;
    }

    public int getContactoId() {
        return this.contactoId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return this.sexo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    

}
