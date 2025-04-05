/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exceptions;

/**
 *
 * @author USUARIO
 */
public class AccidentePorAceleracionException extends RuntimeException {

    public AccidentePorAceleracionException() {
        super("El vehículo se accidentó al apagarse a más de 60 km/h.");
    }
    
    
}
