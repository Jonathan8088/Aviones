package udec.aviones;

/**
 *clase que contiene los atributos de la silla
 * @author Jonathan
 */
public class Sillas {
    /**
     * objeto que contiene la persona que ocupara la silla
     */
    private Persona persona;
    /**
     * constructor de la clase que incializa las variables
     * @param persona objeto que contiene los atributos de la persona que ocupa la silla
     */
    public Sillas(Persona persona) {
        this.persona = persona;
    }//constrcutor
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
    
}//Sillas
