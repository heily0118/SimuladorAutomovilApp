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
        ArrayList<String> eventos = new ArrayList<>();
        Vehiculo vehiculo = null;

       
        String tipoLlanta = null;
        int potenciaMotor = 0;
        String cilindrajeMotor = "";

       
        try {
            LectorArchivoTextoPlano lector = new LectorArchivoTextoPlano();
            ArrayList<String> lineas = lector.leer("config.csv");

            for (String linea : lineas) {
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    String clave = partes[0].trim().toLowerCase();
                    String valor = partes[1].trim();

                    if (clave.equals("llantas")) {
                        tipoLlanta = valor;
                    } else if (clave.equals("motor")) {
                        cilindrajeMotor = valor + " c";
                        potenciaMotor = Integer.parseInt(valor);
                    }
                }
            }

            if (tipoLlanta == null || cilindrajeMotor.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Archivo de configuración incompleto.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error leyendo archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    
        try {
            Llanta llanta;
            switch (tipoLlanta) {
                case "Buenas":
                    llanta = new LlantaBuena();
                    break;
                case "Bonitas":
                    llanta = new LlantaBonita();
                    break;
                case "Baratas":
                    llanta = new LlantaBarata();
                    break;
                default:
                    throw new ErrorEnArchivoConfiguracionException();
            }

            Motor motor = new Motor(cilindrajeMotor, potenciaMotor);
            vehiculo = new Vehiculo(llanta, motor);

            eventos.add("Vehículo creado con llantas: " + tipoLlanta);
            eventos.add("Motor: " + cilindrajeMotor + ", Potencia: " + potenciaMotor + " HP");

        } catch (ErrorEnArchivoConfiguracionException e) {
            JOptionPane.showMessageDialog(null, "Error en configuración: llantas inválidas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

     
        VentanaPrincipal ventana = new VentanaPrincipal(vehiculo, eventos);
        ventana.setVisible(true);

       
        try {
            vehiculo.encender();
            eventos.add("Vehículo encendido.");

            vehiculo.acelerar(50);
            eventos.add("Aceleró a " + vehiculo.getVelocidadActual() + " km/h.");

            vehiculo.frenar(20);
            eventos.add("Frenó a " + vehiculo.getVelocidadActual() + " km/h.");

            vehiculo.apagar();
            eventos.add("Vehículo apagado.");

        } catch (Exception e) {
            eventos.add("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

   
        try {
            EscritorArchivoTextoPlano escritor = new EscritorArchivoTextoPlano("eventos.txt");
            escritor.escribir(eventos);
            System.out.println("Eventos guardados.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando eventos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}