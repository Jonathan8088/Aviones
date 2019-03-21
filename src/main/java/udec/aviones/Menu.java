package udec.aviones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *clase que contiene el menu principal del proyecto
 * @author Jonathan
 */
public class Menu {
    /**
     * objeto que hace referecia al avion  con asientos economicos y vip
     */
    AvionMixto mixto;
    /**
     * objeto que hace referencia al avion con solamente asientos economicos
     */    
    AvionEconomico economico;
    /**
     * objeto que hace referencia al avion con solamente asientos vip
     */    
    AvionVIP vip;
    
    Scanner dato = new Scanner(System.in);
    /**
     * constructor de la clase 
     */
    public Menu() {
        llenado();
        menu();
    }//constructor
    /**
     * constructor que recibe un objeto tipo avion traido de otra clase
     * @param avion objeto con los atributos del avion
     */
    public Menu(Avion avion) {
        if(avion.tipo == 1){
            mixto = (AvionMixto) avion;
        }else if(avion.tipo == 2){
            economico= (AvionEconomico)avion;
        }else if(avion.tipo == 3){
            vip = (AvionVIP) avion;
        }//if
        menu();
    }//constructor
    /**
     * metodo que muestra por consola el menu principal del proyecto
     */
    private void menu(){
        System.out.println("Por favor seleccione el avion deseado: ");
        System.out.println("1. Avion Mixto.\n2. Avion Economico.\n3. Avion VIP.");
        try {
            byte opcion = dato.nextByte();
            seleccion(opcion);
        } catch (InputMismatchException e) {
            System.out.println("Caracter no valido");
            dato = new Scanner(System.in);
            menu();
        }//catch
    }//menu
    /**
     * metodo que redirige segun la eleccion enviada desde menu
     * @param opcion opcion seleccionada en menu
     */
    private void seleccion(byte opcion){
        switch(opcion){
            case 1:{
                validar(mixto);
                System.out.println("Elija el tipo de silla que desea comprar:");
                System.out.println("1. VIP.\n2. Economica.");
                try {
                    byte seleccion = dato.nextByte();
                    if(seleccion == 1){
                        Mixto menuMixto = new Mixto(mixto,1);
                    }else{
                        Mixto menuMixto = new Mixto(mixto,2);
                    }//else
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Caracter no valido");
                    dato = new Scanner(System.in);
                    seleccion(opcion);
                }//catch
            }case 2:{
                validar(economico);
                Mixto mixto = new Mixto(economico);
                break;
            }case 3:{
                validar(vip);
                Mixto mixto = new Mixto(vip);
                break;
            }default:{
                System.out.println("Por favor digite un numero valido");
                menu();
            }//default 
        }//switch
    }//seleccion
    /**
     * metodo que llena por defecto las matrices
     */
    private void llenado(){
        mixto = new AvionMixto(5000,2000,new  char[3][3] );
        mixto.setSillasVIP(new char[2][2]);
        mixto.estado = true;
        for(int i=0; i <mixto.sillas.length;i++){
            for(int j=0 ; j< mixto.sillas[i].length;j++){
                mixto.sillas[i][j] = 'O';
            }//for j
        }//for i
        for(int i=0; i <mixto.getSillasVIP().length;i++){
            for(int j=0 ; j< mixto.getSillasVIP()[i].length;j++){
                mixto.getSillasVIP()[i][j] = 'O';
            }//for j
        }//for i
        economico = new AvionEconomico(new char[5][5], 2000);
        economico.estado = true;
        for(int i=0; i <economico.sillas.length;i++){
            for(int j=0 ; j< economico.sillas[i].length;j++){
                economico.sillas[i][j] = 'O';
            }//for j
        }//for i
        vip = new AvionVIP(new char[3][3], 5000);
        vip.estado = true;
        for(int i=0; i <vip.sillas.length;i++){
            for(int j=0 ; j< vip.sillas[i].length;j++){
                vip.sillas[i][j] = 'O';
            }//for j
        }//for i
    }//llenado
    private void validar(Avion avion){
        if(avion.estado == false){
            System.out.println("Lo sentimos este avion ya ha despegado, seleccione otro avion");
            menu();
        }
    }//validar
}//Menu
