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
     * @param cilindraje Es el cilindraje del motor.
     * @param velocidadMaxima Es la velocidad máxima que puede alcanzar el motor.
     */
    public Motor(String cilindraje, int velocidadMaxima) {
        this.cilindraje = cilindraje;
        this.velocidadMaxima = velocidadMaxima;
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

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }
    
    
}
