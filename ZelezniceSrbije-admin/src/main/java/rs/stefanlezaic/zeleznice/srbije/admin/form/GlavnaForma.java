/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.form;


import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import rs.stefanlezaic.zeleznice.srbije.admin.view.PanelLinija;
import rs.stefanlezaic.zeleznice.srbije.admin.view.PanelPolazak;
import rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjePolascima;
import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSat;


/**
 *
 * @author Stefan
 */
public class GlavnaForma extends javax.swing.JFrame {

    
    public GlavnaForma() {
        initComponents();
    }

    public JPanel getPanelBar() {
        return panelBar;
    }

    public PanelSat getPanelSat1() {
        return panelSat1;
    }

    public JLabel getLblDarkMode() {
        return lblDarkMode;
    }

    public JLabel getLblWhiteMode() {
        return lblWhiteMode;
    }

    public PanelLinija getPanelLinija() {
        return panelLinija;
    }

    public PanelPolazak getPanelPolazak() {
        return panelPolazak;
    }

    public PanelUpravljanjePolascima getPanelUpravljanjePolascima() {
        return panelUpravljanjePolascima;
    }

    public JMenu getMeniLinija() {
        return meniLinija;
    }

    public JMenu getMeniPolazak() {
        return meniPolazak;
    }

    public JMenu getMeniUpravljanjePolascima() {
        return meniUpravljanjePolascima;
    }

    public JPanel getjPanelLinija() {
        return jPanelLinija;
    }

    public JPanel getjPanelPolazak() {
        return jPanelPolazak;
    }

    public JPanel getjPanelUpravljanjePolascima() {
        return jPanelUpravljanjePolascima;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBar = new javax.swing.JPanel();
        panelSat1 = new rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSat();
        lblDarkMode = new javax.swing.JLabel();
        lblWhiteMode = new javax.swing.JLabel();
        jPanelUpravljanjePolascima = new javax.swing.JPanel();
        panelUpravljanjePolascima = new rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjePolascima();
        jPanelPolazak = new javax.swing.JPanel();
        panelPolazak = new rs.stefanlezaic.zeleznice.srbije.admin.view.PanelPolazak();
        jPanelLinija = new javax.swing.JPanel();
        panelLinija = new rs.stefanlezaic.zeleznice.srbije.admin.view.PanelLinija();
        jSeparator1 = new javax.swing.JSeparator();
        menuBar = new javax.swing.JMenuBar();
        meniLinija = new javax.swing.JMenu();
        meniPolazak = new javax.swing.JMenu();
        meniUpravljanjePolascima = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelSat1.setFont(new java.awt.Font("Nirmala UI", 3, 14)); // NOI18N

        lblDarkMode.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDarkMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/darkMode.png"))); // NOI18N
        lblDarkMode.setText("Tamno");

        lblWhiteMode.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblWhiteMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/whiteMode.png"))); // NOI18N
        lblWhiteMode.setText("Svetlo");

        javax.swing.GroupLayout panelBarLayout = new javax.swing.GroupLayout(panelBar);
        panelBar.setLayout(panelBarLayout);
        panelBarLayout.setHorizontalGroup(
            panelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarLayout.createSequentialGroup()
                .addGroup(panelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDarkMode, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWhiteMode, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSat1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBarLayout.setVerticalGroup(
            panelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarLayout.createSequentialGroup()
                .addGroup(panelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDarkMode, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWhiteMode, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(336, Short.MAX_VALUE))
        );

        jPanelUpravljanjePolascima.setPreferredSize(new java.awt.Dimension(1300, 600));

        javax.swing.GroupLayout jPanelUpravljanjePolascimaLayout = new javax.swing.GroupLayout(jPanelUpravljanjePolascima);
        jPanelUpravljanjePolascima.setLayout(jPanelUpravljanjePolascimaLayout);
        jPanelUpravljanjePolascimaLayout.setHorizontalGroup(
            jPanelUpravljanjePolascimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpravljanjePolascimaLayout.createSequentialGroup()
                .addComponent(panelUpravljanjePolascima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanelUpravljanjePolascimaLayout.setVerticalGroup(
            jPanelUpravljanjePolascimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUpravljanjePolascimaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelUpravljanjePolascima, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelPolazakLayout = new javax.swing.GroupLayout(jPanelPolazak);
        jPanelPolazak.setLayout(jPanelPolazakLayout);
        jPanelPolazakLayout.setHorizontalGroup(
            jPanelPolazakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPolazakLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelPolazakLayout.setVerticalGroup(
            jPanelPolazakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPolazakLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanelLinijaLayout = new javax.swing.GroupLayout(jPanelLinija);
        jPanelLinija.setLayout(jPanelLinijaLayout);
        jPanelLinijaLayout.setHorizontalGroup(
            jPanelLinijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLinijaLayout.createSequentialGroup()
                .addComponent(panelLinija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanelLinijaLayout.setVerticalGroup(
            jPanelLinijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLinijaLayout.createSequentialGroup()
                .addComponent(panelLinija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.SE_RESIZE_CURSOR));
        jSeparator1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        meniLinija.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/meni_linija_80px.png"))); // NOI18N
        meniLinija.setText("Linija");
        meniLinija.setFont(new java.awt.Font("Nirmala UI", 3, 24)); // NOI18N
        menuBar.add(meniLinija);

        meniPolazak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/meni_oblak_voz_100.png"))); // NOI18N
        meniPolazak.setText("Polazak");
        meniPolazak.setFont(new java.awt.Font("Nirmala UI", 3, 24)); // NOI18N
        menuBar.add(meniPolazak);

        meniUpravljanjePolascima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/meni_lista_svi_polasci_100px.png"))); // NOI18N
        meniUpravljanjePolascima.setText("Upravljanje polascima");
        meniUpravljanjePolascima.setFont(new java.awt.Font("Nirmala UI", 3, 24)); // NOI18N
        menuBar.add(meniUpravljanjePolascima);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1490, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelLinija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanelPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanelUpravljanjePolascima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(panelBar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelLinija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanelPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanelUpravljanjePolascima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 4, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelLinija;
    private javax.swing.JPanel jPanelPolazak;
    private javax.swing.JPanel jPanelUpravljanjePolascima;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDarkMode;
    private javax.swing.JLabel lblWhiteMode;
    private javax.swing.JMenu meniLinija;
    private javax.swing.JMenu meniPolazak;
    private javax.swing.JMenu meniUpravljanjePolascima;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelBar;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.PanelLinija panelLinija;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.PanelPolazak panelPolazak;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSat panelSat1;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjePolascima panelUpravljanjePolascima;
    // End of variables declaration//GEN-END:variables

    public void meniLinijaActionListener(MouseListener mouseListener) {
        meniLinija.addMouseListener(mouseListener);
    }

    public void meniPolazakActionListener(MouseListener mouseListener) {
        meniPolazak.addMouseListener(mouseListener);
    }

    public void meniUpravljanjePolascimaActionListener(MouseListener mouseListener) {
        meniUpravljanjePolascima.addMouseListener(mouseListener);
    }

    public void lblTamnaTemaActionListener(MouseListener mouseListener) {
        lblDarkMode.addMouseListener(mouseListener);
    }

    public void lblSvetlaTemaActionListener(MouseListener mouseListener) {
        lblWhiteMode.addMouseListener(mouseListener);
    }
}
