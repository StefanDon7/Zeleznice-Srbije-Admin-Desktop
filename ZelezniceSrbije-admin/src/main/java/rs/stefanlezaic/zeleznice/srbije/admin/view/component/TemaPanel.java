/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.component;

import rs.stefanlezaic.zeleznice.srbije.lib.theme.Tema;

/**
 *
 * @author Stefan
 */
public class TemaPanel extends javax.swing.JPanel {

     private final Tema tema =new Tema();
    
    public TemaPanel() {
        initComponents();
        ukljuciDarkMode();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWhiteMode = new javax.swing.JLabel();
        lblDarkMode = new javax.swing.JLabel();

        lblWhiteMode.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblWhiteMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/whiteMode.png"))); // NOI18N
        lblWhiteMode.setText("Svetla tema");
        lblWhiteMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWhiteModeMouseClicked(evt);
            }
        });

        lblDarkMode.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDarkMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/darkMode.png"))); // NOI18N
        lblDarkMode.setText("Tamna tema");
        lblDarkMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDarkModeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDarkMode, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWhiteMode, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDarkMode, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWhiteMode, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblWhiteModeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWhiteModeMouseClicked
        iskljuciDarkMode();
    }//GEN-LAST:event_lblWhiteModeMouseClicked

    private void lblDarkModeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDarkModeMouseClicked
        ukljuciDarkMode();
    }//GEN-LAST:event_lblDarkModeMouseClicked
     private void ukljuciDarkMode() {
        lblWhiteMode.setVisible(true);
        lblDarkMode.setVisible(false);
        tema.blackTheme();
    }

    private void iskljuciDarkMode() {
        lblWhiteMode.setVisible(false);
        lblDarkMode.setVisible(true);
        tema.whiteTheme();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDarkMode;
    private javax.swing.JLabel lblWhiteMode;
    // End of variables declaration//GEN-END:variables
}