/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import autonoma.simuladorautomovil.exceptions.AccidentePorAceleracionException;
import autonoma.simuladorautomovil.exceptions.VehiculoApagadoException;
import autonoma.simuladorautomovil.exceptions.VehiculoEncendidoException;
import autonoma.simuladorautomovil.exceptions.VehiculoNoConfiguradoException;

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
     * Cilindraje del motor.
     */
    private String cilindraje;

    /**
     * Velocidad máxima en km/h que permite este motor.
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
     * Tipo de motor del vehículo (por ejemplo, "1000 cc", "2000 cc", etc).
     */
    private String tipoMotor;

    /**
     * Constructor de la clase Motor.
     * 
     * @param tipoMotor Tipo de motor (identificación o nombre).
     * @param velocidadMaxima Velocidad máxima permitida por este motor.
     */
    public Motor(String tipoMotor, int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
        this.tipoMotor = tipoMotor;
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
     * @param cilindraje Es el nuevo cilindraje a establecer.
     */
    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    /**
     * Obtiene la velocidad máxima que puede alcanzar el motor.
     * @return Velocidad máxima en km/h.
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Establece la velocidad máxima del motor.
     * @param velocidadMaxima Nueva velocidad máxima en km/h.
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Obtiene el tipo de motor.
     * @return Tipo de motor como cadena de texto.
     */
    public String getTipoMotor() {
        return tipoMotor;
    }

    /**
     * Establece el tipo de motor.
     * @param tipoMotor Nuevo tipo de motor.
     */
    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    /**
     * Enciende el vehículo si no está encendido.
     * @return Mensaje de confirmación.
     * @throws VehiculoEncendidoException Si el vehículo ya estaba encendido.
     */
    public String encender() throws VehiculoNoConfiguradoException{
        if (estaEncendido) {
            throw new VehiculoEncendidoException();
        }
        estaEncendido = true;
        return "Vehiculo encendido.";
    }

    /**
     * Apaga el vehículo si está encendido y la velocidad es segura (≤ 60 km/h).
     * Reinicia la velocidad a 0 si es exitoso.
     * 
     * @return Mensaje de confirmación.
     * @throws VehiculoApagadoException Si ya está apagado.
     * @throws AccidentePorAceleracionException Si la velocidad es mayor a 60 km/h.
     */
    public String apagar() throws VehiculoNoConfiguradoException {
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
     * Muestra el estado actual del motor como una cadena legible.
     * @return "Encendido" o "Apagado" según el estado del motor.
     */
    public String mostrarEstado() {
        return estaEncendido ? "Encendido" : "Apagado";
    }

    /**
     * Verifica si el motor está encendido.
     * @return true si está encendido, false si está apagado.
     */
    public boolean estaEncendido() {
        return estaEncendido;
    }

    /**
     * Establece la velocidad actual del vehículo.
     * @param velocidadActual Nueva velocidad en km/h.
     */
    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    /**
     * Obtiene la velocidad actual del vehículo.
     * @return Velocidad actual en km/h.
     */
    public int getVelocidadActual() {
        return velocidadActual;
    }
}