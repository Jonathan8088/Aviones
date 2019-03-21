package udec.aviones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *clase que contiene los metodos del avion mixto
 * @author Jonathan
 */
public class Mixto {
    /**
     * constructor de la clase que recibe un objeto de tipo avion
     * @param avion objeto que hace referencia 
     */
    public Mixto(Avion avion) {
        menu(avion);
    }//constructor

    public Mixto(AvionMixto mixto, int tipo) {
        if(tipo==1){
            menuMixto(mixto);
        }else{
           menu(mixto); 
        }//else
    }//constrructor
    Scanner dato = new Scanner(System.in);
    
    private void menu(Avion avion){       
        System.out.println("\nMENU DE AVION");
        System.out.println("1. Comprar Asiento.\n2. Ver Asientos vendidos.\n3. Despegar Avion.\n4. Volver.");
        try {
            byte opcion = dato.nextByte();
            seleccion(opcion, avion);
        } catch (InputMismatchException e) {
            System.out.println("Por favor ingrese una opcion valida");
            dato = new Scanner(System.in);
            menu(avion);
        }//catch
    }//menu
    private void menuMixto(Avion avion){       
        System.out.println("\nMENU DE AVION");
        System.out.println("1. Comprar Asiento.\n2. Ver Asientos vendidos.\n3. Despegar Avion.\n4. Volver.");
        try {
            byte opcion = dato.nextByte();
            seleccionMixto(opcion, avion);
        } catch (InputMismatchException e) {
            System.out.println("Por favor ingrese una opcion valida");
            dato = new Scanner(System.in);
            menuMixto(avion);
        }//catch
    }//menu
    /**
     * metodo que redirige segun la opcion seleccionada
     * @param opcion 
     */
    private void seleccion(byte opcion, Avion avion){
        switch(opcion){
            case 1:{
                pintarAvion(avion);
                comprarAsiento(avion);
                break;
            }case 2:{
                pintarAvion(avion);
                menu(avion);
                break;
            }case 3:{
                System.out.println("El avion despego con un total vendido de: "+avion.total);
                avion.estado = false;
                Menu menu = new Menu(avion);
                break;
            }case 4:{
                Menu menu = new Menu(avion);
                break;
            }default:{
                System.out.println("Por favor ingrese una opcion valida");
                menu(avion);
                break;
            }//default
        }//switch
    }//seleccion
    
    private void seleccionMixto(byte opcion, Avion avion){
        switch(opcion){
            case 1:{
                pintarAvionMixto((AvionMixto)avion);
                comprarAsientoMixto((AvionMixto)avion);
                break;
            }case 2:{
                pintarAvionMixto((AvionMixto)avion);
                menuMixto(avion);
                break;
            }case 3:{
                System.out.println("El avion despego con un total vendido de: "+avion.total);
                avion.estado = false;
                Menu menu = new Menu(avion);
                break;
            }case 4:{
                Menu menu = new Menu(avion);
                break;
            }default:{
                System.out.println("Por favor ingrese una opcion valida");
                menuMixto(avion);
                break;
            }//default
        }//switch
    }//seleccion
    /**
     * metodo que pinta los asientos del avion
     */
    private void pintarAvion(Avion avion){
        System.out.print(" ");
        for(int i =0; i < avion.sillas.length ; i++){
            System.out.print(" "+(i+1));
        }//for
        for(int i = 0 ; i < avion.sillas.length; i++ ){
            System.out.print("\n"+(i+1));
            for(int j = 0 ; j < avion.sillas[i].length; j++){
                System.out.print(" "+avion.sillas[i][j]);
            }//for j
        }//for i
    }//pintarAvion
    
    private void pintarAvionMixto(AvionMixto avion){
        System.out.print(" ");
        for(int i =0; i < avion.getSillasVIP().length ; i++){
            System.out.print(" "+(i+1));
        }//for
        for(int i = 0 ; i < avion.getSillasVIP().length; i++ ){
            System.out.print("\n"+(i+1));
            for(int j = 0 ; j < avion.getSillasVIP()[i].length; j++){
                System.out.print(" "+avion.getSillasVIP()[i][j]);
            }//for j
        }//for i
    }//pintarAvionMixto
    /**
     * metodo que permite la compra de un asiento 
     */
    private void comprarAsiento(Avion avion){
        System.out.println("\nA continuacion digite las coordenadas del asiento que desea comprar");
        System.out.println("Los espacios marcados con O son los asientos disponibles, los marcados como X son asientos ya vendidos");
        System.out.println("Por favor digite la coordenada en x de la silla que desea: ");
        try {
            byte coordenadaX = dato.nextByte();
            if(coordenadaX > avion.sillas.length || coordenadaX <=0){
                System.out.println("Dato fuera del rango de sillas por favor intente de nuevo");
                comprarAsiento(avion);
            }else{
                System.out.println("Por favor digite la coordenada en y de la silla que desea: ");
                byte coordenadaY = dato.nextByte();
                if(coordenadaY > avion.sillas.length || coordenadaY <=0){
                    System.out.println("Dato fuera del rango de sillas por favor intente de nuevo");
                    comprarAsiento(avion);
                }else{
                    vender(avion, coordenadaX, coordenadaY);
                }//else
            }//else    
        } catch (InputMismatchException e) {
            System.out.println("Caracter no valido");
            dato = new Scanner(System.in);
            comprarAsiento(avion);
        }//catch        
    }//conprarAsiento
    
    private void comprarAsientoMixto(AvionMixto avion){
        System.out.println("\nA continuacion digite las coordenadas del asiento que desea comprar");
        System.out.println("Los espacios marcados con O son los asientos disponibles, los marcados como X son asientos ya vendidos");
        System.out.println("Por favor digite la coordenada en x de la silla que desea: ");
        try {
            byte coordenadaX = dato.nextByte();
            if(coordenadaX > avion.getSillasVIP().length || coordenadaX <=0){
                System.out.println("Dato fuera del rango de sillas por favor intente de nuevo");
                comprarAsientoMixto(avion);
            }else{
                System.out.println("Por favor digite la coordenada en y de la silla que desea: ");
                byte coordenadaY = dato.nextByte();
                if(coordenadaY > avion.getSillasVIP().length || coordenadaY <=0){
                    System.out.println("Dato fuera del rango de sillas por favor intente de nuevo");
                    comprarAsientoMixto(avion);
                }else{
                    venderMixto(avion, coordenadaX, coordenadaY);   
                }//else
            }//else    
        } catch (InputMismatchException e) {
            System.out.println("Caracter no valido");
            dato = new Scanner(System.in);
            comprarAsientoMixto(avion);
        }//catch        
    }//conprarAsientoMixto
    /**
     * metodo que cambia la posisicon en el vector segun las coordendas dadas por el cliente
     * @param avion objeto que contiene la matriz donde se encuentran los asientos
     */
    private void vender(Avion avion, byte coordenadaX, byte coordenadaY){
        System.out.println("Esta silla tiene un precio de: "+avion.precio);
        System.out.println("¿Desea confirmar su compra? S/N");
        try {
            String respuesta = dato.next();
            if(respuesta.equals("s")||respuesta.equals("S")){
                for(int i = 0; i<avion.sillas.length; i++){
                    if(i == coordenadaX-1){
                        for(int j = 0 ; j<avion.sillas[i].length;j++){
                            if(j == coordenadaY-1){
                                if(avion.sillas[i][j] == 'O'){
                                    avion.sillas[i][j] = 'X';
                                    avion.total += avion.precio;
                                    menu(avion);
                                }else{
                                    System.out.println("El asiento deseado se encuentra vendido por favor seleccione nuevamente");
                                    comprarAsiento(avion);
                                }//else
                            }//if
                        }//for j
                    }//if
                }//for i
            }else if(respuesta.equals("n")||respuesta.equals("N")){
                menu(avion);
            }else{
                System.out.println("Por favor ingrese una coordenada valida");
                comprarAsiento(avion);
            }//else
        } catch (InputMismatchException e) {
            System.out.println("Caracter no valido");
            vender(avion, coordenadaX, coordenadaY);
        }//catch
    }//vender
    
    private void venderMixto(AvionMixto avion, byte coordenadaX, byte coordenadaY){
        System.out.println("Esta silla tiene un precio de: "+avion.getPrecioVIP());
        System.out.println("¿Desea confirmar su compra? S/N");
        try {
            String respuesta = dato.next();
            if(respuesta.equals("s")||respuesta.equals("S")){
                for(int i = 0; i<avion.getSillasVIP().length; i++){
                    if(i == coordenadaX-1){
                        for(int j = 0 ; j<avion.getSillasVIP()[i].length;j++){
                            if(j == coordenadaY-1){
                                if(avion.getSillasVIP()[i][j] == 'O'){
                                    avion.getSillasVIP()[i][j] = 'X';
                                    avion.total += avion.getPrecioVIP();
                                    menuMixto(avion);
                                }else{
                                    System.out.println("El asiento deseado se encuentra vendido por favor seleccione nuevamente");
                                    comprarAsientoMixto(avion);
                                }//else
                            }//if
                        }//for j
                    }//if
                }//for i
            }else if(respuesta.equals("n")||respuesta.equals("N")){
                menuMixto(avion);
            }//if
        } catch (InputMismatchException e) {
            System.out.println("Caracter no valido");
            venderMixto(avion, coordenadaX, coordenadaY);
        }//catch
    }//vender
}//Mixto
