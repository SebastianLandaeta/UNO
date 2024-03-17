/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author Jenderlly
 */
public class InvalidColorException extends Exception{
    private int colorEsperado;
    private int colorPuesto;
    
    public InvalidColorException(String mensaje, int colorPuesto, int colorEsperado){
        this.colorEsperado=colorEsperado;
        this.colorPuesto=colorPuesto;
    }
}
