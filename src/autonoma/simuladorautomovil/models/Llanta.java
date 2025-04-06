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
 
public abstract class Llanta {
    /**
     * Velocidad máxima a la que se desgasta la llanta.
     */
    private int velocidadMaxima;
    /**
     * Nivel de desgaste de la llanta.
     */
    private int desgaste; // 0 a 100

    /**
     * Constructor de la clase Llanta.
     * @param velocidadMaxima Es la velocidad máxima a la que se desgasta la llanta.
     */
    public Llanta(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
        this.desgaste = 0;
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
     * @param velocidadMaxima Retorna la velocidadMaxima Nueva velocidad máxima en km/h.
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Obtiene el nivel actual de desgaste de la llanta.
     * @return Retorna el desgaste actual.
     */
    public int getDesgaste() {
        return desgaste;
    }

    /**
     * Establece un nuevo nivel de desgaste para la llanta.
     * @param desgaste Retorna el valor de desgaste a establecer.
     */
    public void setDesgaste(int desgaste) {
        this.desgaste = desgaste;
    }

    /**
     * Aumenta el desgaste de la llanta en un valor específico, lo que 
     * quiere decir que si el valor total supera 100, se ajusta a 100.
     * @param valor Es el valor Cantidad de desgaste a añadir.
     */
    public void aumentarDesgaste(int valor) {
        this.desgaste += valor;
        if (this.desgaste > 100) {
            this.desgaste = 100; 
        }
    }


    /**
     * Método abstracto que define cómo se incrementa el desgaste de la llanta según la velocidad de uso.
     * @param velocidad Es la Velocidad actual del vehículo.
     */
    public abstract void aumentarDesgastePorUso(int velocidad);

    /**
     * Método abstracto para verificar el estado del desgaste de la llanta.
     * @return Retorna el mensaje con el estado del desgaste de la llanta.
     */
    public abstract String verificarDesgaste();
}