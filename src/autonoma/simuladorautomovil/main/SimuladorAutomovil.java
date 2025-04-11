/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.simuladorautomovil.main;

import autonoma.simuladorautomovil.models.Simulador;
import autonoma.simuladorautomovil.views.VentanaPrincipal;


/**
 *
 *  
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250405
 * @see autonoma.simuladorautomovil.models.Vehiculo
 * @see autonoma.simuladorautomovil.models.Motor
 * @see autonoma.simuladorautomovil.models.Llanta
 * @see autonoma.simuladorautomovil.views.VentanaPrincipal
 * @version 1.0.0
 */
public class SimuladorAutomovil {
    public static void main(String[] args) {
       Simulador simulador = new Simulador(); 
        VentanaPrincipal ventana = new VentanaPrincipal(simulador); 
        ventana.setVisible(true); 
    }
}