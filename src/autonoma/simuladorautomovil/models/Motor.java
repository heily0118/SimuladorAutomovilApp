/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import autonoma.simuladorautomovil.exceptions.AccidentePorAceleracionException;
import autonoma.simuladorautomovil.exceptions.VehiculoApagadoException;
import autonoma.simuladorautomovil.exceptions.VehiculoEncendidoException;

/**
 *
 *  
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250405
 * @see autonoma.simuladorautomovil.models.Vehiculo
 * @version 1.0.0
 */

public class Motor {
    /**
     * Cilindraje del motor
     */
    private String cilindraje;
    
    /**
     * Velocidad máxima en km/h.
     */
    private int velocidadMaxima;
    
     /**
     * Indica si el vehículo está encendido (true) o apagado (false).
     */
    private boolean estaEncendido;
    
    /**
     * Velocidad actual del vehículo en km/h.
     */
    private int velocidadActual;
    
    /**
     * Tipo de motor del vehículo.
     */
    private String tipoMotor;

    /**
     * Constructor de la clase Motor
     * 
     */
    public Motor() {
    }

    /**
     * Obtiene el cilindraje del motor.
     * @return Retorna el cilindraje.
     */
    public String getCilindraje() {
        return cilindraje;
    }

    /**
     * Establece el cilindraje del motor.
     * @param cilindraje Es el cilindraje.
     */
    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    /**
     * Obtiene la velocidad máxima que puede alcanzar el motor.
     * @return Retorna la velocidad máxima en km/h.
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Establece la velocidad máxima que puede alcanzar el motor.
     * @param velocidadMaxima Es la velocidad máxima en km/h.
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    
    /**
     * Obtiene el tipo de motor.
     * @return Retorna una cadena que representa el tipo de motor.
     */
    public String getTipoMotor() {
        return tipoMotor;
    }

    /**
     * Establece el tipo de motor.
     * @param tipoMotor Es la cadena que representa el nuevo tipo de motor.
     */
    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }
    
    /**
     * Enciende el vehículo si no está encendido.
     * @return Retorna el mensaje de confirmación (Encendido).
     * @throws VehiculoEncendidoException Se lanza esta excepción si el vehículo ya está encendido.
     */
    public String encender(){
        if (estaEncendido) {
            throw new VehiculoEncendidoException();
        }
        estaEncendido = true;
        return "Vehiculo encendido.";
    }

    /**
     * Apaga el vehículo si está encendido y la velocidad es segura.
     * @return Mensaje de confirmación (Apagado).
     * @throws VehiculoApagadoException Se lanza esta excepción si ya está apagado.
     * @throws AccidentePorAceleracionException Se lanza esta excepción si la velocidad es mayor a 60 km/h.
     */
    public String apagar() {
        if (!estaEncendido) {
            throw new VehiculoApagadoException();
        }
        
        if (velocidadActual > 60) {
            throw new AccidentePorAceleracionException();
        }
        estaEncendido = false;
        velocidadActual = 0;
        return "Vehiculo apagado.";
    }
    
    /**
     * Muestra en consola el estado actual del vehículo.
     * @return el esta del auto encendido o apagado
     */
    public String mostrarEstado() {
        return (estaEncendido ? "Encendido" : "Apagado");
    }

}
