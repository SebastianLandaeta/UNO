/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uno;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenderlly
 */



public class ElegirColorFrame extends javax.swing.JFrame {

    private int color;
    Boolean permite = false;
    VentanaEmergente ventana;
    
    public ElegirColorFrame() {
        initComponents();
    }
    public ElegirColorFrame(VentanaEmergente ventana){
        initComponents();
        this.ventana=ventana;
    }
    
    
    public int elegirColor(Carta carta){
       if(carta.getColor()==4){
           ventana.juego.setCartaActual(carta);
           this.setVisible(true);
           this.setBounds(500,40,400,500);
       }
       return carta.getColor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonRojo = new javax.swing.JButton();
        botonAmarillo = new javax.swing.JButton();
        botonAzul = new javax.swing.JButton();
        botonVerde = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        jLabel1.setText("Elige un color!");

        botonRojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/Imagenes/rojo.png"))); // NOI18N
        botonRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRojoActionPerformed(evt);
            }
        });

        botonAmarillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/Imagenes/amarillo.png"))); // NOI18N
        botonAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAmarilloActionPerformed(evt);
            }
        });

        botonAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/Imagenes/azul.png"))); // NOI18N
        botonAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAzulActionPerformed(evt);
            }
        });

        botonVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/Imagenes/verde.png"))); // NOI18N
        botonVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerdeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRojoActionPerformed
        color=0;
        JLabel mensaje= new JLabel("Se eligió el color rojo!");
        mensaje.setFont(new Font ("Arial", Font.BOLD,48));
        JOptionPane.showMessageDialog(null, mensaje);
        permite=true;
        this.dispose();
        ventana.nuevoColor=0;
        ventana.gJuego.setId(ventana.juego.getJugadorActual());
        ventana.gJuego.setIconoBoton();
        ventana.cartaActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/Imagenes2/"+ventana.juego.getImagenActual())));
        ventana.juego.cambiaColor(0);
        ventana.dispose();
    }//GEN-LAST:event_botonRojoActionPerformed

    private void botonAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAzulActionPerformed
        color=3;
        JLabel mensaje= new JLabel("Se eligió el color azul!");
        mensaje.setFont(new Font ("Arial", Font.BOLD,48));
        JOptionPane.showMessageDialog(null, mensaje);
        permite=true;
        this.dispose();
        ventana.nuevoColor=3;
        ventana.gJuego.setId(ventana.juego.getJugadorActual());
        ventana.gJuego.setIconoBoton();
        ventana.cartaActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/Imagenes2/"+ventana.juego.getImagenActual())));
        ventana.juego.cambiaColor(3);
        ventana.dispose();
    }//GEN-LAST:event_botonAzulActionPerformed

    private void botonAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAmarilloActionPerformed
        color=1;
        JLabel mensaje= new JLabel("Se eligió el color Amarillo!");
        mensaje.setFont(new Font ("Arial", Font.BOLD,48));
        JOptionPane.showMessageDialog(null, mensaje);
        permite=true;
        this.dispose();
        ventana.nuevoColor=1;
        ventana.gJuego.setId(ventana.juego.getJugadorActual());
        ventana.gJuego.setIconoBoton();
        ventana.cartaActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/Imagenes2/"+ventana.juego.getImagenActual())));
        ventana.juego.cambiaColor(1);
        ventana.dispose();
    }//GEN-LAST:event_botonAmarilloActionPerformed

    private void botonVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerdeActionPerformed
        color=2;
        JLabel mensaje= new JLabel("Se eligió el color verde!");
        mensaje.setFont(new Font ("Arial", Font.BOLD,48));
        JOptionPane.showMessageDialog(null, mensaje);
        permite=true;
        this.dispose();
        ventana.nuevoColor=2;
        ventana.gJuego.setId(ventana.juego.getJugadorActual());
        ventana.gJuego.setIconoBoton();
        ventana.cartaActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/Imagenes2/"+ventana.juego.getImagenActual())));
        ventana.juego.cambiaColor(2);
        ventana.dispose();
    }//GEN-LAST:event_botonVerdeActionPerformed

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
            java.util.logging.Logger.getLogger(ElegirColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElegirColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElegirColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElegirColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElegirColorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAmarillo;
    private javax.swing.JButton botonAzul;
    private javax.swing.JButton botonRojo;
    private javax.swing.JButton botonVerde;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}