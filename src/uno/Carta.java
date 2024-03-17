/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;


public class Carta {
    private int id; //cada carta tiene una única idetificación del 0 al 107 haciendo 108 cartas
    private int color=7;// los colores se representan de del 0 al 4 siendo estos rojo, amarillo, verde, azul y negro(comodín) específicamente
    private int numero;// esta variable representa el tipo de las 15 cartas diferentes de carta del 0 al 9 son las caratas de los respectivos números y las demás son: 10=bloquear turno, 11=cambiar dirección de juego, 12= +2, 13= +4, 14= cambia color
    
    
    //contructores
    public Carta(){
        id=numero=0;
        color=7; // nota, se necesitaba validar si el color habia sido o no realmente introducido, los datos tipo int tienen como default el 0 pero como este representa el rojo que es un número valido se optó por inicializar el color con un número fuera del rango válido
    }

    public Carta(int id, int color, int numero) {
        this.id = id;
        this.color = color;
        this.numero = numero;
    }
    
    //Setters y getters

    public int getId() {
        return id;
    }

    public int getColor() {
        return color;
    }

    public int getNumero() {
        return numero;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() { //el sobreescribió el método toString a conveniencia del programa ya que se utilizó para facilmente conceguir un string del id de la carta
        return "id" + id;
    }
    
    
}
