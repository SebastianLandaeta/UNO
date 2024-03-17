/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author Jenderlly
 */
public class InvalidTurnoException extends Exception{
    String idJugador;

    public InvalidTurnoException(String mensaje,String id) {
        super(mensaje);
        idJugador=id;
    }
    
    public String getId(){
        return idJugador;
    }
}
