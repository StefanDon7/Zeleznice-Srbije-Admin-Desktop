/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.form.kontrolor;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
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
    private ImageIcon icon;

    public KontrolerGlavneForme(GlavnaForma glavnaForma) {
        this.glavnaForma = glavnaForma;
        napraviOstaleKontrolore();
        icon=new ImageIcon("/rs/stefanlezaic/zeleznice/srbije/server/resources/icons/icons8_train_48px.png");
        glavnaForma.setIconImage(icon.getImage());
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
        glavnaForma.setMinimumSize(new Dimension(1315, 800));
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
                glavnaForma.getPanelTema().ukljuciTamnuTemu();

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
        glavnaForma.lblSvetlaTemaActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                glavnaForma.getPanelTema().ukljuciSvetluTemu();
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
        KontrolerStanica kontrolerStanica = new KontrolerStanica(glavnaForma.getPanelLinija().getPanelStanica(), glavnaForma);
        KontrolerLinija kontrolerLinija = new KontrolerLinija(glavnaForma.getPanelLinija().getPanelLinija(), glavnaForma);
        KontrolerMedjustanica kontrolerMedjustanica = new KontrolerMedjustanica(glavnaForma.getPanelLinija().getPanelMedjustanice(), glavnaForma);
        KontrolerPolazak kontrolerPolazak = new KontrolerPolazak(glavnaForma.getPanelPolazak().getPanelPolazak(), glavnaForma);
        KontrolerUpravljanjePolascima kontrolerUpravljanjePolascima = new KontrolerUpravljanjePolascima(glavnaForma.getPanelUpravljanjePolascima().getPanelSviPolasci(), glavnaForma);
    }

    private void otvoriPanelLinija() {
        glavnaForma.getjPanelLinija().setVisible(true);
        glavnaForma.getjPanelPolazak().setVisible(false);
        glavnaForma.getjPanelUpravljanjePolascima().setVisible(false);
    }

    private void otvoriPanelPolazak() {
        glavnaForma.getjPanelLinija().setVisible(false);
        glavnaForma.getjPanelPolazak().setVisible(true);
        glavnaForma.getjPanelUpravljanjePolascima().setVisible(false);
    }

    private void otvoriPanelUpravljanjePolascima() {
        glavnaForma.getjPanelLinija().setVisible(false);
        glavnaForma.getjPanelPolazak().setVisible(false);
        glavnaForma.getjPanelUpravljanjePolascima().setVisible(true);
    }

    private void pokreniSat() {
        sat = new Sat(glavnaForma.getPanelSat1().getLblVreme(), glavnaForma.getPanelSat1().getLblDatum());
        sat.pokreniSat();
    }

    private void pokreniTemu() {
        glavnaForma.getPanelTema().dodeliContainer(glavnaForma);
        glavnaForma.getPanelTema().ukljuciTamnuTemu();
    }

}
