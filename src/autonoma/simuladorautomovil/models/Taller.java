/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250405
 * @see autonoma.simuladorautomovil.models.Vehiculo
 * @version 1.0.0
 */
public class Taller {

    private Vehiculo vehiculo;

    public Taller() {
        this.vehiculo = new Vehiculo();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String configurarLlantas(String tipo) {
        int velocidadMax;
        switch (tipo.toLowerCase()) {
            case "baratas":
                velocidadMax = 50;
                break;
            case "bonitas":
                velocidadMax = 70;
                break;
            case "buenas":
                velocidadMax = 110;
                break;
            default:
                return "Tipo de llanta no reconocido.";
        }

        Llanta llanta = new Llanta(velocidadMax, tipo);
        vehiculo.setLlantas(llanta);
        return "Llantas configuradas correctamente.";
    }

    public String configurarMotor(String cilindraje) {
        int velocidadMax;
        switch (cilindraje.toLowerCase()) {
            case "1.0":
                velocidadMax = 60;
                break;
            case "1.6":
                velocidadMax = 100;
                break;
            case "2.0":
                velocidadMax = 140;
                break;
            default:
                return "Cilindraje no reconocido.";
        }

        Motor motor = new Motor(cilindraje, velocidadMax);
        vehiculo.setMotor(motor);
        return "Motor configurado correctamente.";
    }

    public ArrayList<String> generarDatosVehiculo() {
        ArrayList<String> datos = new ArrayList<>();
        datos.add("Motor:" + vehiculo.getMotor().getCilindraje());
        datos.add("VelocidadMotor:" + vehiculo.getMotor().getVelocidadMaxima());
        datos.add("Llanta:" + vehiculo.getLlantas().getTipoLlanta());
        datos.add("VelocidadLlanta:" + vehiculo.getLlantas().getVelocidadMaxima());
        return datos;
    }
}