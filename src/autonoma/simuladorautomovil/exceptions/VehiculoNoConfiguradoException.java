/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exceptions;

/**
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @see autonoma.simuladorautomovil.exceptions.VehiculoNoConfiguradoException
 * @since 20250405
 * @version 1.0.0
 * 
 */
public class VehiculoNoConfiguradoException extends RuntimeException{

    public VehiculoNoConfiguradoException() {
        super("Primero debe configurar el vehículo antes de continuar.");
    }
    
}
