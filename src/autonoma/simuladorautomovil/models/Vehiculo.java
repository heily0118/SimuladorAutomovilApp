/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import autonoma.simuladorautomovil.exceptions.VehiculoApagadoException;
import autonoma.simuladorautomovil.exceptions.VehiculoEncendidoException;
import autonoma.simuladorautomovil.exceptions.AccidentePorAceleracionException;
import autonoma.simuladorautomovil.exceptions.KilometrajeInsuficienteException;
import autonoma.simuladorautomovil.exceptions.LimiteDeVelocidadExcedidoException;
import autonoma.simuladorautomovil.exceptions.PatinajeException;
import autonoma.simuladorautomovil.exceptions.TerrenoIrregularException;
import autonoma.simuladorautomovil.exceptions.VehiculoDetenidoException;
/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @autor María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250405
 * @see Llanta
 * @see Motor
 * @see VehiculoApagadoException
 * @see VehiculoEncendidoException
 * @see AccidentePorAceleracionException
 * @see LimiteDeVelocidadExcedidoException
 * @see PatinajeException
 * @see KilometrajeInsuficienteException
 * @see TerrenoIrregularException
 * @see VehiculoDetenidoException
 * @version 1.0.0
 */
public class Vehiculo {

    /**
     * Llantas del vehículo.
     */
    private Llanta llantas;

    /**
     * Motor del vehículo.
     */
    private Motor motor;

    /**
     * Velocidad actual del vehículo en km/h.
     */
    private int velocidadActual;

    /**
     * Crea un nuevo vehículo sin configurar.
     */
    public Vehiculo() {}

    /**
     * Obtiene las llantas del vehículo.
     * @return Retorna las llantas del vehículo.
     */
    public Llanta getLlantas() {
        return llantas;
    }

    /**
     * Establece nuevas llantas para el vehículo.
     * @param llantas Son las llantas a asignar.
     */
    public void setLlantas(Llanta llantas) {
        this.llantas = llantas;
    }

    /**
     * Obtiene el motor del vehículo.
     * @return Retorna el motor del vehículo.
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * Establece un nuevo motor para el vehículo.
     * @param motor Es el motor a asignar.
     */
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    /**
     * Obtiene la velocidad actual del vehículo.
     * @return Retorna la velocidad actual en km/h.
     */
    public int getVelocidadActual() {
        return velocidadActual;
    }

    /**
     * Establece la velocidad actual del vehículo.
     * @param velocidadActual Es la velocidad en km/h a asignar.
     */
    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    /**
     * Enciende el vehículo si ya está configurado.
     * @return Retorna un mensaje indicando si el motor fue encendido o ya estaba encendido.
     */
    public String encender() {
        if (!estaConfigurado()) {
            return "Debe configurar el vehículo antes de encenderlo.";
        }
        return motor.encender();
    }

    /**
     * Apaga el vehículo si está encendido.
     * También reinicia la velocidad actual a 0.
     * @return Retorna un mensaje indicando que el vehículo fue apagado correctamente.
     */
    public String apagar() {
        String mensaje = motor.apagar();
        this.velocidadActual = 0;
        return mensaje;
    }

    /**
     * Verifica si el vehículo está encendido.
     * @return Retorna true si el motor está encendido, false en caso contrario.
     */
    public boolean estaEncendido() {
        return motor != null && motor.estaEncendido();
    }

    /**
     * Acelera el vehículo en una cantidad específica.
     * @param cantidad Es el aumento de velocidad en km/h.
     * @return Retorna el mensaje con la nueva velocidad (Aceleración).
     * @throws VehiculoApagadoException Se lanza esta excepción si el vehículo está apagado.
     * @throws LimiteDeVelocidadExcedidoException Se lanza esta excepción si se supera el límite de velocidad de las llantas.
     */
    public String acelerar(int cantidad) {
        if (!estaEncendido()) {
            throw new VehiculoApagadoException();
        }
        if (velocidadActual + cantidad > llantas.getVelocidadMaxima()) {
            throw new LimiteDeVelocidadExcedidoException();
        }
        velocidadActual += cantidad;
        return "Vehiculo acelerado a " + velocidadActual + " km/h.";
    }

    /**
     * Frena el vehículo reduciendo su velocidad en una cantidad específica.
     * @param cantidad Es la disminución de velocidad en km/h.
     * @return Retorna el mensaje con la nueva velocidad.
     * @throws VehiculoApagadoException Si el vehículo está apagado.
     * @throws VehiculoDetenidoException Si el vehículo ya está completamente detenido.
     * @throws PatinajeException Si se frena bruscamente desde una velocidad alta.
     */
    public String frenar(int cantidad) {
        if (velocidadActual == 0) {
            throw new VehiculoDetenidoException(); 
        }
        if (!estaEncendido()) {
            throw new VehiculoApagadoException();
        }
        if (cantidad > velocidadActual) {
            throw new PatinajeException(); 
        }

        velocidadActual = Math.max(0, velocidadActual - cantidad);
        return "Vehículo frenado a " + velocidadActual + " km/h.";
    }

    /**
     * Frena bruscamente el vehículo. Puede causar patinaje si las condiciones no son seguras.
     * @param cantidad Es la intensidad del frenado en km/h.
     * @return Retorna el mensaje con el estado del frenado.
     * @throws VehiculoApagadoException Se lanza esta excepción si el vehículo está apagado.
     * @throws VehiculoDetenidoException Se lanza esta excepción si el vehículo ya está detenido.
     * @throws PatinajeException Se lanza esta excepción si el frenado es peligroso por velocidad excesiva o frenado muy brusco.
     */
    public String frenarAutoBruscamente(int cantidad) {
        boolean patinando = true;

        if (!estaEncendido()) {
            throw new VehiculoApagadoException();
        }

        if (velocidadActual == 0) {
            throw new VehiculoDetenidoException();
        }

        if (cantidad > 30) {
            if (velocidadActual > llantas.getVelocidadMaxima()) {
                throw new PatinajeException();
            }

            if (cantidad > velocidadActual) {
                throw new PatinajeException();
            }
        }

        velocidadActual -= cantidad;
        if (velocidadActual < 0) velocidadActual = 0;

        if (velocidadActual == 0 && patinando) {
            return "El vehículo se ha detenido completamente y ha recuperado el control.";
        }

        return "Frenado exitoso. Velocidad actual: " + velocidadActual + " km/h.";
    }

    /**
     * Verifica si el vehículo ha sido configurado correctamente.
     * @return Retorna true si el vehículo tiene llantas y motor asignados, false en caso contrario.
     */
    public boolean estaConfigurado() {
        return llantas != null && motor != null;
    }
}