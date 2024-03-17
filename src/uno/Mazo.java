/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Mazo {
    ArrayList<Carta> mazo; //se decidió utilizar un ArrayList de tipo carta para representar al mazo de cartas
    
    //constructores
    public Mazo (){
        mazo= new ArrayList<>();
    }

    public Mazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }
    
    //set y get

    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }
    
    public void generarMazo(int inicio, int fin, int c){ //método que genera las 108 cartas del mazo de uno, este toma un valor de inicio,  un valor de fin y un contador c para representar el id de la carta
        for (int i=0; i<4; i++){
            for(int j=inicio; j<fin; j++){//cartas de colores
                if (j<13){
                    mazo.add(new Carta(c++,i,j));
                }
                else{//cartas negras
                    mazo.add(new Carta(c++,4,j));
                }
            }
        }
        if(mazo.size()<100){ //esta condición es para que luego solo pueda entrar uno vez, este método utiliza la recursividad, ya que la naturaleza de las cartas de uno son que solo hay un 0 de cada color y solo hay 4 cartas +4 y 4 cambia color
           generarMazo(1,13,c); //luego de crearse las primeras 60(0-59) cartas se llama otra vez al método pero uniciando de la carta 1 hasta la 12 y se sigue contando las cartas a partir del valor de c (60-107)
        }
    }
    
    public void revolver(){ //revuelve de manera aleatoria el mazo
        Carta temp= null;
        int ran=0;
        for(int i=0; i<mazo.size(); i++){
            ran= (int)  (Math.random()*mazo.size());
            temp=mazo.get(i);
            mazo.set(i, mazo.get(ran));
            mazo.set(ran, temp);
        }
    }
    public void remplazar(ArrayList<Carta> usadas){ //una vez que el mazo quede vacio se añadiran las cartas usadas al mazo para seguir jugando con normalidad
        mazo.addAll(usadas);
        revolver();
    }
    
    public ArrayList<Carta> sacarCarta(int a) throws IllegalArgumentException{//saca y retorna cartas del mazo
        if(a<=0){
            throw new IllegalArgumentException("No se puede sacar un número de cartas menor a 1");
        }
        if (a>mazo.size()){
            throw new IllegalArgumentException("No puedes sacar "+a+" cartas porque solo quedan "+mazo.size()+ " cartas");
        }
        
        ArrayList<Carta> carga = new ArrayList<Carta>();
        for (int i=0;i<a;i++){
            carga.add(mazo.get(0));
            mazo.remove(0);
        }
        return(carga);
    }
    
    public ImageIcon sacarCartaImagen() throws IllegalArgumentException{ //retorna la imagen de la primera carta
        if (mazo.isEmpty()){
            throw new IllegalArgumentException("No hay más cartas");
        }
        return new ImageIcon("/uno/Imagenes2/"+mazo.get(0).toString()+".png");
    }
    
    
}
