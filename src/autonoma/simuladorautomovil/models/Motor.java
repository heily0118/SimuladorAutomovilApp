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

    private String cilindraje;
    private int velocidadMaxima;
    private boolean estaEncendido;
    private int velocidadActual;
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

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    /**
     * Enciende el motor si no está encendido.
     * 
     * @return Mensaje de confirmación.
     * @throws VehiculoEncendidoException Si el motor ya estaba encendido.
     */
    public String encender() throws VehiculoEncendidoException {
        if (estaEncendido) {
            throw new VehiculoEncendidoException();
        }
        estaEncendido = true;
        return "Vehiculo encendido.";
    }

    /**
     * Apaga el motor si está encendido y la velocidad es segura (≤ 60 km/h).
     * Reinicia la velocidad a 0 si se apaga correctamente.
     * 
     * @return Mensaje de confirmación.
     * @throws VehiculoApagadoException Si el motor ya está apagado.
     * @throws AccidentePorAceleracionException Si la velocidad es mayor a 60 km/h.
     */
    public String apagar() throws VehiculoApagadoException, AccidentePorAceleracionException {
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
     * 
     * @return "Encendido" o "Apagado" según el estado del motor.
     */
    public String mostrarEstado() {
        return estaEncendido ? "Encendido" : "Apagado";
    }

    /**
     * Verifica si el motor está encendido.
     * 
     * @return true si está encendido, false si está apagado.
     */
    public boolean estaEncendido() {
        return estaEncendido;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }
}