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

    /** Vehículo que se va a configurar y manipular en el taller */
    private Vehiculo vehiculo;

    /** Objeto responsable de leer archivos de configuración */
    private Lector lector;

    /** Objeto responsable de escribir archivos de configuración */
    private Escritor escritor;

    /**
     * Constructor para inicializar el taller con un vehículo, un lector y un escritor.
     * 
     * @param vehiculo Vehículo a ser configurado y manipulado.
     * @param lector Objeto para leer archivos de configuración.
     * @param escritor Objeto para guardar configuraciones en archivos.
     */
    public Taller(Vehiculo vehiculo, Lector lector, Escritor escritor) {
        this.vehiculo = vehiculo;
        this.lector = lector;
        this.escritor = escritor;
    }

        /**
     * Obtiene el vehículo configurado.
     * 
     * @return El objeto Vehiculo actual.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo que será utilizado.
     * 
     * @param vehiculo El objeto Vehiculo a configurar.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene el lector actual para archivos o datos.
     * 
     * @return El objeto Lector.
     */
    public Lector getLector() {
        return lector;
    }

    /**
     * Establece el lector que se utilizará para leer datos.
     * 
     * @param lector El objeto Lector a configurar.
     */
    public void setLector(Lector lector) {
        this.lector = lector;
    }

    /**
     * Obtiene el escritor actual para guardar información.
     * 
     * @return El objeto Escritor.
     */
    public Escritor getEscritor() {
        return escritor;
    }

    /**
     * Establece el escritor que se utilizará para guardar datos.
     * 
     * @param escritor El objeto Escritor a configurar.
     */
    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }


    /**
     * Configura el vehículo leyendo el archivo de configuración especificado.
     * 
     * @param rutaArchivo Ruta del archivo que contiene la configuración.
     * @throws IOException Si hay un problema leyendo el archivo o los datos no están bien formados.
     */
    public void configurarVehiculo(String rutaArchivo) throws IOException {
        ArrayList<String> lineas = lector.leer(rutaArchivo);

        String tipoLlanta = null;
        String tipoMotor = null;

        for (String linea : lineas) {
            String[] partes = linea.trim().split(";");
            if (partes.length < 2) {
                throw new IOException("Línea mal formada en archivo de configuración: " + linea);
            }

            if (partes[0].equalsIgnoreCase("llantas")) {
                tipoLlanta = partes[1];
            } else if (partes[0].equalsIgnoreCase("motor")) {
                tipoMotor = partes[1];
            }
        }

        Llanta llanta = crearLlantaPorTipo(tipoLlanta);
        Motor motor = crearMotorPorTipo(tipoMotor);

        vehiculo.setLlantas(llanta);
        vehiculo.setMotor(motor);
    }

    /**
     * Guarda la configuración actual del vehículo en el archivo asociado al escritor.
     * 
     * @throws IOException Si hay un problema al escribir la configuración.
     */
    public void guardarConfiguracion() throws IOException {
        if (vehiculo.getLlantas() == null || vehiculo.getMotor() == null) {
            throw new IOException("No se puede guardar configuración: el vehículo no está completamente configurado.");
        }

        ArrayList<String> contenido = new ArrayList<>();
        contenido.add("llantas;" + vehiculo.getLlantas().getTipoLlanta());
        contenido.add("motor;" + vehiculo.getMotor().getTipoMotor());

        escritor.escribir(contenido);
    }

    /**
     * Crea una instancia de Llanta según el tipo especificado.
     * 
     * @param tipo Tipo de llanta (buenas, bonitas, baratas).
     * @return Una instancia de Llanta con sus características correspondientes.
     */
        private Llanta crearLlantaPorTipo(String tipo) {
         switch (tipo.toLowerCase()) {
             case "buenas":
                 return new Llanta(110, "Buenas");
             case "bonitas":
                 return new Llanta(70, "Bonitas");
             case "baratas":
                 return new Llanta(50, "Baratas");
             default:
                 throw new IllegalArgumentException("Tipo de llanta no reconocido: " + tipo);
         }
     }
        
    /**
     * Crea una instancia de Motor según el tipo de cilindraje especificado.
     * 
     * @param tipo Tipo de motor (1000, 2000, 3000).
     * @return Una instancia de Motor con su cilindraje y velocidad máxima.
     * @throws IllegalArgumentException Si el tipo de motor no es válido.
     */
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