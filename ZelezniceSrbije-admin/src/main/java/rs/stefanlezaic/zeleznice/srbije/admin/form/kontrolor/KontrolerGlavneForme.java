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
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.buttons.AbstractMenu;
import rs.stefanlezaic.zeleznice.srbije.admin.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerLinija;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerMedjustanica;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerPolazak;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerStanica;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerUpravljanjePolascima;
import rs.stefanlezaic.zeleznice.srbije.lib.sat.Sat;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.SoundEffect;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.constant.SoundConst;
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
    private final SoundEffect soundEffect = new SoundEffect();

    public KontrolerGlavneForme(GlavnaForma glavnaForma) {
        this.glavnaForma = glavnaForma;
        napraviOstaleKontrolore();
        this.tema = new Tema(glavnaForma);
        ukljuciTamnuTemu();
        pokreniSat();
        ucitajSveIkonice();
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
        glavnaForma.setMinimumSize(new Dimension(1330, 810));
    }

    public void zatvoriGlavnuFormu() {
        glavnaForma.setVisible(false);
    }

    private void addListener() {
        glavnaForma.meniLinijaActionListener(new AbstractMenu(glavnaForma.getMeniLinija(), "linija", "linija1") {
            @Override
            public void execute() {
                otvoriPanelLinija();
            }
        });
        glavnaForma.meniPolazakActionListener(new AbstractMenu(glavnaForma.getMeniPolazak(), "polazak", "polazak1") {
            @Override
            public void execute() {
                otvoriPanelPolazak();
            }
        });
        glavnaForma.meniUpravljanjePolascimaActionListener(new AbstractMenu(glavnaForma.getMeniUpravljanjePolascima(), "lista", "lista1") {
            @Override
            public void execute() {
                otvoriPanelUpravljanjePolascima();
            }
        });
       
        glavnaForma.lblTamnaTemaActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ukljuciTamnuTemu();
                soundEffect.startAudioKlip(SoundConst.BUP);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.KLIK);
                glavnaForma.getPanelBar().getPanelTema().getLblDarkMode().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/temaSredina.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                glavnaForma.getPanelBar().getPanelTema().getLblDarkMode().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/temaCrna.png")));
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
                ukljuciSvetluTemu();
                soundEffect.startAudioKlip(SoundConst.BUP);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.KLIK);
                glavnaForma.getPanelBar().getPanelTema().getLblWhiteMode().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/temaSredina.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                glavnaForma.getPanelBar().getPanelTema().getLblWhiteMode().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/temaBela.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void ukljuciTamnuTemu() {
        glavnaForma.getPanelBar().getPanelTema().getLblWhiteMode().setVisible(true);
        glavnaForma.getPanelBar().getPanelTema().getLblDarkMode().setVisible(false);
        tema.blackTheme();
        promeniIkoniceZaTamnuTemu();
    }

    public void ukljuciSvetluTemu() {
        glavnaForma.getPanelBar().getPanelTema().getLblWhiteMode().setVisible(false);
        glavnaForma.getPanelBar().getPanelTema().getLblDarkMode().setVisible(true);
        tema.whiteTheme();
        promeniIkoniceZaSvetluTemu();
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

    private void ucitajSveIkonice() {
        glavnaForma.getMeniLinija().
                setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/menu/linija.png")));

        glavnaForma.getMeniPolazak().
                setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/menu/polazak.png")));

        glavnaForma.getMeniUpravljanjePolascima().
                setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/menu/lista.png")));

        glavnaForma.getPanelBar().getPanelTema().getLblDarkMode().
                setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/temaCrna.png")));

        glavnaForma.getPanelBar().getPanelTema().getLblWhiteMode().
                setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/temaBela.png")));
    }

    private void promeniIkoniceZaTamnuTemu() {
        kontrolerUpravljanjePolascima.ucitajSveIkonicTamnaTema();
        kontrolerLinija.ucitajSveIkonicTamnaTema();
        kontrolerMedjustanica.ucitajSveIkonicTamnaTema();
        kontrolerPolazak.ucitajSveIkonicTamnaTema();
        kontrolerStanica.ucitajSveIkonicTamnaTema();
    }

    private void promeniIkoniceZaSvetluTemu() {
        kontrolerUpravljanjePolascima.ucitajSveIkoniceSvetlaTema();
        kontrolerLinija.ucitajSveIkoniceSvetlaTema();
        kontrolerMedjustanica.ucitajSveIkoniceSvetlaTema();
        kontrolerPolazak.ucitajSveIkoniceSvetlaTema();
        kontrolerStanica.ucitajSveIkoniceSvetlaTema();
    }

}
