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
 * @see autonoma.simuladorautomovil.models.Vehiculo
 * @version 1.0.0
 */
public class Simulador {
    private Vehiculo vehiculo;
    private Taller taller;

    public Simulador() {
        this.vehiculo = new Vehiculo(); 
        Lector lector = new LectorArchivoTextoPlano();
        Escritor escritor = new EscritorArchivoTextoPlano("config.csv");
        this.taller = new Taller(vehiculo, lector, escritor);
    }

    public void iniciar(String rutaArchivo)throws IOException {
        taller.configurarVehiculo(rutaArchivo); 
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

}

