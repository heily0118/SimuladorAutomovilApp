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
    /**
     * Vehículo que se va a configurar y manipular en el taller
     */
    private Vehiculo vehiculo;
    
    /**
     * Objeto responsable de leer archivos de configuración
     */
    private Lector lector;
    
    /**
     * Objeto responsable de escribir archivos de configuración
     */
    private Escritor escritor;

    /**
     * Constructor para inicializar el taller con un vehículo, un lector y un escritor.
     * @param vehiculo vehiculo Vehículo a ser configurado y manipulado.
     * @param lector Objeto para leer archivos de configuración.
     * @param escritor Objeto para guardar configuraciones en archivos.
     */
    public Taller(Vehiculo vehiculo, Lector lector, Escritor escritor) {
        this.vehiculo = vehiculo;
        this.lector = lector;
        this.escritor = escritor;
    }

    /**
     * Obtiene el vehículo que se encuentra en el taller.
     * @return Retorna el vehículo actual.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo que estará disponible en el taller.
     * @param vehiculo Es el vehículo a configurar y manipular.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene el lector que se utiliza para leer archivos de configuración del vehículo.
     * @return Retorna el lector actual.
     */
    public Lector getLector() {
        return lector;
    }
    
    /**
     * Establece el lector que se utilizará para leer los archivos de configuración del vehículo.
     * @param lector Es el lector que se desea utilizar.
     */
    public void setLector(Lector lector) {
        this.lector = lector;
    }

    /**
     * Obtiene el escritor que se utiliza para guardar la configuración del vehículo.
     * @return Retorna el escritor actual.
     */
    public Escritor getEscritor() {
        return escritor;
    }

    /**
     * Establece el escritor que se utilizará para guardar la configuración del vehículo.
     * @param escritor Es el escritor que se desea utilizar.
     */
    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }
    
    

    /**
     * Configura el vehículo leyendo el archivo de configuración
     * @throws IOException Si hay un problema leyendo el archivo
     */
    public void configurarVehiculo(String rutaArchivo) throws IOException {
        ArrayList<String> lineas = lector.leer(rutaArchivo);

        String tipoLlanta = "";
        String tipoMotor = "";

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
     * Guarda la configuración actual del vehículo en el archivo
     * @throws IOException si hay un problema escribiendo el archivo
     */
    public void guardarConfiguracion() throws IOException {
        ArrayList<String> contenido = new ArrayList<>();
        contenido.add("llantas " + vehiculo.getLlantas().getTipoLlanta());
        contenido.add("motor " + vehiculo.getMotor().getCilindraje());

        escritor.escribir(contenido);
    }

    /**
     * Crea un objeto de tipo Llanta según el tipo especificado.
     * @param tipo Es el Tipo de llanta.
     * @return Retorna una instancia de Llanta con las características correspondientes al tipo.
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
            System.out.println("Tipo de llanta no reconocido: " + tipo);
            return new Llanta(0, "Desconocida");

       }
    }

    /**
     * Crea un objeto de tipo Motor según el tipo de cilindraje especificado.
     * @param tipo Es una cadena que representa el tipo de motor.
     * @return Si el tipo de motor no es válido.
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