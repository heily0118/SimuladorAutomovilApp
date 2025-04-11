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
 * @see LlantaBarata
 * @see LlantaBonita
 * @see LlantaBuena
 * @version 1.0.0
 */
 
public class Llanta {
    /**
     * Velocidad máxima a la que se desgasta la llanta.
     */
    private int velocidadMaxima;
    
    /**
     * Es el tipo de llantas que tiene el vehículo.
     */
    private String tipoLlanta;

    /**
     * Constructor de la clase Llanta.
     * @param velocidadMaxima Es la velocidad máxima a la que se desgasta la llanta.
     */
    public Llanta(int velocidadMaxima, String tipoLlanta) {
        this.velocidadMaxima = velocidadMaxima;
        this.tipoLlanta = tipoLlanta;
    }

    /**
     * Obtiene la velocidad máxima recomendada para la llanta.
     * @return Retorna la velocidad máxima en km/h.
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Establece una nueva velocidad máxima recomendada para la llanta.
     * @param velocidadMaxima Es la velocidadMaxima Nueva velocidad máxima en km/h.
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Obtiene el tipo de llanta.
     * @return Retorna el tipo de llanta del vehículo.
     */
    public String getTipoLlanta() {
        return tipoLlanta;
    }

    /**
     * Establece una nueva velocidad máxima recomendada para la llanta
     * @param tipoLlanta Es el tipo de llanta del vehículo.
     */
    public void setTipoLlanta(String tipoLlanta) {
        this.tipoLlanta = tipoLlanta;
    }
    
     /**
     * Asigna la velocidad máxima permitida según el tipo de llanta.
     */
    private void verificarVelocidadMaximaPorTipo() {
        switch (tipoLlanta.toLowerCase()) {
            case "Buenas":
                if (velocidadMaxima > 110){
                    System.out.println("Las llantas buenas del vehiculo están patinando");
                }
                break;
            case "Bonitas":
                if (velocidadMaxima > 70){
                    System.out.println("Las llantas bonitas del vehiculo están patinando");
                }
                break;
            case "Baratas":
                if (velocidadMaxima > 50){
                    System.out.println("Las llantas baratas del vehiculo están patinando");
                }
                break;
            default:
                velocidadMaxima = 0; 
                System.out.println("Tipo de llanta no reconocido: " + tipoLlanta);
        }
    }
}