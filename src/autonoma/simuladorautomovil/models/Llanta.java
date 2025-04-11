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
     * Velocidad máxima a la que la llanta puede operar sin patinar.
     */
    private int velocidadMaxima;
    
    /**
     * Tipo de llanta (ej. Buenas, Bonitas, Baratas).
     */
    private String tipoLlanta;

    /**
     * Constructor de la clase Llanta.
     * 
     * @param velocidadMaxima La velocidad máxima permitida para esta llanta.
     * @param tipoLlanta El tipo de la llanta.
     */
    public Llanta(int velocidadMaxima, String tipoLlanta) {
        this.velocidadMaxima = velocidadMaxima;
        this.tipoLlanta = tipoLlanta;
    }

    /**
     * Obtiene la velocidad máxima recomendada para la llanta.
     * @return La velocidad máxima en km/h.
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Establece una nueva velocidad máxima recomendada para la llanta.
     * @param velocidadMaxima Nueva velocidad máxima en km/h.
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Obtiene el tipo de llanta del vehículo.
     * @return El tipo de llanta.
     */
    public String getTipoLlanta() {
        return tipoLlanta;
    }

    /**
     * Establece un nuevo tipo de llanta.
     * @param tipoLlanta El tipo de llanta del vehículo.
     */
    public void setTipoLlanta(String tipoLlanta) {
        this.tipoLlanta = tipoLlanta;
    }
    
    /**
     * Verifica si la velocidad del vehículo excede el límite de la llanta.
     * Si la velocidad es superior a la máxima permitida, el vehículo patina.
     * 
     * @param velocidadActual La velocidad actual del vehículo.
     */
    public void verificarVelocidadMaxima(int velocidadActual) {
        if (velocidadActual > velocidadMaxima) {
            System.out.println("Las llantas de tipo " + tipoLlanta + " del vehículo están patinando.");
        }
    }
    
    /**
     * Verifica si el tipo de llanta es válido y establece la velocidad máxima correcta.
     */
    public void verificarTipoLlanta() {
        switch (tipoLlanta.toLowerCase()) {
            case "buenas":
                if (velocidadMaxima > 110) {
                    System.out.println("Las llantas buenas del vehículo están patinando.");
                }
                break;
            case "bonitas":
                if (velocidadMaxima > 70) {
                    System.out.println("Las llantas bonitas del vehículo están patinando.");
                }
                break;
            case "baratas":
                if (velocidadMaxima > 50) {
                    System.out.println("Las llantas baratas del vehículo están patinando.");
                }
                break;
           default:
                throw new IllegalArgumentException("Tipo de llanta no reconocido: " + tipoLlanta);
        }
    }
}