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
import autonoma.simuladorautomovil.exceptions.VehiculoDetenidoException;
/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @autor María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250405
 * @see 
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
     * Indica si el vehículo está encendido (true) o apagado (false).
     */
    private boolean estaEncendido;

    /**
     * Velocidad actual del vehículo en km/h.
     */
    private int velocidadActual;

    /**
     * Constructor de la clase Vehiculo.
     * @param llantas Son las llantas del vehículo.
     * @param motor Es el motor del vehículo.
     */
    public Vehiculo(Llanta llantas, Motor motor) {
        this.llantas = llantas;
        this.motor = motor;
        this.estaEncendido = false;
        this.velocidadActual = 0;
    }

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
     * Verifica si el vehículo está encendido.
     * @return Retorna true si está encendido y false si está apagado.
     */
   

    /**
     * Cambia el estado de encendido del vehículo.
     * @param encendidio Es true para encender y false para apagar.
     */
    public boolean isEstaEncendido() {
      return estaEncendido;
    }

    public void setEstaEncendido(boolean estaEncendido) {
    this.estaEncendido = estaEncendido;
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
     * Acelera el vehículo en una cantidad específica.
     * @param cantidad Es el aumento de velocidad en km/h.
     * @return Retorna el mensaje con la nueva velocidad (Aceleración).
     * @throws VehiculoApagadoException Se lanza esta excepción si el vehículo está apagado.
     * @throws LimiteDeVelocidadExcedidoException Se lanza esta excepción si se supera el límite de velocidad de las llantas.
     */
    public String acelerar(int cantidad) {
        if (!estaEncendido) {
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
     * @return Retorna el mensaje con la nueva velocidad o si ya estaba detenido.
     * @throws VehiculoApagadoException Se lanza esta excepción si el vehículo está apagado.
     */
    public String frenar(int cantidad) {
        if (!estaEncendido) {
            throw new VehiculoApagadoException();
        }
        if (velocidadActual == 0) {
            return "El vehiculo ya está detenido.";
        }
        velocidadActual = Math.max(0, velocidadActual - cantidad);
        return "Vehiculo frenado a " + velocidadActual + " km/h.";
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
        if (!estaEncendido) {
            throw new VehiculoApagadoException();
        }

        if (velocidadActual == 0) {
            throw new VehiculoDetenidoException();
        }

        if (cantidad > 30) {
            if (velocidadActual > llantas.getVelocidadMaxima()) {
                patinando = true;
                throw new PatinajeException();
            }

            if (cantidad > velocidadActual) {
                patinando = true;
                throw new PatinajeException();
            }
        }

        velocidadActual -= cantidad;
        if (velocidadActual < 0) velocidadActual = 0;

        if (velocidadActual == 0 && patinando) {
            patinando = false;
            return "El vehículo se ha detenido completamente y ha recuperado el control.";
        }

        return "Frenado exitoso. Velocidad actual: " + velocidadActual + " km/h.";
    }

    /**
     * Verifica el estado de desgaste de las llantas en función de la velocidad.
     * @return Retorna Mensaje indicando el nivel de desgaste.
     * @throws KilometrajeInsuficienteException Se lanza esta excepción si la velocidad es demasiado baja para evaluar el desgaste.
     */
    public String verificarDesgasteLlanta() {
        if (velocidadActual < 10) {
            throw new KilometrajeInsuficienteException();
        }

        if (velocidadActual > llantas.getVelocidadMaxima()) {
            return "Desgaste elevado: se ha superado el límite permitido de las llantas.";
        }

        return "Desgaste normal: las llantas están en buen estado.";
    }

    /**
     * Muestra en consola el estado actual del vehículo, incluyendo su velocidad, motor y llantas.
     */
    public String mostrarEstado() {
    return (estaEncendido ? "encendido" : "apagado");
}
}
