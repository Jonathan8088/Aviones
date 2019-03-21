package udec.aviones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

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
    /**
     * constructor de la clase que se instancia cuando se enva un objeto del avion mixto
     * @param mixto objeto del avion mixto
     * @param tipo tipo de silla que identifica que tipo de silla desea administrar
     */
    public Mixto(AvionMixto mixto, int tipo) {
        if(tipo==1){
            menuMixto(mixto);
        }else{
           menu(mixto); 
        }//else
    }//constrructor
    Scanner dato = new Scanner(System.in);
    /**
     * menu que se muestra al comenzar la clase
     * @param avion objeto que contiene los atributos del avion a administrar
     */
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
    /**
     * menu que se muestra al querer administrar las sillas vip del avion mixto
     * @param avion 
     */
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
     * metodo que redrige seggun la opion del usuario
     * @param opcion seleccion dada por el usuario
     * @param avion objeto con los atibutos del avion que se va a administrar
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
    /**
     * metodo que redirige cuando se quiere administrar las sills vip del avion mixto
     * @param opcion opcion deseada por el usuario
     * @param avion objeto del avion mixto
     */
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
     * @param avion objeto con los atributos del avion que se va a mostrar por consola
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
    /**
     * metodo que muestra por consola las sillas vip del avion mixto
     * @param avion objeto con los atributos del avion mixto
     */
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
     * @param avion objeto con los atributos del avion en el cual se va a realizar la compra del asiento
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
    /**
     * metodo que permite realizar la compra de un asiento vip en el avion mixto
     * @param avion objeto con los atributos del avion mixto
     */
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
     * @param coordenadaX coordenada en el eje x de la ubicacion del asiento
     * @param coordenadaY coordenada en el eje y de la ubicacion del asiento
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
                                    datosCliente();
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
    /**
     * metodo que confirma la venta del asiento de tipo vip en el avion mixto
     * @param avion objeto con los atributos del avion mixto
     * @param coordenadaX coordenada en el eje x del asiento que se va a vender
     * @param coordenadaY coordenada en el eje y del asiento que se va a vender
     */
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
                                    datosCliente();
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
    }//venderMixto
    /**
     * metodo qeu captura y valida los datos del cliente que va a realizar la compra
     */
    private void datosCliente(){
        try{
        System.out.println("Ingrese su identificacion: ");
        int identificacion = dato.nextInt();
        System.out.println("Por favor ingrese su nombre: ");
        String nombre = dato.next();
        boolean alfa = Pattern.matches("^[a-zA-Z]*$", nombre);
        if(!alfa){
            System.out.println("El nombre solamente puede contener letras");
            datosCliente();
        }//if
        System.out.println("Introduzca su fecha con formato dd/mm/yyyy");
        String fecha = dato.next();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;
        String date = fecha;
        Persona persona = new Persona(identificacion, nombre, df.parse(date));
        }catch(InputMismatchException e){
            System.out.println("Datos no validos");
            dato = new Scanner(System.in);
            datosCliente();
        }catch (ParseException e){
            System.out.println("Fecha invalida");
            dato = new Scanner(System.in);
            datosCliente();
        }//catch
    }//datosCliente
}//Mixto
