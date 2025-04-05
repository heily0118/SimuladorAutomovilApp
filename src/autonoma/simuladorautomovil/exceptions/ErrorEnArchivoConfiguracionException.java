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
public class ErrorEnArchivoConfiguracionException extends RuntimeException{

    public ErrorEnArchivoConfiguracionException() {
        super("Error: No se pudo leer el archivo de configuración");
    }
    
}
