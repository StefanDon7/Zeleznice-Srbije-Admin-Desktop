/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.component;

import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Stefan
 */
public class PanelMedjustanice extends javax.swing.JPanel {

    /**
     * Creates new form PanelMedjustanice
     */
    public PanelMedjustanice() {
        initComponents();
    }

    public JButton getBtnDodajMedjustanicu() {
        return btnDodajMedjustanicu;
    }

    public JButton getBtnIzmeniRedosledMedjustanica() {
        return btnIzmeniRedosledMedjustanica;
    }

    public JButton getBtnObrisiLiniju() {
        return btnObrisiLiniju;
    }

    public JButton getBtnObrisiMedjustanicu() {
        return btnObrisiMedjustanicu;
    }

    public JComboBox getCmbLinije() {
        return cmbLinije;
    }

    public JComboBox getCmbMedjustanica() {
        return cmbMedjustanica;
    }

    public JTable getTabelaMedjustanica() {
        return tabelaMedjustanica;
    }

    public void setTabelaMedjustanica(JTable tabelaMedjustanica) {
        this.tabelaMedjustanica = tabelaMedjustanica;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JLabel getLblLinija() {
        return lblLinija;
    }

    public JLabel getLblListaMedjustanica() {
        return lblListaMedjustanica;
    }

    public JLabel getLblMedjustanica() {
        return lblMedjustanica;
    }

    public JLabel getLblNazivFrejma() {
        return lblNazivFrejma;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNazivFrejma = new javax.swing.JLabel();
        lblLinija = new javax.swing.JLabel();
        cmbLinije = new javax.swing.JComboBox();
        lblMedjustanica = new javax.swing.JLabel();
        cmbMedjustanica = new javax.swing.JComboBox();
        btnObrisiMedjustanicu = new javax.swing.JButton();
        btnDodajMedjustanicu = new javax.swing.JButton();
        lblListaMedjustanica = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMedjustanica = new javax.swing.JTable();
        btnObrisiLiniju = new javax.swing.JButton();
        btnIzmeniRedosledMedjustanica = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNazivFrejma.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblNazivFrejma.setForeground(new java.awt.Color(255, 255, 255));
        lblNazivFrejma.setText("Unos međustanica");
        add(lblNazivFrejma, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 50));

        lblLinija.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblLinija.setForeground(new java.awt.Color(255, 255, 255));
        lblLinija.setText("Linija:");
        add(lblLinija, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 40));

        cmbLinije.setBackground(new java.awt.Color(153, 153, 153));
        cmbLinije.setForeground(new java.awt.Color(0, 0, 0));
        cmbLinije.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbLinije, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 530, 40));

        lblMedjustanica.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblMedjustanica.setForeground(new java.awt.Color(255, 255, 255));
        lblMedjustanica.setText("Međustanica:");
        add(lblMedjustanica, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 140, 40));

        cmbMedjustanica.setBackground(new java.awt.Color(153, 153, 153));
        cmbMedjustanica.setForeground(new java.awt.Color(0, 0, 0));
        cmbMedjustanica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbMedjustanica, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 370, 40));

        btnObrisiMedjustanicu.setBackground(new java.awt.Color(153, 153, 153));
        btnObrisiMedjustanicu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnObrisiMedjustanicu.setForeground(new java.awt.Color(0, 0, 0));
        btnObrisiMedjustanicu.setText("Obriši");
        add(btnObrisiMedjustanicu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 200, 60));

        btnDodajMedjustanicu.setBackground(new java.awt.Color(153, 153, 153));
        btnDodajMedjustanicu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDodajMedjustanicu.setForeground(new java.awt.Color(0, 0, 0));
        btnDodajMedjustanicu.setText("Dodaj ");
        add(btnDodajMedjustanicu, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 200, 60));

        lblListaMedjustanica.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblListaMedjustanica.setForeground(new java.awt.Color(255, 255, 255));
        lblListaMedjustanica.setText("Lista međustanica:");
        add(lblListaMedjustanica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, 50));

        jScrollPane1.setBackground(new java.awt.Color(187, 187, 187));

        tabelaMedjustanica.setBackground(new java.awt.Color(153, 153, 153));
        tabelaMedjustanica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaMedjustanica.setFocusable(false);
        tabelaMedjustanica.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaMedjustanica.setRowHeight(25);
        jScrollPane1.setViewportView(tabelaMedjustanica);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 630, 350));

        btnObrisiLiniju.setBackground(new java.awt.Color(153, 153, 153));
        btnObrisiLiniju.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnObrisiLiniju.setForeground(new java.awt.Color(0, 0, 0));
        btnObrisiLiniju.setText("Obriši liniju");
        add(btnObrisiLiniju, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 280, 60));

        btnIzmeniRedosledMedjustanica.setBackground(new java.awt.Color(153, 153, 153));
        btnIzmeniRedosledMedjustanica.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnIzmeniRedosledMedjustanica.setForeground(new java.awt.Color(0, 0, 0));
        btnIzmeniRedosledMedjustanica.setText("Izmeni redosled");
        add(btnIzmeniRedosledMedjustanica, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 320, 60));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajMedjustanicu;
    private javax.swing.JButton btnIzmeniRedosledMedjustanica;
    private javax.swing.JButton btnObrisiLiniju;
    private javax.swing.JButton btnObrisiMedjustanicu;
    private javax.swing.JComboBox cmbLinije;
    private javax.swing.JComboBox cmbMedjustanica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLinija;
    private javax.swing.JLabel lblListaMedjustanica;
    private javax.swing.JLabel lblMedjustanica;
    private javax.swing.JLabel lblNazivFrejma;
    private javax.swing.JTable tabelaMedjustanica;
    // End of variables declaration//GEN-END:variables

   
    public void cmbLinije(ItemListener itemListener) {
        cmbLinije.addItemListener(itemListener);
    }

    public void btnDodajMedjustanicuMouseListener(MouseListener mouseListener) {
        btnDodajMedjustanicu.addMouseListener(mouseListener);
    }

    public void btnIzmeniRedosledMedjustanicaMouseListener(MouseListener mouseListener) {
        btnIzmeniRedosledMedjustanica.addMouseListener(mouseListener);
    }

    public void btnObrisiMedjustanicuMouseListener(MouseListener mouseListener) {
        btnObrisiMedjustanicu.addMouseListener(mouseListener);
    }

    public void btnObrisiLinijuMouseListener(MouseListener mouseListener) {
        btnObrisiLiniju.addMouseListener(mouseListener);
    }

}
