/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.form;

import java.awt.event.MouseListener;
import javax.swing.JMenu;
import rs.stefanlezaic.zeleznice.srbije.admin.view.PanelBar;
import rs.stefanlezaic.zeleznice.srbije.admin.view.PanelPolazak;
import rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjeLinijom;
import rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjePolascima;

/**
 *
 * @author Stefan
 */
public class GlavnaForma extends javax.swing.JFrame {

    public GlavnaForma() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        panelUpravljanjeLinijom = new rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjeLinijom();
        panelPolazak = new rs.stefanlezaic.zeleznice.srbije.admin.view.PanelPolazak();
        panelUpravljanjePolascima = new rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjePolascima();
        panelBar = new rs.stefanlezaic.zeleznice.srbije.admin.view.PanelBar();
        menuBar = new javax.swing.JMenuBar();
        meniLinija = new javax.swing.JMenu();
        meniPolazak = new javax.swing.JMenu();
        meniUpravljanjePolascima = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1600, 790));
        setPreferredSize(new java.awt.Dimension(1600, 790));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray, 3));
        jSeparator1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 3, 670));
        getContentPane().add(panelUpravljanjeLinijom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 690));

        panelPolazak.setMinimumSize(new java.awt.Dimension(1290, 690));
        panelPolazak.setPreferredSize(new java.awt.Dimension(1290, 690));
        getContentPane().add(panelPolazak, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 690));
        getContentPane().add(panelUpravljanjePolascima, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 690));
        getContentPane().add(panelBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 260, 290));

        meniLinija.setBorder(null);
        meniLinija.setForeground(java.awt.Color.lightGray);
        meniLinija.setText("Linija");
        meniLinija.setFont(new java.awt.Font("Nirmala UI", 3, 24)); // NOI18N
        meniLinija.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meniLinija.setPreferredSize(new java.awt.Dimension(250, 80));
        menuBar.add(meniLinija);

        meniPolazak.setBorder(null);
        meniPolazak.setForeground(java.awt.Color.lightGray);
        meniPolazak.setText("Polazak");
        meniPolazak.setFont(new java.awt.Font("Nirmala UI", 3, 24)); // NOI18N
        meniPolazak.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meniPolazak.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        meniPolazak.setPreferredSize(new java.awt.Dimension(250, 80));
        menuBar.add(meniPolazak);

        meniUpravljanjePolascima.setBorder(null);
        meniUpravljanjePolascima.setForeground(java.awt.Color.lightGray);
        meniUpravljanjePolascima.setText("Upravljanje polascima");
        meniUpravljanjePolascima.setFont(new java.awt.Font("Nirmala UI", 3, 24)); // NOI18N
        meniUpravljanjePolascima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meniUpravljanjePolascima.setPreferredSize(new java.awt.Dimension(370, 80));
        menuBar.add(meniUpravljanjePolascima);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JMenu getMeniLinija() {
        return meniLinija;
    }

    public JMenu getMeniPolazak() {
        return meniPolazak;
    }

    public JMenu getMeniUpravljanjePolascima() {
        return meniUpravljanjePolascima;
    }

    public PanelBar getPanelBar() {
        return panelBar;
    }

    public PanelPolazak getPanelPolazak() {
        return panelPolazak;
    }

    public PanelUpravljanjeLinijom getPanelUpravljanjeLinijom() {
        return panelUpravljanjeLinijom;
    }

    public PanelUpravljanjePolascima getPanelUpravljanjePolascima() {
        return panelUpravljanjePolascima;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu meniLinija;
    private javax.swing.JMenu meniPolazak;
    private javax.swing.JMenu meniUpravljanjePolascima;
    private javax.swing.JMenuBar menuBar;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.PanelBar panelBar;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.PanelPolazak panelPolazak;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjeLinijom panelUpravljanjeLinijom;
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
        panelBar.getPanelTema().getLblDarkMode().addMouseListener(mouseListener);
    }

    public void lblSvetlaTemaActionListener(MouseListener mouseListener) {
        panelBar.getPanelTema().getLblWhiteMode().addMouseListener(mouseListener);
    }
}
