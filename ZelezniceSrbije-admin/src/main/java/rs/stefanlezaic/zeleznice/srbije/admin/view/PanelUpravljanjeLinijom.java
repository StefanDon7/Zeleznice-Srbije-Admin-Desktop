/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view;

import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelLinija;
import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelMedjustanice;
import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelStanica;

/**
 *
 * @author Stefan
 */
public class PanelUpravljanjeLinijom extends javax.swing.JPanel {

    /**
     * Creates new form PanelLinija
     */
    public PanelUpravljanjeLinijom() {
        initComponents();
    }

    public PanelLinija getPanelLinija() {
        return panelLinija;
    }
    
    public PanelMedjustanice getPanelMedjustanice() {
        return panelMedjustanice;
    }

    

    public PanelStanica getPanelStanica() {
        return panelStanica;
    }

   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLinija = new rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelLinija();
        panelStanica = new rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelStanica();
        panelMedjustanice = new rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelMedjustanice();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(1250, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(panelLinija, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 490, 390));
        add(panelStanica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 490, 240));
        add(panelMedjustanice, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray, 3));
        jSeparator1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 3, 670));

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray, 3));
        jSeparator2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 273, 580, 3));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelLinija panelLinija;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelMedjustanice panelMedjustanice;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelStanica panelStanica;
    // End of variables declaration//GEN-END:variables
}
