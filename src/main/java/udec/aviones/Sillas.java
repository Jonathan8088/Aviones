package udec.aviones;

/**
 *clase que contiene los atributos de la silla
 * @author Jonathan
 */
public class Sillas {
    /**
     * atributo que contiene la coordenada en el eje x de la silla
     */
    private int coordenadaX;
    /**
     * atributo que contiene la coordenada en el eje y de la silla
     */
    private int coordenadaY;
    /**
     * objeto que contiene la persona que ocupara la silla
     */
    private Persona persona;
    /**
     * atributo que contiene el precio de la silla
     */
    private float precio;
    /**
     * constructor de la clase que incializa las variables
     * @param coordenadaX coordenada en el eje x de la silla
     * @param coordenadaY coordenada en el eje y de la silla
     * @param persona objeto que contiene los atributos de la persona que ocupa la silla
     * @param precio precio de la silla
     */
    public Sillas(int coordenadaX, int coordenadaY, Persona persona, float precio) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.persona = persona;
        this.precio = precio;
    }//constrcutor
    /**
     * retorna la coordenada en el eje x de la sila
     * @return coordenadaX
     */
    public int getCoordenadaX() {
        return coordenadaX;
    }//getCoordenadaX
    /**
     * modifica la coordenada en el eje x de la silla
     * @param coordenadaX 
     */
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }//setCoordenadaX
    /**
     * retorna la coordenada en el eje Y de la silla
     * @return coordenadaY
     */
    public int getCoordenadaY() {
        return coordenadaY;
    }//getCoordeadaY
    /**
     * modifica la coordenada en el eje y de la silla
     * @param coordenadaY 
     */
    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }//setCoordenadaY
    /**
     * retorna el objeto de la persona que ocupa la silla
     * @return persona
     */
    public Persona getPersona() {
        return persona;
    }//getPersona
    /**
     * modifica el objeto de la persona que ocupa la silla
     * @param persona 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }//setPersona
    /**
     * retorna el precio de la silla
     * @return getPrecio
     */
    public float getPrecio() {
        return precio;
    }//getPrecio
    /**
     * modifica el precio de la sill
     * @param precio 
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }//setPrecio
    
}//Sillas
