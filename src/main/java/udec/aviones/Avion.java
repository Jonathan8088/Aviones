package udec.aviones;

/**
 *clase padre que contiene atributos propios de los avones
 * @author Jonathan
 */
public class Avion {
    /**
     * array que contiene las sillas que contiene el avion
     */
    public char sillas[][];
    /**
     * atributo que contine el precio de las sillas del avion
     */
    protected float precio;
    /**
     * atributo qeu contiene el valor total recogido por la venta de los asientos del avion
     */
    protected float total;
    /**
     * atributo que contiene el tipo de avion referenciado por un numero
     */
    protected int tipo;
    /**
     * atributo que contiene el estado actual del avion
     */
    public boolean estado;
    /**
     * costructor de la clase
     * @param sillas contiene el vector con las sillas del avion
     * @param precio precio de las sillas del avion
     * @param tipo numeor que diferencia el tipo de avion
     */
    public Avion(char[][] sillas,float precio, int tipo) {
        this.sillas = sillas;
        this.precio = precio;
        this.tipo = tipo;
    }//constructor
    /**
     * retorna el vector con las sillas del avion
     * @return sillas
     */
    public char[][] getSillas() {
        return sillas;
    }//getSillas
    /**
     * modifica el vector de las silas
     * @param sillas 
     */
    public void setSillas(char[][] sillas) {
        this.sillas = sillas;
    }//setSillas
    /**
     * retorna el precio de las sills del avion
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }//getPrecio
    /**
     * modifica el precio de las silas del avion
     * @param precio 
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }//setPrecio
    /**
     * retorna el valor total recogido por la venta de asientos del avion
     * @return total
     */
    public float getTotal() {
        return total;
    }//getTotal
    /**
     * modifica el valor total recogido por la venta de asientos del avion
     * @param total 
     */
    public void setTotal(float total) {
        this.total = total;
    }//setTotal
    /**
     * retorna el tipo del avion
     * @return tipo
     */
    public int getTipo() {
        return tipo;
    }//getTipo
    /**
     * modifica el tipo del avion
     * @param tipo 
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }//setTipo
    /**
     * retorna el estado del avion
     * @return estado
     */
    public boolean isEstado() {
        return estado;
    }//isEstado
    /**
     * modifica el estado del avion
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }//setEstado
    
}//Avion
