package booking.framework.helpers;
import lombok.Data;

@Data
public class InfoRegistro {
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String codigoPostal;
    private String ciudad;
    private String pais;
    private String telefono;
}
