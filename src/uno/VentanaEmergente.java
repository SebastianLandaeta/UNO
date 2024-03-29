/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uno;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Jenderlly
 */
public class VentanaEmergente extends javax.swing.JFrame {

    String imagenCarta = "";
    Juego juego;
    ArrayList<Carta> manoJugador;
    int elegida;
    ArrayList<JButton> botonesCartas;
    GUIJuego gJuego;
    JButton cartaActual;
    int nuevoColor;

    public VentanaEmergente() {

    }

    public VentanaEmergente(String idCarta, Juego juego, int i, ArrayList<JButton> botonesCartas, GUIJuego gJuego, JButton botonCartaActual) {
        initComponents();
        imagenCarta = idCarta;
        this.juego = juego;
        manoJugador = juego.getManoJugador(juego.getJugadorActual());
        elegida = i;
        this.botonesCartas = botonesCartas;
        cartaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/Imagenes2/" + imagenCarta + ".png")));
        this.gJuego = gJuego;
        cartaActual = botonCartaActual;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        botonUsar = new javax.swing.JButton();
        cartaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonCancelar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonUsar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        botonUsar.setText("UsarCarta");
        botonUsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUsarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(botonUsar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cartaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(cartaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonUsar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUsarActionPerformed
        ElegirColorFrame elegirColor = new ElegirColorFrame(this); //solo se hará visible cuando una carta negra se juega
        Carta c = manoJugador.get(elegida);
        nuevoColor = elegirColor.elegirColor(manoJugador.get(elegida));
        if (nuevoColor != 7) {//aquí se valida si el color tiene un valor válido
            try {
                juego.ponerCarta(juego.getJugadorActual(), manoJugador.get(elegida), nuevoColor);
            } catch (InvalidColorException | InvalidNumeroException | InvalidTurnoException e) {
                Logger.getLogger(VentanaEmergente.class.getName()).log(Level.SEVERE, null, e);
            } catch (SAXException ex) {
                Logger.getLogger(VentanaEmergente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VentanaEmergente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(VentanaEmergente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.revalidate();
            juego.setCarga(false);// luego de 
            if (nuevoColor != 4) { // solo entra si no es una carta negra
                gJuego.setId(juego.getJugadorActual());
                if (juego.cartaValida(c)) {
                    gJuego.setIconoBoton();
                    cartaActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/Imagenes2/" + imagenCarta + ".png")));
                }
                if (juego.juegoTeminardo()) { //se cierra si el jugador ganó
                    gJuego.dispose();
                } else {

                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_botonUsarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEmergente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonUsar;
    private javax.swing.JLabel cartaLabel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
