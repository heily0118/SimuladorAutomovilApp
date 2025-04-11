/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import java.io.IOException;

/**
 *
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250405
 * @see autonoma.simuladorautomovil.models.Simulador
 * @version 1.0.0
 */
public class Simulador {
    
    /**
     * Objeto que representa el vehículo a simular.
     */
    private Vehiculo vehiculo;

    /**
     * Objeto que representa el taller, encargado de configurar el vehículo.
     */
    private Taller taller;

    /**
     * Constructor de la clase Simulador.
     * Inicializa el vehículo, el lector y el escritor, y los asigna al taller.
     */
    public Simulador() {
        this.vehiculo = new Vehiculo(); 
        Lector lector = new LectorArchivoTextoPlano();
        Escritor escritor = new EscritorArchivoTextoPlano("config.csv");
        this.taller = new Taller(vehiculo, lector, escritor);
    }

    /**
     * Inicia la configuración del vehículo leyendo los datos desde un archivo.
     * 
     * @param rutaArchivo Ruta del archivo de configuración.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public void iniciar(String rutaArchivo) throws IOException {
        taller.configurarVehiculo(rutaArchivo); 
    }

    /**
     * Obtiene el vehículo asociado al simulador.
     * 
     * @return El objeto Vehiculo actualmente configurado.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }
    
}

