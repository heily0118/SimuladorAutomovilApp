/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.simuladorautomovil.main;

import autonoma.simuladorautomovil.exceptions.ErrorEnArchivoConfiguracionException;
import autonoma.simuladorautomovil.models.EscritorArchivoTextoPlano;
import autonoma.simuladorautomovil.models.LectorArchivoTextoPlano;
import autonoma.simuladorautomovil.models.Llanta;
import autonoma.simuladorautomovil.models.LlantaBuena;
import autonoma.simuladorautomovil.models.Motor;
import autonoma.simuladorautomovil.models.Vehiculo;
import autonoma.simuladorautomovil.views.VentanaPrincipal;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
       VentanaPrincipal ventana = new VentanaPrincipal();
       ventana.setVisible(true);   

        ArrayList<String> eventos = new ArrayList<>();
        Vehiculo vehiculo = null;

        try {
           
           

        } catch (ErrorEnArchivoConfiguracionException e) {
            JOptionPane.showMessageDialog(null, " Error leyendo configuración: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;  
        }

        try {
            
            vehiculo.encender();
            eventos.add("Encendido correctamente.");

            vehiculo.acelerar(50);
            eventos.add("Acelero a " + vehiculo.getVelocidadActual() + " km/h.");

            vehiculo.frenar(20);
            eventos.add("Freno a " + vehiculo.getVelocidadActual() + " km/h.");

            vehiculo.apagar();
            eventos.add("Apagado correctamente.");

        } catch (Exception e) {
            eventos.add( e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        
        try {
            EscritorArchivoTextoPlano escritor = new EscritorArchivoTextoPlano("C:\\Heily\\SimuladorAutomovil\\eventos.txt");
            escritor.escribir(eventos);
            System.out.println("Eventos guardados.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error guardando eventos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
