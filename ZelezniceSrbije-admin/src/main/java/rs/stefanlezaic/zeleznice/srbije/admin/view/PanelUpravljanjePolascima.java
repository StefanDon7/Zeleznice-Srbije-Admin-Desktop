/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view;

import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSviPolasci;

/**
 *
 * @author Stefan
 */
public class PanelUpravljanjePolascima extends javax.swing.JPanel {

    /**
     * Creates new form PanelUpravljanjePolascima
     */
    public PanelUpravljanjePolascima() {
        initComponents();
    }

    public PanelSviPolasci getPanelSviPolasci() {
        return panelSviPolasci;
    }

    

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSviPolasci = new rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSviPolasci();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSviPolasci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSviPolasci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSviPolasci panelSviPolasci;
    // End of variables declaration//GEN-END:variables
}