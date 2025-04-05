/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.simuladorautomovil.main;

import autonoma.simuladorautomovil.exceptions.ErrorEnArchivoConfiguracionException;
import autonoma.simuladorautomovil.models.EscritorArchivoTextoPlano;
import autonoma.simuladorautomovil.models.LectorArchivoTextoPlano;
import autonoma.simuladorautomovil.models.Llanta;
import autonoma.simuladorautomovil.models.LlantaBarata;
import autonoma.simuladorautomovil.models.LlantaBonita;
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

        String tipoLlanta = null;
        if (tipoLlanta == null) {
         System.out.println("tipoLlanta es null. Revisa el archivo de configuración.");
         return;
        }
        try {
           

            Llanta llanta;

            switch (tipoLlanta) {
                case "Buenas":
                    llanta = new LlantaBuena(110); // Asegúrate que este constructor existe
                    break;
                case "Bonitas":
                    llanta = new LlantaBonita(70); // Crea esta clase si no existe
                    break;
                case "Baratas":
                    llanta = new LlantaBarata(50); // Crea esta clase si no existe
                    break;
                default:
                    throw new ErrorEnArchivoConfiguracionException();
            }

            Motor motor = new Motor("2000 c",1000);

            vehiculo = new Vehiculo(llanta, motor);
            eventos.add("Vehículo creado con llantas " + tipoLlanta + " y motor de " + motor.getCilindraje() + " cc.");

        } catch (ErrorEnArchivoConfiguracionException e) {
            JOptionPane.showMessageDialog(null, "Simulación finalizada correctamente.");
            return;
        }

        try {
            vehiculo.encender();
            eventos.add("Encendido correctamente.");

            vehiculo.acelerar(50);
            eventos.add("Aceleró a " + vehiculo.getVelocidadActual() + " km/h.");

            vehiculo.frenar(20);
            eventos.add("Frenó a " + vehiculo.getVelocidadActual() + " km/h.");

            vehiculo.apagar();
            eventos.add("Apagado correctamente.");

        } catch (Exception e) {
            eventos.add("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        try {
            EscritorArchivoTextoPlano escritor = new EscritorArchivoTextoPlano("C:\\Heily\\SimuladorAutomovil\\eventos.txt");
            escritor.escribir(eventos);
            System.out.println("Eventos guardados.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando eventos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}