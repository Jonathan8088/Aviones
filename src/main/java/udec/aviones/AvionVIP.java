package udec.aviones;

/**
 *clase que contiene los atributos del avion con sillas VIP
 * @author Jonathan
 */
public class AvionVIP extends Avion{
    /**
     * constructor de la clase que inicializa las variables
     * @param sillas vector de sillas que contiene el avion
     * @param precio precio de las sillas del avion
     */
    public AvionVIP(char[][] sillas, float precio) {
        super(sillas,precio,3);
    }//constructor
}//AvionVIP
