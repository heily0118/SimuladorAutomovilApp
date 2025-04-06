/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exceptions;

/**
 *
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250405
 * @version 1.0.0
 * 
 */
public class AccidentePorApagadoException extends RuntimeException{

    public AccidentePorApagadoException() {
        super("El vehiculo no puede ser apagado, esta superando el limite de velocidad (60 km)");
    }

    
}
