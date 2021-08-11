/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import rs.stefanlezaic.zeleznice.srbije.lib.view.PanelDatum;

/**
 *
 * @author Stefan
 */
public class PanelPolazak extends javax.swing.JPanel {

    /**
     * Creates new form PanelPolazk
     */
    public PanelPolazak() {
        initComponents();
    }

    public JButton getBtnDodajPolazak() {
        return btnDodajPolazak;
    }

    public void setBtnDodajPolazak(JButton btnDodajPolazak) {
        this.btnDodajPolazak = btnDodajPolazak;
    }

    public JButton getBtnObrisiListu() {
        return btnObrisiListu;
    }

    public void setBtnObrisiListu(JButton btnObrisiListu) {
        this.btnObrisiListu = btnObrisiListu;
    }

    public JButton getBtnObrisiPolazak() {
        return btnObrisiPolazak;
    }

    public void setBtnObrisiPolazak(JButton btnObrisiPolazak) {
        this.btnObrisiPolazak = btnObrisiPolazak;
    }

    public JButton getBtnZapamtiPolaske() {
        return btnZapamtiPolaske;
    }

    public void setBtnZapamtiPolaske(JButton btnZapamtiPolaske) {
        this.btnZapamtiPolaske = btnZapamtiPolaske;
    }

    public JCheckBox getCboxPovratna() {
        return cboxPovratna;
    }

    public void setCboxPovratna(JCheckBox cboxPovratna) {
        this.cboxPovratna = cboxPovratna;
    }

    public JComboBox<String> getCmbBrojDanaZaPolazak() {
        return cmbBrojDanaZaPolazak;
    }

    public void setCmbBrojDanaZaPolazak(JComboBox<String> cmbBrojDanaZaPolazak) {
        this.cmbBrojDanaZaPolazak = cmbBrojDanaZaPolazak;
    }

    public JComboBox getCmbLinijaPolazak() {
        return cmbLinijaPolazak;
    }

    public void setCmbLinijaPolazak(JComboBox cmbLinijaPolazak) {
        this.cmbLinijaPolazak = cmbLinijaPolazak;
    }

    public JComboBox getCmbVoz() {
        return cmbVoz;
    }

    public void setCmbVoz(JComboBox cmbVoz) {
        this.cmbVoz = cmbVoz;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public void setjSeparator2(JSeparator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }

    public JSeparator getjSeparator5() {
        return jSeparator5;
    }

    public void setjSeparator5(JSeparator jSeparator5) {
        this.jSeparator5 = jSeparator5;
    }

    public JLabel getLblDatum() {
        return lblDatum;
    }

    public void setLblDatum(JLabel lblDatum) {
        this.lblDatum = lblDatum;
    }

    public JLabel getLblDatum2() {
        return lblDatum2;
    }

    public void setLblDatum2(JLabel lblDatum2) {
        this.lblDatum2 = lblDatum2;
    }

    public JLabel getLblLinija() {
        return lblLinija;
    }

    public void setLblLinija(JLabel lblLinija) {
        this.lblLinija = lblLinija;
    }

    public JLabel getLblLista() {
        return lblLista;
    }

    public void setLblLista(JLabel lblLista) {
        this.lblLista = lblLista;
    }

    public JLabel getLblNaslov() {
        return lblNaslov;
    }

    public void setLblNaslov(JLabel lblNaslov) {
        this.lblNaslov = lblNaslov;
    }

    public JLabel getLblNazivPolaska() {
        return lblNazivPolaska;
    }

    public void setLblNazivPolaska(JLabel lblNazivPolaska) {
        this.lblNazivPolaska = lblNazivPolaska;
    }

    public JLabel getLblPoljeDatum2() {
        return lblPoljeDatum2;
    }

    public void setLblPoljeDatum2(JLabel lblPoljeDatum2) {
        this.lblPoljeDatum2 = lblPoljeDatum2;
    }

    public JLabel getLblPoljeNazivPolaska() {
        return lblPoljeNazivPolaska;
    }

    public void setLblPoljeNazivPolaska(JLabel lblPoljeNazivPolaska) {
        this.lblPoljeNazivPolaska = lblPoljeNazivPolaska;
    }

    public JLabel getLblVoz() {
        return lblVoz;
    }

    public void setLblVoz(JLabel lblVoz) {
        this.lblVoz = lblVoz;
    }

    public JLabel getLblVreme() {
        return lblVreme;
    }

    public void setLblVreme(JLabel lblVreme) {
        this.lblVreme = lblVreme;
    }

    public JLabel getLblZaNarednih() {
        return lblZaNarednih;
    }

    public void setLblZaNarednih(JLabel lblZaNarednih) {
        this.lblZaNarednih = lblZaNarednih;
    }

    public PanelDatum getPanelDatum() {
        return panelDatum;
    }

    public void setPanelDatum(PanelDatum panelDatum) {
        this.panelDatum = panelDatum;
    }

    public JSpinner getSpinerMinuti() {
        return spinerMinuti;
    }

    public void setSpinerMinuti(JSpinner spinerMinuti) {
        this.spinerMinuti = spinerMinuti;
    }

    public JSpinner getSpinerSati() {
        return spinerSati;
    }

    public void setSpinerSati(JSpinner spinerSati) {
        this.spinerSati = spinerSati;
    }

    public JTable getTabelaPolazaka() {
        return tabelaPolazaka;
    }

    public void setTabelaPolazaka(JTable tabelaPolazaka) {
        this.tabelaPolazaka = tabelaPolazaka;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNazivPolaska = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaPolazaka = new javax.swing.JTable();
        lblDatum = new javax.swing.JLabel();
        lblVoz = new javax.swing.JLabel();
        lblLinija = new javax.swing.JLabel();
        lblPoljeDatum2 = new javax.swing.JLabel();
        cmbVoz = new javax.swing.JComboBox();
        lblVreme = new javax.swing.JLabel();
        lblDatum2 = new javax.swing.JLabel();
        spinerMinuti = new javax.swing.JSpinner();
        lblPoljeNazivPolaska = new javax.swing.JLabel();
        cmbLinijaPolazak = new javax.swing.JComboBox();
        lblLista = new javax.swing.JLabel();
        btnDodajPolazak = new javax.swing.JButton();
        btnZapamtiPolaske = new javax.swing.JButton();
        lblNaslov = new javax.swing.JLabel();
        btnObrisiPolazak = new javax.swing.JButton();
        spinerSati = new javax.swing.JSpinner();
        cmbBrojDanaZaPolazak = new javax.swing.JComboBox<>();
        lblZaNarednih = new javax.swing.JLabel();
        cboxPovratna = new javax.swing.JCheckBox();
        btnObrisiListu = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        panelDatum = new rs.stefanlezaic.zeleznice.srbije.lib.view.PanelDatum();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNazivPolaska.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNazivPolaska.setForeground(new java.awt.Color(255, 255, 255));
        lblNazivPolaska.setText("Naziv:");
        add(lblNazivPolaska, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 150, 40));

        tabelaPolazaka.setBackground(new java.awt.Color(153, 153, 153));
        tabelaPolazaka.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaPolazaka.setFocusable(false);
        tabelaPolazaka.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaPolazaka.setRowHeight(25);
        tabelaPolazaka.getTableHeader().setResizingAllowed(false);
        tabelaPolazaka.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabelaPolazaka);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 1280, 220));

        lblDatum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDatum.setForeground(new java.awt.Color(255, 255, 255));
        lblDatum.setText("Datum polaska:");
        add(lblDatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 40));

        lblVoz.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblVoz.setForeground(new java.awt.Color(255, 255, 255));
        lblVoz.setText("Voz:");
        add(lblVoz, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 150, 40));

        lblLinija.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblLinija.setForeground(new java.awt.Color(255, 255, 255));
        lblLinija.setText("Linija:");
        add(lblLinija, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 150, 40));

        lblPoljeDatum2.setForeground(new java.awt.Color(255, 255, 255));
        add(lblPoljeDatum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 150, 40));

        cmbVoz.setBackground(new java.awt.Color(153, 153, 153));
        cmbVoz.setForeground(new java.awt.Color(0, 0, 0));
        cmbVoz.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbVoz, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 140, 40));

        lblVreme.setForeground(new java.awt.Color(255, 255, 255));
        lblVreme.setText("Vreme:");
        add(lblVreme, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 90, 40));

        lblDatum2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDatum2.setForeground(new java.awt.Color(255, 255, 255));
        lblDatum2.setText("Datum dolaska: ");
        add(lblDatum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, 40));

        spinerMinuti.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        spinerMinuti.setToolTipText("");
        spinerMinuti.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        spinerMinuti.setFocusable(false);
        spinerMinuti.setOpaque(false);
        add(spinerMinuti, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 70, 40));
        spinerMinuti.setBackground(new Color(112, 122, 122));
        spinerMinuti.setForeground(Color.BLACK);

        lblPoljeNazivPolaska.setForeground(new java.awt.Color(255, 255, 255));
        add(lblPoljeNazivPolaska, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 840, 40));

        cmbLinijaPolazak.setBackground(new java.awt.Color(153, 153, 153));
        cmbLinijaPolazak.setForeground(new java.awt.Color(0, 0, 0));
        cmbLinijaPolazak.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLinijaPolazak.setSelectedIndex(-1);
        cmbLinijaPolazak.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLinijaPolazakItemStateChanged(evt);
            }
        });
        add(cmbLinijaPolazak, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 640, 40));

        lblLista.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblLista.setForeground(new java.awt.Color(255, 255, 255));
        lblLista.setText("Lista polazaka:");
        add(lblLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 300, 50));

        btnDodajPolazak.setBackground(new java.awt.Color(153, 153, 153));
        btnDodajPolazak.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDodajPolazak.setForeground(new java.awt.Color(0, 0, 0));
        btnDodajPolazak.setText("Dodaj polazak");
        add(btnDodajPolazak, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 320, 300, 60));

        btnZapamtiPolaske.setBackground(new java.awt.Color(153, 153, 153));
        btnZapamtiPolaske.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnZapamtiPolaske.setForeground(new java.awt.Color(0, 0, 0));
        btnZapamtiPolaske.setText("Zapamti polaske");
        add(btnZapamtiPolaske, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 620, 300, 60));

        lblNaslov.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblNaslov.setForeground(new java.awt.Color(255, 255, 255));
        lblNaslov.setText("Unos polazaka putnickog voza");
        add(lblNaslov, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 530, 50));

        btnObrisiPolazak.setBackground(new java.awt.Color(153, 153, 153));
        btnObrisiPolazak.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnObrisiPolazak.setForeground(new java.awt.Color(0, 0, 0));
        btnObrisiPolazak.setText("Izbaci polazak");
        add(btnObrisiPolazak, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 300, 60));

        spinerSati.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        spinerSati.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        spinerSati.setFocusable(false);
        spinerSati.setOpaque(false);
        add(spinerSati, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 70, 40));

        cmbBrojDanaZaPolazak.setBackground(new java.awt.Color(153, 153, 153));
        cmbBrojDanaZaPolazak.setForeground(new java.awt.Color(0, 0, 0));
        cmbBrojDanaZaPolazak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 dan", "7 dana", "10 dana", "15 dana" }));
        add(cmbBrojDanaZaPolazak, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, 100, 40));

        lblZaNarednih.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblZaNarednih.setForeground(new java.awt.Color(255, 255, 255));
        lblZaNarednih.setText("Za narednih:");
        add(lblZaNarednih, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 90, 40));

        cboxPovratna.setText("Povratna?");
        add(cboxPovratna, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, 90, 40));

        btnObrisiListu.setBackground(new java.awt.Color(153, 153, 153));
        btnObrisiListu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnObrisiListu.setForeground(new java.awt.Color(0, 0, 0));
        btnObrisiListu.setText("Obrisi listu");
        add(btnObrisiListu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 300, 60));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 840, 10));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 150, 10));
        add(panelDatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void cmbLinijaPolazakItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLinijaPolazakItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLinijaPolazakItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajPolazak;
    private javax.swing.JButton btnObrisiListu;
    private javax.swing.JButton btnObrisiPolazak;
    private javax.swing.JButton btnZapamtiPolaske;
    private javax.swing.JCheckBox cboxPovratna;
    private javax.swing.JComboBox<String> cmbBrojDanaZaPolazak;
    private javax.swing.JComboBox cmbLinijaPolazak;
    private javax.swing.JComboBox cmbVoz;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblDatum2;
    private javax.swing.JLabel lblLinija;
    private javax.swing.JLabel lblLista;
    private javax.swing.JLabel lblNaslov;
    private javax.swing.JLabel lblNazivPolaska;
    private javax.swing.JLabel lblPoljeDatum2;
    private javax.swing.JLabel lblPoljeNazivPolaska;
    private javax.swing.JLabel lblVoz;
    private javax.swing.JLabel lblVreme;
    private javax.swing.JLabel lblZaNarednih;
    private rs.stefanlezaic.zeleznice.srbije.lib.view.PanelDatum panelDatum;
    private javax.swing.JSpinner spinerMinuti;
    private javax.swing.JSpinner spinerSati;
    private javax.swing.JTable tabelaPolazaka;
    // End of variables declaration//GEN-END:variables

    public void btnDodajPolazakMouseListener(MouseListener mouseListener) {
        btnDodajPolazak.addMouseListener(mouseListener);
    }

    public void btnObrisiPolazakMouseListener(MouseListener mouseListener) {
        btnObrisiPolazak.addMouseListener(mouseListener);
    }

    public void btnZapamtiPolaskeMouseListener(MouseListener mouseListener) {
        btnZapamtiPolaske.addMouseListener(mouseListener);
    }

    public void btnObrisiListukMouseListener(MouseListener mouseListener) {
        btnObrisiListu.addMouseListener(mouseListener);
    }
}
