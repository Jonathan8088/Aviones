package udec.aviones;

/**
 *clase que contiene los atributos del avion con sillas economicas
 * @author Jonathan
 */
public class AvionEconomico extends Avion{
    /**
     * constructor de la clase que inicializa las variables
     * @param sillas vector de sillas que contiene el avion
     * @param precio precio de las sillas del avion
     */
    public AvionEconomico(char[][] sillas,float precio) {
        super(sillas,precio,2);
    }//constructor
    /**
     * atributo que contiene el precio de las sillas
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }//getPrecio
}//AvionEconomico
