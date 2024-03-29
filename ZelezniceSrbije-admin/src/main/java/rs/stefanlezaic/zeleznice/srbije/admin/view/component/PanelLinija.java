/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.component;

import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Stefan
 */
public class PanelLinija extends javax.swing.JPanel {

  
    public PanelLinija() {
        initComponents();
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNazivFrejma1 = new javax.swing.JLabel();
        lblPocetna = new javax.swing.JLabel();
        cmbPocetna = new javax.swing.JComboBox();
        lblKranja = new javax.swing.JLabel();
        cmbKrajnja = new javax.swing.JComboBox();
        lblTip = new javax.swing.JLabel();
        cmbTip = new javax.swing.JComboBox();
        lblKm = new javax.swing.JLabel();
        txtKilometraza = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        txtMinutaza = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnUnesiLiniju = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNazivFrejma1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblNazivFrejma1.setForeground(new java.awt.Color(255, 255, 255));
        lblNazivFrejma1.setText("Unos linije voza");
        add(lblNazivFrejma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 50));

        lblPocetna.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPocetna.setForeground(new java.awt.Color(255, 255, 255));
        lblPocetna.setText("Početna stanica:");
        add(lblPocetna, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 160, 40));

        cmbPocetna.setBackground(new java.awt.Color(102, 102, 102));
        cmbPocetna.setForeground(new java.awt.Color(0, 0, 0));
        cmbPocetna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbPocetna, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 300, 40));

        lblKranja.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblKranja.setForeground(new java.awt.Color(255, 255, 255));
        lblKranja.setText("Krajnja stanica:");
        add(lblKranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 40));

        cmbKrajnja.setBackground(new java.awt.Color(153, 153, 153));
        cmbKrajnja.setForeground(new java.awt.Color(0, 0, 0));
        cmbKrajnja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbKrajnja, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 300, 40));

        lblTip.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTip.setForeground(new java.awt.Color(255, 255, 255));
        lblTip.setText("Tip linije:");
        lblTip.setPreferredSize(new java.awt.Dimension(50, 15));
        lblTip.setRequestFocusEnabled(false);
        add(lblTip, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 140, 40));

        cmbTip.setBackground(new java.awt.Color(153, 153, 153));
        cmbTip.setForeground(new java.awt.Color(0, 0, 0));
        cmbTip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbTip, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 300, 40));

        lblKm.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblKm.setForeground(new java.awt.Color(255, 255, 255));
        lblKm.setText("Kilometraza:");
        add(lblKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 140, 40));

        txtKilometraza.setBackground(new java.awt.Color(102, 102, 102));
        txtKilometraza.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtKilometraza.setForeground(new java.awt.Color(0, 0, 0));
        add(txtKilometraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 120, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Km");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 30, 40));

        lblMin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblMin.setForeground(new java.awt.Color(255, 255, 255));
        lblMin.setText("Minutaza:");
        add(lblMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, 40));

        txtMinutaza.setBackground(new java.awt.Color(102, 102, 102));
        txtMinutaza.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtMinutaza.setForeground(new java.awt.Color(0, 0, 0));
        add(txtMinutaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 120, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Min");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 30, 40));

        btnUnesiLiniju.setBackground(new java.awt.Color(153, 153, 153));
        btnUnesiLiniju.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnUnesiLiniju.setForeground(new java.awt.Color(0, 0, 0));
        btnUnesiLiniju.setText("Unesi liniju");
        btnUnesiLiniju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnesiLinijuActionPerformed(evt);
            }
        });
        add(btnUnesiLiniju, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 300, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void btnUnesiLinijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnesiLinijuActionPerformed

    }//GEN-LAST:event_btnUnesiLinijuActionPerformed

    public JButton getBtnUnesiLiniju() {
        return btnUnesiLiniju;
    }

    public void setBtnUnesiLiniju(JButton btnUnesiLiniju) {
        this.btnUnesiLiniju = btnUnesiLiniju;
    }

    public JComboBox getCmbKrajnja() {
        return cmbKrajnja;
    }

    public void setCmbKrajnja(JComboBox cmbKrajnja) {
        this.cmbKrajnja = cmbKrajnja;
    }

    public JComboBox getCmbPocetna() {
        return cmbPocetna;
    }

    public void setCmbPocetna(JComboBox cmbPocetna) {
        this.cmbPocetna = cmbPocetna;
    }

    public JComboBox getCmbTip() {
        return cmbTip;
    }

    public void setCmbTip(JComboBox cmbTip) {
        this.cmbTip = cmbTip;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getLblKm() {
        return lblKm;
    }

    public void setLblKm(JLabel lblKm) {
        this.lblKm = lblKm;
    }

    public JLabel getLblKranja() {
        return lblKranja;
    }

    public void setLblKranja(JLabel lblKranja) {
        this.lblKranja = lblKranja;
    }

    public JLabel getLblMin() {
        return lblMin;
    }

    public void setLblMin(JLabel lblMin) {
        this.lblMin = lblMin;
    }

    public JLabel getLblNazivFrejma1() {
        return lblNazivFrejma1;
    }

    public void setLblNazivFrejma1(JLabel lblNazivFrejma1) {
        this.lblNazivFrejma1 = lblNazivFrejma1;
    }

    public JLabel getLblTip() {
        return lblTip;
    }

    public void setLblTip(JLabel lblTip) {
        this.lblTip = lblTip;
    }

    public JLabel getLblPocetna() {
        return lblPocetna;
    }

    public void setLblpocetna(JLabel lblpocetna) {
        this.lblPocetna = lblpocetna;
    }

    public JTextField getTxtKilometraza() {
        return txtKilometraza;
    }

    public void setTxtKilometraza(JTextField txtKilometraza) {
        this.txtKilometraza = txtKilometraza;
    }

    public JTextField getTxtMinutaza() {
        return txtMinutaza;
    }

    public void setTxtMinutaza(JTextField txtMinutaza) {
        this.txtMinutaza = txtMinutaza;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUnesiLiniju;
    private javax.swing.JComboBox cmbKrajnja;
    private javax.swing.JComboBox cmbPocetna;
    private javax.swing.JComboBox cmbTip;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblKm;
    private javax.swing.JLabel lblKranja;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblNazivFrejma1;
    private javax.swing.JLabel lblPocetna;
    private javax.swing.JLabel lblTip;
    private javax.swing.JTextField txtKilometraza;
    private javax.swing.JTextField txtMinutaza;
    // End of variables declaration//GEN-END:variables

    public void btnUnesiLinijuMouseListener(MouseListener mouseListener) {
        btnUnesiLiniju.addMouseListener(mouseListener);
    }

    
}
