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
      
    public String frenarAutoBruscamente(int cantidad) {
        boolean patinando = true;
        if (!estaEncendido) {
            throw new VehiculoApagadoException();
        }

        if (velocidadActual == 0) {
            throw new VehiculoDetenidoException();
        }

        // Verificamos si el frenado es brusco
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
    
    public String verificarDesgasteLlanta() {
        if (velocidadActual < 10) {
            throw new KilometrajeInsuficienteException();
        }

        if (velocidadActual > llantas.getVelocidadMaxima()) {
            return "Desgaste elevado: se ha superado el límite permitido de las llantas.";
        }

        return "Desgaste normal: las llantas están en buen estado.";
    }
    
    public void mostrarEstado() {
        System.out.println("======== ESTADO DEL VEHÍCULO ========");
        System.out.println("Encendido: " + (estaEncendido ? "Sí" : "No"));
        System.out.println("Velocidad actual: " + velocidadActual + " km/h");
        System.out.println("Motor: " + motor.getCilindraje() + " - Máx: " + motor.getVelocidadMaxima() + " km/h");
        System.out.println("Llantas: " + llantas.getClass().getSimpleName() + " - Límite: " + llantas.getVelocidadMaxima() + " km/h");
        System.out.println("======================================");
    }
}
