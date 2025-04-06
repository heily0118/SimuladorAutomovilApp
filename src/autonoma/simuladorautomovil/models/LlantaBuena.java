/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250405
 * @see 
 * @version 1.0.0
 */
public class LlantaBuena extends Llanta {

    public LlantaBuena() {
        super(110); 
    }

    @Override
    public void aumentarDesgastePorUso(int velocidad) {
        if (velocidad < getVelocidadMaxima() * 0.7) {
            aumentarDesgaste(1);  
        } else if (velocidad <= getVelocidadMaxima()) {
            aumentarDesgaste(3);
        } else {
            aumentarDesgaste(10); 
        }
    }

    @Override
    public String verificarDesgaste() {
        int d = getDesgaste();
        if (d < 20) {
            return "Llanta buena en excelente estado (" + d + "% desgaste)";
        } else if (d < 50) {
            return "Llanta buena con algo de desgaste (" + d + "% desgaste)";
        } else if (d < 90) {
            return "Llanta buena bastante desgastada (" + d + "% desgaste)";
        } else {
            return "¡Llanta buena a punto de dañarse! (" + d + "% desgaste)";
        }
    }
}
