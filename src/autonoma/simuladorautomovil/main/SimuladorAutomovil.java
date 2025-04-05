/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.simuladorautomovil.main;

import autonoma.simuladorautomovil.models.Llanta;
import autonoma.simuladorautomovil.models.LlantaBuena;
import autonoma.simuladorautomovil.models.Motor;
import autonoma.simuladorautomovil.models.Vehiculo;

/**
 *
 *  
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250405
 * @see 
 * @version 1.0.0
 */
public class SimuladorAutomovil {

      public static void main(String[] args) {
    /**
     * @param args the command line arguments
     */
  
       
        Llanta llantas = new LlantaBuena(110);  
         Motor motor = new Motor("2000 cc", 160);
        Vehiculo vehiculo = new Vehiculo(llantas,motor);  

        try {
            // Realizando acciones y mostrando los resultados devueltos por cada método
            System.out.println(vehiculo.encender());
            System.out.println(vehiculo.acelerar(50));
            System.out.println(vehiculo.frenar(30));
            System.out.println(vehiculo.apagar());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }
}
