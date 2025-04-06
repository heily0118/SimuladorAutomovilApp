/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

/**
 *
 *  
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250405
 * @see 
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
     * 
     * @param cilindraje
     * @param velocidadMaxima 
     */
    public Motor(String cilindraje, int velocidadMaxima) {
        this.cilindraje = cilindraje;
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * 
     * @return 
     */
    public String getCilindraje() {
        return cilindraje;
    }

    /**
     * 
     * @param cilindraje 
     */
    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    /**
     * 
     * @return 
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * 
     * @param velocidadMaxima 
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    
    
    
}
