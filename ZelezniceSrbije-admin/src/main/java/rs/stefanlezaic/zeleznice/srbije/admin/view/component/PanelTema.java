/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.component;

import java.awt.Container;
import javax.swing.JLabel;
import rs.stefanlezaic.zeleznice.srbije.lib.theme.Tema;

/**
 *
 * @author Stefan
 */
public class PanelTema extends javax.swing.JPanel {

    Container container;
    Tema tema;

    public PanelTema() {
        initComponents();
    }

    public void dodeliContainer(Container container) {
        this.container = container;
        tema = new Tema(container);
    }

    public void ukljuciTamnuTemu() {
        lblWhiteMode.setVisible(true);
        lblDarkMode.setVisible(false);
        tema.blackTheme();
    }

    public void ukljuciSvetluTemu() {
        lblWhiteMode.setVisible(false);
        lblDarkMode.setVisible(true);
        tema.whiteTheme();
    }

    public JLabel getLblDarkMode() {
        return lblDarkMode;
    }

    public JLabel getLblWhiteMode() {
        return lblWhiteMode;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDarkMode = new javax.swing.JLabel();
        lblWhiteMode = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDarkMode.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDarkMode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDarkMode.setText("Tamna tema");
        lblDarkMode.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray, 2));
        lblDarkMode.setDisabledIcon(null);
        lblDarkMode.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add(lblDarkMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 60));

        lblWhiteMode.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblWhiteMode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWhiteMode.setText("Svetla tema");
        lblWhiteMode.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray, 2));
        lblWhiteMode.setDisabledIcon(null);
        lblWhiteMode.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblWhiteMode.setMaximumSize(new java.awt.Dimension(176, 64));
        lblWhiteMode.setMinimumSize(new java.awt.Dimension(176, 64));
        lblWhiteMode.setName(""); // NOI18N
        lblWhiteMode.setPreferredSize(new java.awt.Dimension(176, 64));
        add(lblWhiteMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 60));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDarkMode;
    private javax.swing.JLabel lblWhiteMode;
    // End of variables declaration//GEN-END:variables
}
