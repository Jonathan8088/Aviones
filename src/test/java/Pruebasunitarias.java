/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Menu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import udec.aviones.AvionEconomico;
import udec.aviones.AvionMixto;
import udec.aviones.AvionVIP;
import udec.aviones.Logica;

/**
 *
 * @author Jonathan
 */
public class Pruebasunitarias {
    
    public Pruebasunitarias() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        llenado();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    static AvionMixto mixto;   
    static AvionEconomico economico;
    static AvionVIP vip;
    
    public static void llenado(){
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
 /*   
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
*/
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void despega(){
        Logica logica = new Logica(mixto);
        boolean respuesta = logica.despegar(mixto);
        assertTrue(respuesta);
    }//despega
    
    @Test
    public void validarCoordenadas(){
        Logica logica = new Logica(mixto);
        boolean respuesta = logica.validarCoordenadas(4, 8);
        assertTrue(respuesta);
    }//validarCoordenadas
    
    @Test
    public void validaSilla(){
        Logica logica = new Logica(vip);
        boolean respuesta = logica.validaSilla('X');
        assertFalse(respuesta);
    }//validaSilla
}//PruebasUnitarias
