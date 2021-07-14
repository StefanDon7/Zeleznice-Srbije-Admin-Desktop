/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.component;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

    public JButton getBtnObrisiListu() {
        return btnObrisiListu;
    }

    public JButton getBtnObrisiPolazak() {
        return btnObrisiPolazak;
    }

    public JButton getBtnZapamtiPolaske() {
        return btnZapamtiPolaske;
    }

    public JCheckBox getCboxPovratna() {
        return cboxPovratna;
    }

    public JComboBox<String> getCmbBrojDanaZaPolazak() {
        return cmbBrojDanaZaPolazak;
    }

    public JComboBox getCmbLinijaPolazak() {
        return cmbLinijaPolazak;
    }

    public JComboBox getCmbVoz() {
        return cmbVoz;
    }

    public JLabel getLblDatum() {
        return lblDatum;
    }

    public JLabel getLblDatum2() {
        return lblDatum2;
    }

    public JLabel getLblDatumDolaska() {
        return lblDatumDolaska;
    }

    public JLabel getLblLinija() {
        return lblLinija;
    }

    public JLabel getLblListaPolazaka() {
        return lblListaPolazaka;
    }

    public JLabel getLblNaziv() {
        return lblNaziv;
    }

    public JLabel getLblNazivPolaska() {
        return lblNazivPolaska;
    }

    public JLabel getLblVoz() {
        return lblVoz;
    }

    public JLabel getLblVreme() {
        return lblVreme;
    }

    public JLabel getLblZaNarednih() {
        return lblZaNarednih;
    }

    public JLabel getLblpocetna() {
        return lblpocetna;
    }

    public PanelDatum getPanelDatum() {
        return panelDatum;
    }

    public JSpinner getSpinerMinuti() {
        return spinerMinuti;
    }

    public JSpinner getSpinerSati() {
        return spinerSati;
    }

    public JTable getTabelaPolazaka() {
        return tabelaPolazaka;
    }

   
       
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaziv = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaPolazaka = new javax.swing.JTable();
        lblDatum = new javax.swing.JLabel();
        lblVoz = new javax.swing.JLabel();
        lblpocetna = new javax.swing.JLabel();
        lblDatumDolaska = new javax.swing.JLabel();
        cmbVoz = new javax.swing.JComboBox();
        lblVreme = new javax.swing.JLabel();
        lblDatum2 = new javax.swing.JLabel();
        spinerMinuti = new javax.swing.JSpinner();
        lblNazivPolaska = new javax.swing.JLabel();
        cmbLinijaPolazak = new javax.swing.JComboBox();
        lblListaPolazaka = new javax.swing.JLabel();
        btnDodajPolazak = new javax.swing.JButton();
        btnZapamtiPolaske = new javax.swing.JButton();
        lblLinija = new javax.swing.JLabel();
        btnObrisiPolazak = new javax.swing.JButton();
        spinerSati = new javax.swing.JSpinner();
        cmbBrojDanaZaPolazak = new javax.swing.JComboBox<>();
        lblZaNarednih = new javax.swing.JLabel();
        cboxPovratna = new javax.swing.JCheckBox();
        btnObrisiListu = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        panelDatum = new rs.stefanlezaic.zeleznice.srbije.lib.view.PanelDatum();

        lblNaziv.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNaziv.setForeground(new java.awt.Color(255, 255, 255));
        lblNaziv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_itinerary_32px.png"))); // NOI18N
        lblNaziv.setText("Naziv:");

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

        lblDatum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDatum.setForeground(new java.awt.Color(255, 255, 255));
        lblDatum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_schedule_32px.png"))); // NOI18N
        lblDatum.setText("Datum polaska:");

        lblVoz.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblVoz.setForeground(new java.awt.Color(255, 255, 255));
        lblVoz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_train_32px.png"))); // NOI18N
        lblVoz.setText("Voz:");

        lblpocetna.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblpocetna.setForeground(new java.awt.Color(255, 255, 255));
        lblpocetna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_tracks_32px.png"))); // NOI18N
        lblpocetna.setText("Linija:");

        lblDatumDolaska.setForeground(new java.awt.Color(255, 255, 255));

        cmbVoz.setBackground(new java.awt.Color(153, 153, 153));
        cmbVoz.setForeground(new java.awt.Color(0, 0, 0));
        cmbVoz.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblVreme.setForeground(new java.awt.Color(255, 255, 255));
        lblVreme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_sand_watch_32px.png"))); // NOI18N
        lblVreme.setText("Vreme:");

        lblDatum2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDatum2.setForeground(new java.awt.Color(255, 255, 255));
        lblDatum2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_schedule_32px.png"))); // NOI18N
        lblDatum2.setText("Datum dolaska: ");

        spinerMinuti.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        spinerMinuti.setToolTipText("");
        spinerMinuti.setBorder(null);
        spinerMinuti.setFocusable(false);
        spinerMinuti.setOpaque(false);

        lblNazivPolaska.setForeground(new java.awt.Color(255, 255, 255));

        cmbLinijaPolazak.setBackground(new java.awt.Color(153, 153, 153));
        cmbLinijaPolazak.setForeground(new java.awt.Color(0, 0, 0));
        cmbLinijaPolazak.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLinijaPolazak.setSelectedIndex(-1);
        cmbLinijaPolazak.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLinijaPolazakItemStateChanged(evt);
            }
        });

        lblListaPolazaka.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblListaPolazaka.setForeground(new java.awt.Color(255, 255, 255));
        lblListaPolazaka.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_list_32px.png"))); // NOI18N
        lblListaPolazaka.setText("Lista polazaka:");

        btnDodajPolazak.setBackground(new java.awt.Color(153, 153, 153));
        btnDodajPolazak.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDodajPolazak.setForeground(new java.awt.Color(0, 0, 0));
        btnDodajPolazak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_plus_64px.png"))); // NOI18N
        btnDodajPolazak.setText("Dodaj polazak");

        btnZapamtiPolaske.setBackground(new java.awt.Color(153, 153, 153));
        btnZapamtiPolaske.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnZapamtiPolaske.setForeground(new java.awt.Color(0, 0, 0));
        btnZapamtiPolaske.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_save_64px.png"))); // NOI18N
        btnZapamtiPolaske.setText("Zapamti polaske");

        lblLinija.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblLinija.setForeground(new java.awt.Color(255, 255, 255));
        lblLinija.setText("Unos polazaka putnickog voza");

        btnObrisiPolazak.setBackground(new java.awt.Color(153, 153, 153));
        btnObrisiPolazak.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnObrisiPolazak.setForeground(new java.awt.Color(0, 0, 0));
        btnObrisiPolazak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_minus_64px.png"))); // NOI18N
        btnObrisiPolazak.setText("Izbaci polazak");

        spinerSati.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        spinerSati.setBorder(null);
        spinerSati.setFocusable(false);
        spinerSati.setOpaque(false);

        cmbBrojDanaZaPolazak.setBackground(new java.awt.Color(153, 153, 153));
        cmbBrojDanaZaPolazak.setForeground(new java.awt.Color(0, 0, 0));
        cmbBrojDanaZaPolazak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 dan", "7 dana", "10 dana", "15 dana" }));

        lblZaNarednih.setForeground(new java.awt.Color(255, 255, 255));
        lblZaNarednih.setText("Za narednih:");

        cboxPovratna.setText("Povratna?");

        btnObrisiListu.setBackground(new java.awt.Color(153, 153, 153));
        btnObrisiListu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnObrisiListu.setForeground(new java.awt.Color(0, 0, 0));
        btnObrisiListu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_trash_can_64px.png"))); // NOI18N
        btnObrisiListu.setText("Obrisi listu");

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblDatum2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(lblDatumDolaska, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblListaPolazaka, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 451, Short.MAX_VALUE)
                                .addComponent(btnObrisiPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDodajPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLinija, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblpocetna, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(cmbLinijaPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(panelDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lblVreme, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(spinerSati, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(spinerMinuti, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(lblZaNarednih, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(cmbBrojDanaZaPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(cboxPovratna, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblVoz, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(cmbVoz, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(5, 5, 5)
                                            .addComponent(lblNazivPolaska, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnObrisiListu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnZapamtiPolaske, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLinija, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblpocetna, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLinijaPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVreme, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinerSati, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinerMinuti, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblZaNarednih, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBrojDanaZaPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxPovratna, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDatum2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatumDolaska, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNazivPolaska, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVoz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbVoz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnObrisiPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDodajPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblListaPolazaka, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisiListu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZapamtiPolaske, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        spinerMinuti.setBackground(new Color(112, 122, 122));
        spinerMinuti.setForeground(Color.BLACK);
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
    private javax.swing.JLabel lblDatumDolaska;
    private javax.swing.JLabel lblLinija;
    private javax.swing.JLabel lblListaPolazaka;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblNazivPolaska;
    private javax.swing.JLabel lblVoz;
    private javax.swing.JLabel lblVreme;
    private javax.swing.JLabel lblZaNarednih;
    private javax.swing.JLabel lblpocetna;
    private rs.stefanlezaic.zeleznice.srbije.lib.view.PanelDatum panelDatum;
    private javax.swing.JSpinner spinerMinuti;
    private javax.swing.JSpinner spinerSati;
    private javax.swing.JTable tabelaPolazaka;
    // End of variables declaration//GEN-END:variables

    public void btnDodajPolazakActionListener(ActionListener actionListener) {
        btnDodajPolazak.addActionListener(actionListener);
    }

    public void btnObrisiPolazakActionListener(ActionListener actionListener) {
         btnObrisiPolazak.addActionListener(actionListener);
    }

    public void btnZapamtiPolaskeActionListener(ActionListener actionListener) {
        btnZapamtiPolaske.addActionListener(actionListener);
    }

    public void btnObrisiListukActionListener(ActionListener actionListener) {
        btnObrisiListu.addActionListener(actionListener);
    }
}
