/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import autonoma.simuladorautomovil.exceptions.VehiculoApagadoException;
import autonoma.simuladorautomovil.exceptions.VehiculoEncendidoException;
import autonoma.simuladorautomovil.exceptions.AccidentePorAceleracionException;
import autonoma.simuladorautomovil.exceptions.LimiteDeVelocidadExcedidoException;
/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250405
 * @see 
 * @version 1.0.0
 */
public class Vehiculo {
    
    private Llanta llantas;
    
    private Motor motor;
    
    private boolean estaEncendido;
    
    private int velocidadActual;

    public Vehiculo(Llanta llantas, Motor motor) {
        this.llantas = llantas;
        this.motor = motor;
       this.estaEncendido = false;
        this.velocidadActual = 0;
    }

    public Llanta getLlantas() {
        return llantas;
    }

    public void setLlantas(Llanta llantas) {
        this.llantas = llantas;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public boolean isEncendido() {
        return estaEncendido;
    }

    public void setEncendidio(boolean encendidio) {
        this.estaEncendido = encendidio;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }
    
    
    public String encender(){
        if (estaEncendido) {
            throw new VehiculoEncendidoException();
        }
        estaEncendido = true;
        return "Vehiculo encendido.";
    }
    
    
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
    
     public String acelerar(int cantidad) {
        if (!estaEncendido) {
            throw new VehiculoApagadoException();
        }
        if (velocidadActual+ cantidad > llantas.getVelocidadMaxima()) {
            throw new LimiteDeVelocidadExcedidoException();
        }
        velocidadActual+= cantidad;
        return "Vehiculo acelerado a " + velocidadActual+ " km/h.";
    }
     
      public String frenar(int cantidad) {
        if (!estaEncendido) {
            throw new VehiculoApagadoException();
        }
        if (velocidadActual == 0) {
            return "El vehiculo ya está detenido.";
        }
        velocidadActual = Math.max(0, velocidadActual - cantidad);
        return "Vehiculo frenado a " + velocidadActual+ " km/h.";
    }
      
}
