/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.form;

import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerLinija;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerMedjustanica;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerPolazak;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Linija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.MedjuStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;
import rs.stefanlezaic.zeleznice.srbije.lib.theme.Tema;

/**
 *
 * @author Stefan
 */
public class FormaLinija2 extends javax.swing.JDialog {

    /**
     * Creates new form FormaLinija2
     */
    public FormaLinija2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        KontrolerStanica kontrolerStanica = new KontrolerStanica(panelLinija.getPanelStanica(), this);
        KontrolerLinija kontrolerLinija = new KontrolerLinija(panelLinija.getPanelLinija(), this);
        KontrolerMedjustanica kontrolerMedjustanica = new KontrolerMedjustanica(panelLinija.getPanelMedjustanice(), this);
        KontrolerPolazak kontrolerPolazak=new KontrolerPolazak(panelPolazak.getPanelPolazak(), this);
        
        Tema t = new Tema(this);
        t.blackTheme();
        jPanelLinija.setBounds(0, 0, 1000, 500);
        jPanelPolazak.setBounds(0, 0, 1000, 500);
        jPanelUpravljanjePolascima.setBounds(0, 0, 1000, 500);
        jPanelLinija.setVisible(true);
        jPanelPolazak.setVisible(false);
        jPanelUpravljanjePolascima.setVisible(false);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPolazak = new javax.swing.JPanel();
        panelPolazak = new rs.stefanlezaic.zeleznice.srbije.admin.view.PanelPolazak();
        jPanelUpravljanjePolascima = new javax.swing.JPanel();
        panelUpravljanjePolascima = new rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjePolascima();
        jPanelLinija = new javax.swing.JPanel();
        panelLinija = new rs.stefanlezaic.zeleznice.srbije.admin.view.PanelLinija();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelPolazak.setAlignmentX(0.0F);
        jPanelPolazak.setAlignmentY(0.0F);
        jPanelPolazak.setName(""); // NOI18N
        jPanelPolazak.setPreferredSize(new java.awt.Dimension(1216, 641));

        javax.swing.GroupLayout jPanelPolazakLayout = new javax.swing.GroupLayout(jPanelPolazak);
        jPanelPolazak.setLayout(jPanelPolazakLayout);
        jPanelPolazakLayout.setHorizontalGroup(
            jPanelPolazakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPolazakLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelPolazakLayout.setVerticalGroup(
            jPanelPolazakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPolazakLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelUpravljanjePolascimaLayout = new javax.swing.GroupLayout(jPanelUpravljanjePolascima);
        jPanelUpravljanjePolascima.setLayout(jPanelUpravljanjePolascimaLayout);
        jPanelUpravljanjePolascimaLayout.setHorizontalGroup(
            jPanelUpravljanjePolascimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUpravljanjePolascimaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelUpravljanjePolascima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelUpravljanjePolascimaLayout.setVerticalGroup(
            jPanelUpravljanjePolascimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUpravljanjePolascimaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelUpravljanjePolascima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelLinijaLayout = new javax.swing.GroupLayout(jPanelLinija);
        jPanelLinija.setLayout(jPanelLinijaLayout);
        jPanelLinijaLayout.setHorizontalGroup(
            jPanelLinijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLinijaLayout.createSequentialGroup()
                .addComponent(panelLinija, javax.swing.GroupLayout.PREFERRED_SIZE, 1215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanelLinijaLayout.setVerticalGroup(
            jPanelLinijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLinijaLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(panelLinija, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("prvi");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        menuBar.add(jMenu1);

        jMenu2.setText("drugi");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        menuBar.add(jMenu2);

        jMenu3.setText("treci");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelLinija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelUpravljanjePolascima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelLinija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 402, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelPolazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelUpravljanjePolascima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        jPanelLinija.setVisible(true);
        jPanelPolazak.setVisible(false);
        jPanelUpravljanjePolascima.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        jPanelLinija.setVisible(false);
        jPanelPolazak.setVisible(true);
        jPanelUpravljanjePolascima.setVisible(false);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        jPanelLinija.setVisible(false);
        jPanelPolazak.setVisible(false);
        jPanelUpravljanjePolascima.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanelLinija;
    private javax.swing.JPanel jPanelPolazak;
    private javax.swing.JPanel jPanelUpravljanjePolascima;
    private javax.swing.JMenuBar menuBar;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.PanelLinija panelLinija;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.PanelPolazak panelPolazak;
    private rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjePolascima panelUpravljanjePolascima;
    // End of variables declaration//GEN-END:variables
}
