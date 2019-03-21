package udec.aviones;

/**
 *clase que contiene los atributos del avion con sillas vip y economicas
 * @author Jonathan
 */
public class AvionMixto extends Avion{
    /**
     * matriz que contiene las sillas VIP del avion
     */
    private char sillasVIP[][];
    /**
     * atributo que contiene el precio de la silla VIP
     */
    private float precioVIP;
    /**
     * constrctor de la clase que inicializa las variables
     * @param precioVIP precio de las sillas vip del avion
     * @param precio precio d elas sillas economicas del avion
     * @param sillas vector que contiene las sillas del avion
     */
    public AvionMixto(float precioVIP, float precio, char[][] sillas) {
        super(sillas,precio,1);
        this.precioVIP = precioVIP;
    }//constructor
    /**
     * retorna la matriz que contiene las sillas VIP
     * @return sillasVIP
     */
    public char[][] getSillasVIP() {
        return sillasVIP;
    }//getSillasVIP
    /**
     * modifica la matriz de sillas VIP
     * @param sillasVIP 
     */
    public void setSillasVIP(char[][] sillasVIP) {
        this.sillasVIP = sillasVIP;
    }//setSillasVIP
    /**
     * retorna el precio de la silla VIP
     * @return precioVIP
     */
    public float getPrecioVIP() {
        return precioVIP;
    }//precioVIP
    /**
     * modifica el precio de la silla VIP
     * @param precioVIP 
     */
    public void setPrecioVIP(float precioVIP) {
        this.precioVIP = precioVIP;
    }//setPrecioVIP
    
}//AvionMixto
