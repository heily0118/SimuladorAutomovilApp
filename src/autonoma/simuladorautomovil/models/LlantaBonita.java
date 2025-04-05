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
 * 
 */
public class LlantaBonita extends Llanta{

    public LlantaBonita(int velocidadMaxima) {
        super(velocidadMaxima);
    }

    @Override
    public String verificarDesgaste() {
        return "Esta llanta es bonita";
    }
    
}
