/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

/**
 *
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250405
 * @version 1.0.0
 * @see Llanta
 * 
 */
public class LlantaBonita extends Llanta {

    /**
     * Constructor de la subclase LlantaBonita
     */
    public LlantaBonita() {
        super(70); 
    }

    /**
     * Aumenta el desgaste de la llanta según la velocidad del vehículo, lo que
     * quiere decir que cuanto mayor sea la velocidad, mayor será el desgaste.
     * @param velocidad Es la velocidad actual del vehículo.
     */
    @Override
    public void aumentarDesgastePorUso(int velocidad) {
      
        if (velocidad < getVelocidadMaxima() * 0.8) {
            aumentarDesgaste(2);
        } 
       
        else if (velocidad <= getVelocidadMaxima()) {
            aumentarDesgaste(5);
        } 
       
        else {
            aumentarDesgaste(10);
        }
    }

    /**
     * Verifica el estado actual del desgaste de la llanta bonita y devuelve un mensaje descriptivo.
     * @return Retorna un mensaje con la descripción del estado de la llanta.
     */
    @Override
    public String verificarDesgaste() {
        int d = getDesgaste();
        if (d < 30) {
            return "Llanta bonita en buen estado (" + d + "% desgaste)";
        } else if (d < 70) {
            return "Llanta bonita con desgaste moderado (" + d + "% desgaste)";
        } else if (d < 100) {
            return "Llanta bonita muy desgastada (" + d + "% desgaste)";
        } else {
            return "¡Llanta bonita completamente desgastada! (" + d + "%)";
        }
    }
}