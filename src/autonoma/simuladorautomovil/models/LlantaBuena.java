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

    public LlantaBuena(int velocidadMaxima) {
        super(velocidadMaxima);
    }

    @Override
    public String verificarDesgaste() {
        return "Esta llanata es buena";
    }
    
}
