/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.awt.Font;
import java.awt.event.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
//import org.jdom2.Document;
//import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Jenderlly
 */
public class Juego {

    private int jugadorActual; //ubicación del jugador actual en el string de idJugadores
    private String[] idJugadores;//nombres de los jugadores en un array
    private Mazo mazo;// el mazo a utilizar
    private ArrayList<ArrayList<Carta>> manoJugador;//aquí se guardan las cartas que tienen cada jugador
    private ArrayList<Carta> usadas = new ArrayList<>();//aquí se guardan las cartas que se van jugando
    private int colorValido;// color valido que se pueda jugar
    private int numeroValido; // tipo de carta valida que se pueda jugar
    private int idActual; // el id de la carta actual (0-108)
    private boolean direccion;//dirección del juego que puede cambiar cuando se one una carta de reverso
    private boolean carga = false;//indica si el jugador actual ya se cargó una carta
    private Puntaje p;
    File archivo ;
    //costructor

    public Juego(String[] ids) {
        mazo = new Mazo();
        mazo.generarMazo(0, 15, 0);
        mazo.revolver();
        idJugadores = ids;
        jugadorActual = 0;
        direccion = false;
        archivo = new File("puntajes.xml");
        manoJugador = new ArrayList<ArrayList<Carta>>();
        for (int i = 0; i < ids.length; i++) {// reparte las cartas
            ArrayList<Carta> mano = new ArrayList<Carta>(mazo.sacarCarta(7));
            manoJugador.add(mano);
        }

    }

    //setters y getters
    public Carta getCartaActual() {
        Mazo m = new Mazo(); //se genera un nuevo mazo de cartas no revueltas
        m.generarMazo(0, 15, 0);
        return m.getMazo().get(idActual); //se devuelve la carta que coincida con la posición de la id de la carta catual

    }

    public void setCartaActual(Carta c) {
        idActual = c.getId();
    }

    public ImageIcon getImagenActual() {
        return new ImageIcon("id" + idActual + ".png");
    }

    public void setCarga(boolean c) {
        carga = c;
    }

    public boolean getCarga() {
        return carga;
    }

    public String getJugadorActual() {
        return this.idJugadores[this.jugadorActual];
    }

    public String[] getJugadores() {
        return idJugadores;
    }

    public ArrayList<Carta> getManoJugador(String id) {
        int posicion = Arrays.asList(idJugadores).indexOf(id);
        return manoJugador.get(posicion);
    }

    public int getTamanoMano(String id) {
        return getManoJugador(id).size();
    }

    public Carta getCartaJugada(String id, int elegida) {
        ArrayList<Carta> mano = getManoJugador(id);
        return mano.get(elegida);
    }

    public void start(Juego juego, boolean juegoNuevo) { //método start que comienza el juego
        Carta carta = mazo.sacarCarta(1).get(0);
        colorValido = carta.getColor();
        numeroValido = carta.getNumero();
        juego.idActual = carta.getId();
        System.out.println(carta);
        if (carta.getColor() == 4 || carta.getNumero() > 11) { //si comienza el juego con una carta no válida(+2,+4 o cambia color) automáticamente comienza el juego otra vez
            start(juego, true);
        }
        //condiciones si empieza el juego con cartas especiales válidas
        if (carta.getNumero() == 10) {
            JLabel mensaje = new JLabel(idJugadores[jugadorActual] + " fué bloqueado!");
            mensaje.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, mensaje);

            if (direccion == false) {
                jugadorActual = (jugadorActual + 1) % idJugadores.length;
            } else {
                jugadorActual = (jugadorActual - 1) % idJugadores.length;
                if (jugadorActual == -1) {
                    jugadorActual = idJugadores.length - 1;
                }
            }
        }
        if (carta.getNumero() == 11) {
            JLabel mensaje = new JLabel(" Ha cambiado la direccion del juego!");
            mensaje.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, mensaje);
            direccion ^= true;
            jugadorActual = idJugadores.length - 1;
        }
        usadas.add(carta); //se agrega la carta a las usadas

        if (juegoNuevo == true) {
            archivo = new File("puntajes.xml");
            FileWriter fichero = null;
            PrintWriter pw = null;
            try {
                fichero = new FileWriter(archivo);
                pw = new PrintWriter(fichero);
                pw.println("<Puntajes>");
                for (int i = 0; i < idJugadores.length; i++) {
                    pw.println("<jugador>");
                    pw.println("<nombre>" + idJugadores[i] + "</nombre>");
                    pw.println("<puntos>0</puntos>");
                    pw.println("</jugador>");
                }
                pw.println("</Puntajes>");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fichero != null) {
                        fichero.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        /*for (int i = 0; i < idJugadores.length; i++) {
        jugador = new Element(idJugadores[i]);
        jugador.setAttribute("puntos", "0");
        jugadores.addContent(jugador);
        System.out.println("jugador "+(i+1)+" "+jugador.getAttributeValue("puntos"));
        }*/
        //XMLOutputter xml = new XMLOutputter();
        //xml.setFormat(Format.getPrettyFormat());
        //xml.output(doc, new FileWriter("puntajes.xml"));
    }

    public boolean juegoTeminardo() { //indica si el jugador ganó o no
        for (String jugador : this.idJugadores) {
            if (manoVacia(jugador)) {
                return true;
            }
        }
        return false;
    }

    public int puntaje() { //calcula los puntos dependiendo de las caratas que le queden a los otros jugadores
        int puntos = 0;
        for (int i = 0; i < idJugadores.length; i++) {
            if (!manoVacia(idJugadores[i])) {
                for (int j = 0; j < manoJugador.get(i).size(); j++) {
                    if (manoJugador.get(i).get(j).getNumero() < 10) { //las cartas especiales valen más
                        puntos = puntos + manoJugador.get(i).get(j).getNumero();
                    } else if (manoJugador.get(i).get(j).getNumero() < 13) {
                        puntos = puntos + 20;
                    } else {
                        puntos = puntos + 50;
                    }
                }
            }
        }
        return puntos;
    }

    public int[] cargarPuntos(int ganador) throws SAXException, IOException, ParserConfigurationException { //carga los puntos al archivo xml y regresa un string con los puntajes
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
        archivo = new File("puntajes.xml");
        Document doc = dbBuilder.parse(archivo);
        NodeList nList = doc.getElementsByTagName("jugador");
        int puntos[] = new int[idJugadores.length];
        int p = puntaje();
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nNode;
                if (i == ganador) {
                    int o = Integer.parseInt(e.getElementsByTagName("puntos").item(0).getTextContent());
                    puntos[i] = p + o;
                    if (puntos[i] >= 500) {//si el jugador recibe 500 puntos o más gana completamente y se cierra el juego
                        JLabel mensaje = new JLabel(idJugadores[i] + " ha obtenido 500 puntos o más!");
                        mensaje.setFont(new Font("Arial", Font.BOLD, 48));
                        JOptionPane.showMessageDialog(null, mensaje);
                        System.exit(0);
                    }
                } else {
                    puntos[i] = Integer.parseInt(e.getElementsByTagName("puntos").item(0).getTextContent());
                }
            }
        }
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(archivo); //se reescribe el archibo con los nuevos puntajes
            pw = new PrintWriter(fichero);
            pw.println("<Puntajes>");
            for (int i = 0; i < idJugadores.length; i++) {
                pw.println("<jugador>");
                pw.println("<nombre>" + idJugadores[i] + "</nombre>");
                pw.println("<puntos>" + puntos[i] + "</puntos>");
                pw.println("</jugador>");

            }
            pw.println("</Puntajes>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return puntos;
    }

    public boolean manoVacia(String id) { //revisa si la mano del jugador está vacia
        return getManoJugador(id).isEmpty();
    }

    public boolean cartaValida(Carta carta) { // valida si la carta que se quiere jugar coincide ya se a en color o en tipo a la anteriormente colocada
        return (carta.getColor() == colorValido || carta.getNumero() == numeroValido);
    }

    public void verTurno(String id) throws InvalidTurnoException {//revisa si el jugador le toca su turno
        if (this.idJugadores[this.jugadorActual] != id) {
            throw new InvalidTurnoException(" No es el turno de " + id, id);
        }
    }

    public void sacarCarta(String id) throws InvalidTurnoException { //saca cartas del mazo y las retorna a la mano del jugador
        verTurno(id);
        if (mazo.getMazo().isEmpty()) {
            mazo.remplazar(usadas);
        }
        getManoJugador(id).add(mazo.sacarCarta(1).get(0));
        turno();
    }

    public void sacarCarta2(String id) throws InvalidTurnoException, InvalidColorException, InvalidNumeroException { //este metodo saca una carta y la pone en la mano del jugador pero no cambia el turno
        verTurno(id);
        if (mazo.getMazo().isEmpty()) {
            mazo.remplazar(usadas);
        }
        Carta c = mazo.sacarCarta(1).get(0);
        getManoJugador(id).add(c);
    }

    public void turno() { //cambia el turno
        if (direccion == false) {
            jugadorActual = (jugadorActual + 1) % idJugadores.length;
        } else {
            jugadorActual = (jugadorActual - 1) % idJugadores.length;
            if (jugadorActual == -1) {
                jugadorActual = idJugadores.length - 1;
            }
        }
        carga = false;
    }

    public void cambiaColor(int color) { //cambia el color valido 
        colorValido = color;
    }

    public void ponerCarta(String id, Carta carta, int nuevoColor) throws InvalidColorException, InvalidNumeroException, InvalidTurnoException, SAXException, IOException, ParserConfigurationException { //metodo para jugar una carta
        verTurno(id);
        ArrayList<Carta> manoJ = getManoJugador(id);

        //valida si se puede jugar o no la carta
        if (!cartaValida(carta)) {
            if (carta.getColor() == 4) {
                colorValido = carta.getColor();
                numeroValido = carta.getNumero();
            }
            if (carta.getColor() != colorValido) {
                System.out.println("color esperado: " + colorValido + " color puesto:" + carta.getColor());
                JLabel mensaje = new JLabel("Color inválido.");
                mensaje.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, mensaje);
                throw new InvalidColorException("Color inválido.", carta.getColor(), colorValido);
            } else if (carta.getNumero() != numeroValido) {
                JLabel mensaje2 = new JLabel("Tipo de carta inválida.");
                mensaje2.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, mensaje2);
                throw new InvalidColorException("Tipo de carta inválida.", carta.getColor(), colorValido);
            }
        }
        //luego de jugarse se remueve de la mano del jugador
        manoJ.remove(carta);
        //comprueba que el juego se terminó
        if (manoVacia(this.idJugadores[jugadorActual])) {
            JLabel mensaje3 = new JLabel(this.idJugadores[jugadorActual] + " ganó el juego!");
            mensaje3.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, mensaje3);
            p = new Puntaje(idJugadores, cargarPuntos(jugadorActual));
            p.setBounds(500, 40, 600, 600);
            p.setVisible(true);
            p.setResizable(false);
            p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        //asigna los vallores validos actuales
        colorValido = carta.getColor();
        numeroValido = carta.getNumero();
        usadas.add(carta);

        //cambia el turno
        if (direccion == false) {
            jugadorActual = (jugadorActual + 1) % idJugadores.length;
        } else if (direccion == true) {
            jugadorActual = (jugadorActual - 1) % idJugadores.length;
            if (jugadorActual == -1) {
                jugadorActual = idJugadores.length - 1;
            }
        }

        //aplica las condciones de las cartas especiales
        if (carta.getColor() == 4) {
            colorValido = nuevoColor;
        }

        if (carta.getNumero() == 10) {
            JLabel mensaje = new JLabel(idJugadores[jugadorActual] + " tiene el turno bloqueado");
            mensaje.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, mensaje);
            if (direccion == false) {
                jugadorActual = (jugadorActual + 1) % idJugadores.length;
            } else if (direccion == true) {
                jugadorActual = (jugadorActual - 1) % idJugadores.length;
                if (jugadorActual == -1) {
                    jugadorActual = idJugadores.length - 1;
                }
            }
        }
        if (carta.getNumero() == 11) {
            JLabel mensaje = new JLabel(id + " cambió la dirección del juego.");
            mensaje.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, mensaje);
            direccion ^= true;
            if (direccion == true) {
                jugadorActual = (jugadorActual - 2) % idJugadores.length;
                if (jugadorActual == -1) {
                    jugadorActual = idJugadores.length - 1;
                }
                if (jugadorActual == -2) {
                    jugadorActual = idJugadores.length - 2;
                } else if (direccion == false) {
                    jugadorActual = (jugadorActual + 2) % idJugadores.length;
                }
            }
        }
        if (carta.getNumero() == 12) {
            id = idJugadores[jugadorActual];
            getManoJugador(id).addAll(mazo.sacarCarta(1));
            getManoJugador(id).addAll(mazo.sacarCarta(1));
            JLabel mensaje = new JLabel(id + " se  cargó 2 cartas");
            mensaje.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if (carta.getNumero() == 13) {
            id = idJugadores[jugadorActual];
            getManoJugador(id).addAll(mazo.sacarCarta(1));
            getManoJugador(id).addAll(mazo.sacarCarta(1));
            getManoJugador(id).addAll(mazo.sacarCarta(1));
            getManoJugador(id).addAll(mazo.sacarCarta(1));
            JLabel mensaje = new JLabel(id + " se  cargó 4 cartas");
            mensaje.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, mensaje);
        }
        /*if (carta.getNumero() == 14) {
            //el Frame de elegir color se encarga de todo
        }*/

    }

}
