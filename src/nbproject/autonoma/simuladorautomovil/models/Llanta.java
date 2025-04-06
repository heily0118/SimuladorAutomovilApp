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
    private int velocidadMaxima;
    private int desgaste; // 0 a 100

    public Llanta(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
        this.desgaste = 0;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getDesgaste() {
        return desgaste;
    }

    public void setDesgaste(int desgaste) {
        this.desgaste = desgaste;
    }

   
    public void aumentarDesgaste(int valor) {
        this.desgaste += valor;
        if (this.desgaste > 100) {
            this.desgaste = 100; 
        }
    }

    
    public abstract void aumentarDesgastePorUso(int velocidad);

    
    public abstract String verificarDesgaste();
}