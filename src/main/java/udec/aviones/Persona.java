package udec.aviones;
import java.util.Date;

/**
 *clase que contiene los datos del cliente 
 * @author Jonathan
 */
public class Persona {
    /**
     * atributo que contiene el numero de identificacion de la persona
     */
    private int identificacion;
    /**
     * atributo que contiene el nombre de la persona
     */
    private String nombre;
    /**
     * atributo que contiene la fecha de nacimiento de la persona
     */
    private Date fechaNacimiento;
    /**
     * constructor de la clase que inicializa los atributos
     * @param identificacion numero de identificacion de la persona
     * @param nombre nombre de la persona
     * @param fechaNacimiento  fecha de nacimiento de la persona
     */
    public Persona(int identificacion, String nombre, Date fechaNacimiento) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }//constructor
    /**
     * retorna el valor de la identificacion de la persona
     * @return identificacion
     */
    public int getIdentificacion() {
        return identificacion;
    }//getIdentificacion
    /**
     * modfica la identifiacion de la persona
     * @param identificacion 
     */
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }//setIdentificacion
    /**
     * retorna el nombre de la persona
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }//getNombre
    /**
     * modifica el nombre de la persona
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//setNombre    
    /**
     * retorna la fecha de nacimiento de la persona
     * @return fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }//getFechaNacimiento
    /**
     * modifica la fecha de nacimiento
     * @param fechaNacimiento 
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }//setFechaNacimiento
    
}//Persona
