/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.form.kontrolor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.WindowConstants;
import rs.stefanlezaic.zeleznice.srbije.admin.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerLinija;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerMedjustanica;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerPolazak;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerStanica;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerUpravljanjePolascima;
import rs.stefanlezaic.zeleznice.srbije.lib.sat.Sat;
import rs.stefanlezaic.zeleznice.srbije.lib.theme.Tema;

/**
 *
 * @author Stefan
 */
public class KontrolerGlavneForme {

    private GlavnaForma glavnaForma;
    private Tema tema;
    private Sat sat;
    private KontrolerStanica kontrolerStanica;
    private KontrolerLinija kontrolerLinija;
    private KontrolerMedjustanica kontrolerMedjustanica;
    private KontrolerPolazak kontrolerPolazak;
    private KontrolerUpravljanjePolascima kontrolerUpravljanjePolascima;

    public KontrolerGlavneForme(GlavnaForma glavnaForma) {
        this.glavnaForma = glavnaForma;
        napraviOstaleKontrolore();
        pokreniSat();
        pokreniTemu();
        addListener();
        otvoriPanelLinija();
    }

    public GlavnaForma getGlavnaForma() {
        return glavnaForma;
    }

    public Tema getTema() {
        return tema;
    }

    public Sat getSat() {
        return sat;
    }

    public void otvoriGlavnuFormu() {
        glavnaForma.setLocationRelativeTo(null);
        glavnaForma.setVisible(true);
        glavnaForma.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        glavnaForma.setVisible(true);
        glavnaForma.pack();
        glavnaForma.setMinimumSize(new Dimension(1600, 840));
    }

    public void zatvoriGlavnuFormu() {
        glavnaForma.setVisible(false);
    }

    private void addListener() {
        glavnaForma.meniLinijaActionListener(new java.awt.event.MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                otvoriPanelLinija();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        glavnaForma.meniPolazakActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                otvoriPanelPolazak();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        glavnaForma.meniUpravljanjePolascimaActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                otvoriPanelUpravljanjePolascima();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        glavnaForma.lblTamnaTemaActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                glavnaForma.getPanelBar().getPanelTema().ukljuciTamnuTemu();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("pritisnuo");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("pustio");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        glavnaForma.lblSvetlaTemaActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                glavnaForma.getPanelBar().getPanelTema().ukljuciSvetluTemu();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void napraviOstaleKontrolore() {
        kontrolerStanica = new KontrolerStanica(glavnaForma.getPanelUpravljanjeLinijom().getPanelStanica(), glavnaForma);
        kontrolerLinija = new KontrolerLinija(glavnaForma.getPanelUpravljanjeLinijom().getPanelLinija(), glavnaForma);
        kontrolerMedjustanica = new KontrolerMedjustanica(glavnaForma.getPanelUpravljanjeLinijom().getPanelMedjustanice(), glavnaForma);
        kontrolerPolazak = new KontrolerPolazak(glavnaForma.getPanelPolazak(), glavnaForma);
        kontrolerUpravljanjePolascima = new KontrolerUpravljanjePolascima(glavnaForma.getPanelUpravljanjePolascima(), glavnaForma);
    }

    private void otvoriPanelLinija() {
        glavnaForma.getPanelUpravljanjeLinijom().setVisible(true);
        glavnaForma.getPanelPolazak().setVisible(false);
        glavnaForma.getPanelUpravljanjePolascima().setVisible(false);
    }

    private void otvoriPanelPolazak() {
        glavnaForma.getPanelUpravljanjeLinijom().setVisible(false);
        glavnaForma.getPanelPolazak().setVisible(true);
        glavnaForma.getPanelUpravljanjePolascima().setVisible(false);
    }

    private void otvoriPanelUpravljanjePolascima() {
        glavnaForma.getPanelUpravljanjeLinijom().setVisible(false);
        glavnaForma.getPanelPolazak().setVisible(false);
        glavnaForma.getPanelUpravljanjePolascima().setVisible(true);
    }

    private void pokreniSat() {
        sat = new Sat(glavnaForma.getPanelBar().getPanelSat().getLblVreme(), glavnaForma.getPanelBar().getPanelSat().getLblDatum());
        sat.pokreniSat();
    }

    private void pokreniTemu() {
        glavnaForma.getPanelBar().getPanelTema().dodeliContainer(glavnaForma);
        glavnaForma.getPanelBar().getPanelTema().ukljuciTamnuTemu();
    }

}
