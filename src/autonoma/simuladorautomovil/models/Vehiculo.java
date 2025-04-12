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
import autonoma.simuladorautomovil.exceptions.VehiculoNoConfiguradoException;
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
     * Representa las llantas instaladas en el vehículo.
     */
    private Llanta llantas;

    /**
     * Motor que impulsa el vehículo.
     */
    private Motor motor;

    /**
     * Velocidad actual del vehículo en km/h.
     */
    private int velocidadActual;

    /**
     * Crea un nuevo vehículo sin configuración inicial.
     */
    public Vehiculo() {}

    /**
     * Obtiene el objeto Llanta asociado al vehículo.
     * 
     * @return El objeto Llanta configurado.
     */
    public Llanta getLlantas() {
        return llantas;
    }

    /**
     * Establece el objeto Llanta para el vehículo.
     * 
     * @param llantas El objeto Llanta a asignar.
     */
    public void setLlantas(Llanta llantas) {
        this.llantas = llantas;
    }

    /**
     * Obtiene el objeto Motor del vehículo.
     * 
     * @return El motor actual del vehículo.
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * Establece el motor del vehículo.
     * 
     * @param motor El objeto Motor a asignar.
     */
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    /**
     * Obtiene la velocidad actual del vehículo.
     * 
     * @return Velocidad en km/h.
     */
    public int getVelocidadActual() {
        return velocidadActual;
    }

    /**
     * Establece la velocidad actual del vehículo. También actualiza la velocidad en el motor si está configurado.
     * 
     * @param velocidadActual Velocidad a establecer en km/h.
     */
    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
        if (motor != null) {
            motor.setVelocidadActual(velocidadActual);
        }
    }

    /**
     * Enciende el vehículo si está configurado.
     * 
     * @return Mensaje indicando si el encendido fue exitoso.
     * @throws VehiculoNoConfiguradoException Si el vehículo no tiene motor o llantas.
     */
    public String encender() throws VehiculoNoConfiguradoException {
        if (!estaConfigurado()) {
            throw new VehiculoNoConfiguradoException(); 
        }
        return motor.encender();
    }

    /**
     * Apaga el vehículo si es seguro hacerlo.
     * 
     * @return Mensaje de confirmación.
     * @throws VehiculoApagadoException Si ya está apagado.
     * @throws AccidentePorAceleracionException Si se intenta apagar con velocidad > 60 km/h.
     * @throws VehiculoNoConfiguradoException Si el vehículo no tiene motor o llantas.
     */
    public String apagar() throws VehiculoNoConfiguradoException {
        if (motor == null || llantas == null) {
             throw new VehiculoNoConfiguradoException();
        }

        return motor.apagar();
    }

    /**
     * Verifica si el motor del vehículo está encendido.
     * 
     * @return true si el motor está encendido, false si está apagado o no asignado.
     */
    public boolean estaEncendido() {
        return motor != null && motor.estaEncendido();
    }

    /**
     * Acelera el vehículo si está encendido y no supera el límite de las llantas.
     * 
     * @param cantidad Incremento de velocidad en km/h.
     * @return Mensaje indicando la nueva velocidad.
     * @throws VehiculoApagadoException Si el motor está apagado.
     * @throws LimiteDeVelocidadExcedidoException Si se supera la velocidad de las llantas.
     */
    public String acelerar(int cantidad) throws VehiculoApagadoException, LimiteDeVelocidadExcedidoException {
        if (!estaEncendido()) {
            throw new VehiculoApagadoException();
        }
        if (velocidadActual + cantidad > llantas.getVelocidadMaxima()) {
            throw new LimiteDeVelocidadExcedidoException();
        }
        velocidadActual += cantidad;
        motor.setVelocidadActual(velocidadActual);


        llantas.verificarVelocidadMaxima(velocidadActual);

        return "Vehículo acelerado a " + velocidadActual + " km/h.";
    }

    /**
     * Frena el vehículo si está encendido y no está detenido completamente.
     * 
     * @param cantidad Reducción de velocidad en km/h.
     * @return Mensaje indicando la nueva velocidad.
     * @throws VehiculoApagadoException Si el motor está apagado.
     * @throws VehiculoDetenidoException Si el vehículo ya está detenido.
     * @throws PatinajeException Si el frenado es muy brusco y puede causar patinaje.
     */
    public String frenar(int cantidad) throws VehiculoDetenidoException, VehiculoApagadoException, PatinajeException{
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
        motor.setVelocidadActual(velocidadActual);
        return "Vehículo frenado a " + velocidadActual + " km/h.";
    }

    /**
     * Realiza un frenado brusco. Puede lanzar excepción por patinaje si es riesgoso.
     * 
     * @param cantidad Cantidad de frenado en km/h.
     * @return Mensaje sobre el resultado del frenado.
     * @throws VehiculoNoConfiguradoException Si el vehículo no tiene motor o llantas.
     * @throws VehiculoApagadoException Si el vehículo está apagado.
     * @throws VehiculoDetenidoException Si el vehículo ya estaba detenido.
     * @throws PatinajeException Si las condiciones del frenado son peligrosas.
     */
    public String frenarAutoBruscamente(int cantidad) throws VehiculoNoConfiguradoException, VehiculoApagadoException, VehiculoDetenidoException {
        if (!estaConfigurado()) {
            throw new VehiculoNoConfiguradoException(); 
        }
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
        motor.setVelocidadActual(velocidadActual);

        llantas.verificarVelocidadMaxima(velocidadActual);

        if (velocidadActual == 0) {
            return "El vehículo se ha detenido completamente y ha recuperado el control.";
        }

        return "Frenado exitoso. Velocidad actual: " + velocidadActual + " km/h.";
    }


    /**
     * Verifica si el vehículo tiene motor y llantas configuradas.
     * 
     * @return true si está listo para usarse, false en caso contrario.
     */
    public boolean estaConfigurado() {
        return llantas != null && motor != null;
    }
}