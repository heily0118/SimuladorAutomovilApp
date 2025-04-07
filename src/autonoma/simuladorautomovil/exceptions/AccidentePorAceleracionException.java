/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exceptions;

/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250405
 * @see autonoma.simuladorautomovil.models.Vehiculo
 * @version 1.0.0
 */
public class AccidentePorAceleracionException extends RuntimeException {

    public AccidentePorAceleracionException() {
        super("El vehículo se accidentó al apagarse a más de 60 km/h.");
    }
    
    
}
