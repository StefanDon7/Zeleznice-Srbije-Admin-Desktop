/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.component;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNazivFrejma = new javax.swing.JLabel();
        lblNaziv3 = new javax.swing.JLabel();
        cmbLinije = new javax.swing.JComboBox();
        lblNaziv2 = new javax.swing.JLabel();
        cmbMedjustanica = new javax.swing.JComboBox();
        btnObrisiMedjustanicu = new javax.swing.JButton();
        btnDodajMedjustanicu = new javax.swing.JButton();
        lblNazivLinijeKodTabele = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMedjustanica = new javax.swing.JTable();
        btnObrisiLiniju = new javax.swing.JButton();
        btnIzmeniRedosledMedjustanica = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNazivFrejma.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblNazivFrejma.setForeground(new java.awt.Color(255, 255, 255));
        lblNazivFrejma.setText("Unos medjustanica");
        add(lblNazivFrejma, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 350, 40));

        lblNaziv3.setForeground(new java.awt.Color(255, 255, 255));
        lblNaziv3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_tracks_32px.png"))); // NOI18N
        lblNaziv3.setText("Linija:");
        add(lblNaziv3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 75, 90, 30));

        cmbLinije.setBackground(new java.awt.Color(153, 153, 153));
        cmbLinije.setForeground(new java.awt.Color(0, 0, 0));
        cmbLinije.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbLinije, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 75, 530, 30));

        lblNaziv2.setForeground(new java.awt.Color(255, 255, 255));
        lblNaziv2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_flag_filled_32px.png"))); // NOI18N
        lblNaziv2.setText("Medjustanica:");
        add(lblNaziv2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 130, 40));

        cmbMedjustanica.setBackground(new java.awt.Color(153, 153, 153));
        cmbMedjustanica.setForeground(new java.awt.Color(0, 0, 0));
        cmbMedjustanica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbMedjustanica, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 115, 370, 30));

        btnObrisiMedjustanicu.setBackground(new java.awt.Color(153, 153, 153));
        btnObrisiMedjustanicu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnObrisiMedjustanicu.setForeground(new java.awt.Color(0, 0, 0));
        btnObrisiMedjustanicu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_minus_64px.png"))); // NOI18N
        btnObrisiMedjustanicu.setText("Obrisi");
        add(btnObrisiMedjustanicu, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 155, 190, 40));

        btnDodajMedjustanicu.setBackground(new java.awt.Color(153, 153, 153));
        btnDodajMedjustanicu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDodajMedjustanicu.setForeground(new java.awt.Color(0, 0, 0));
        btnDodajMedjustanicu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_plus_64px.png"))); // NOI18N
        btnDodajMedjustanicu.setText("Dodaj ");
        add(btnDodajMedjustanicu, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 155, 200, 40));

        lblNazivLinijeKodTabele.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNazivLinijeKodTabele.setForeground(new java.awt.Color(255, 255, 255));
        lblNazivLinijeKodTabele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_list_32px.png"))); // NOI18N
        lblNazivLinijeKodTabele.setText("Lista stanica:");
        add(lblNazivLinijeKodTabele, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 155, 210, 40));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 205, 620, 290));

        btnObrisiLiniju.setBackground(new java.awt.Color(153, 153, 153));
        btnObrisiLiniju.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnObrisiLiniju.setForeground(new java.awt.Color(0, 0, 0));
        btnObrisiLiniju.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_delete_64px.png"))); // NOI18N
        btnObrisiLiniju.setText("OBRISI LINIJU");
        add(btnObrisiLiniju, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 502, 280, 50));

        btnIzmeniRedosledMedjustanica.setBackground(new java.awt.Color(153, 153, 153));
        btnIzmeniRedosledMedjustanica.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnIzmeniRedosledMedjustanica.setForeground(new java.awt.Color(0, 0, 0));
        btnIzmeniRedosledMedjustanica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_save_64px.png"))); // NOI18N
        btnIzmeniRedosledMedjustanica.setText("Izmeni redosled");
        add(btnIzmeniRedosledMedjustanica, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 502, 320, 50));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajMedjustanicu;
    private javax.swing.JButton btnIzmeniRedosledMedjustanica;
    private javax.swing.JButton btnObrisiLiniju;
    private javax.swing.JButton btnObrisiMedjustanicu;
    private javax.swing.JComboBox cmbLinije;
    private javax.swing.JComboBox cmbMedjustanica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNaziv2;
    private javax.swing.JLabel lblNaziv3;
    private javax.swing.JLabel lblNazivFrejma;
    private javax.swing.JLabel lblNazivLinijeKodTabele;
    private javax.swing.JTable tabelaMedjustanica;
    // End of variables declaration//GEN-END:variables

    public void btnDodajMedjustanicu(ActionListener actionListener) {
        btnDodajMedjustanicu.addActionListener(actionListener);
    }

    public void btnIzmeniRedosledMedjustanica(ActionListener actionListener) {
        btnIzmeniRedosledMedjustanica.addActionListener(actionListener);
    }

    public void btnObrisiMedjustanicu(ActionListener actionListener) {
        btnObrisiMedjustanicu.addActionListener(actionListener);
    }

    public void btnObrisiLiniju(ActionListener actionListener) {
        btnObrisiLiniju.addActionListener(actionListener);
    }
    
    public void cmbLinije(ItemListener itemListener) {
        cmbLinije.addItemListener(itemListener);
    }
   
}