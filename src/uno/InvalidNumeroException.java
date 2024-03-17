/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author Jenderlly
 */
public class InvalidNumeroException extends Exception {
    private int numeroEsperado;
    private int numeroPuesto;
    
    public InvalidNumeroException(String mensaje, int numeroPuesto, int numeroEsperado){
        this.numeroEsperado=numeroEsperado;
        this.numeroPuesto=numeroPuesto;
    }
}
