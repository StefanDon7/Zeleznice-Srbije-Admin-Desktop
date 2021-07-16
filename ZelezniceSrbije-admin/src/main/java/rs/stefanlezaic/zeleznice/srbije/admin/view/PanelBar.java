/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view;

import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSat;
import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelTema;

/**
 *
 * @author Stefan
 */
public class PanelBar extends javax.swing.JPanel {

    public PanelBar() {
        initComponents();
    }

    public PanelSat getPanelSat() {
        return panelSat;
    }

    public PanelTema getPanelTema() {
        return panelTema;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSat = new rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSat();
        panelTema = new rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelTema();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(panelSat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        add(panelTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSat panelSat;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelTema panelTema;
    // End of variables declaration//GEN-END:variables
}
