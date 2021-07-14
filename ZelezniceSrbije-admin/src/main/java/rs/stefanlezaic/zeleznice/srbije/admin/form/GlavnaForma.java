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
import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelTema;


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

    public PanelTema getPanelTema() {
        return panelTema;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBar = new javax.swing.JPanel();
        panelTema = new rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelTema();
        panelSat1 = new rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSat();
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

        panelBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelBar.add(panelTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 130, 250, 80));
        panelBar.add(panelSat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 250, 135));

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
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(panelUpravljanjePolascima, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jSeparator1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.SE_RESIZE_CURSOR));
        jSeparator1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        meniLinija.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/meni_linija_80px.png"))); // NOI18N
        meniLinija.setText("Linija");
        meniLinija.setFont(new java.awt.Font("Nirmala UI", 3, 24)); // NOI18N
        meniLinija.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuBar.add(meniLinija);

        meniPolazak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/meni_oblak_voz_100.png"))); // NOI18N
        meniPolazak.setText("Polazak");
        meniPolazak.setFont(new java.awt.Font("Nirmala UI", 3, 24)); // NOI18N
        meniPolazak.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meniPolazak.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        menuBar.add(meniPolazak);

        meniUpravljanjePolascima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/meni_lista_svi_polasci_100px.png"))); // NOI18N
        meniUpravljanjePolascima.setText("Upravljanje polascima");
        meniUpravljanjePolascima.setFont(new java.awt.Font("Nirmala UI", 3, 24)); // NOI18N
        meniUpravljanjePolascima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuBar.add(meniUpravljanjePolascima);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelLinija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelUpravljanjePolascima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelLinija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelUpravljanjePolascima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                            .addComponent(panelBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelLinija;
    private javax.swing.JPanel jPanelPolazak;
    private javax.swing.JPanel jPanelUpravljanjePolascima;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu meniLinija;
    private javax.swing.JMenu meniPolazak;
    private javax.swing.JMenu meniUpravljanjePolascima;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelBar;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.PanelLinija panelLinija;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.PanelPolazak panelPolazak;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSat panelSat1;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelTema panelTema;
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
       panelTema.getLblDarkMode().addMouseListener(mouseListener);
    }

    public void lblSvetlaTemaActionListener(MouseListener mouseListener) {
        panelTema.getLblWhiteMode().addMouseListener(mouseListener);
    }
}
