/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

/**
 *
 *@author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250405
 * @see autonoma.simuladorautomovil.models.Vehiculo
 * @version 1.0.0
 */
public class Taller {
    
  
   private Vehiculo vehiculo;

    public Taller(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
    
    public String configurarLlantas(String tipo){
        Llanta llanta;

        switch (tipo.toLowerCase()) {
            case "buena":
                llanta = new Llanta(110, "Buena");
                break;
            case "bonita":
                llanta = new Llanta(70, "Bonita");
                break;
            case "barata":
                llanta = new Llanta(50, "Barata");
                break;
            default:
                return "Tipo de llanta inválido: " + tipo;
        }

        this.vehiculo.setLlantas(llanta);
        return "Llanta configurada: " + llanta.getTipoLlanta();
    }
    
    public String configurarMotor(String cilindraje){
        Motor motor;

        switch (cilindraje) {
            case "1000":
                motor = new Motor("1000", 100);
                break;
            case "2000":
                motor = new Motor("2000", 160);
                break;
            case "3000":
                motor = new Motor("3000", 220);
                break;
            default:
                return "Cilindraje de motor inválido: " + cilindraje;
        }

        this.vehiculo.setMotor(motor);
        return "Motor configurado: " + motor.getCilindraje();
    
    }
    
    
}
