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
    private Lector lector;
    private Escritor escritor;

    public Taller(Vehiculo vehiculo, Lector lector, Escritor escritor) {
        this.vehiculo = vehiculo;
        this.lector = lector;
        this.escritor = escritor;
    }

    /**
     * Configura el vehículo leyendo el archivo de configuración
     * @throws IOException si hay un problema leyendo el archivo
     */
    public void configurarVehiculo() throws IOException {
        ArrayList<String> lineas = lector.leer("config.csv");

        String tipoLlanta = "";
        String tipoMotor = "";

        for (String linea : lineas) {
            if (linea.toLowerCase().startsWith("llantas")) {
                tipoLlanta = linea.split(" ")[1];
            } else if (linea.toLowerCase().startsWith("motor")) {
                tipoMotor = linea.split(" ")[1];
            }
        }

        Llanta llanta = crearLlantaPorTipo(tipoLlanta);
        Motor motor = crearMotorPorTipo(tipoMotor);

        vehiculo.setLlanta(llanta);
        vehiculo.setMotor(motor);
    }

    /**
     * Guarda la configuración actual del vehículo en el archivo
     * @throws IOException si hay un problema escribiendo el archivo
     */
    public void guardarConfiguracion() throws IOException {
        ArrayList<String> contenido = new ArrayList<>();
        contenido.add("llantas " + vehiculo.getLlantas().getTipoLlanta());
        contenido.add("motor " + vehiculo.getMotor().getTipoMotor());

        escritor.escribir(contenido);
    }

    private Llanta crearLlantaPorTipo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "buenas":
                return new Llanta("Buenas", 110);
            case "bonitas":
                return new Llanta("Bonitas", 70);
            case "baratas":
                return new Llanta("Baratas", 50);
            default:
                throw new IllegalArgumentException("Tipo de llanta no válido: " + tipo);
        }
    }

    private Motor crearMotorPorTipo(String tipo) {
        switch (tipo) {
            case "1000":
                return new Motor("1000 cc", 100);
            case "2000":
                return new Motor("2000 cc", 160);
            case "3000":
                return new Motor("3000 cc", 220);
            default:
                throw new IllegalArgumentException("Tipo de motor no válido: " + tipo);
        }
    }
}