/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.form.kontrolor;

import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerInterface;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.WindowConstants;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.buttons.AbstractMenu;
import rs.stefanlezaic.zeleznice.srbije.admin.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.admin.kontroler.KontrolerHTTP;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerLinija;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerMedjustanica;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerPolazak;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerStanica;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerTemaAdmin;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.KontrolerUpravljanjePolascima;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Linija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;
import rs.stefanlezaic.zeleznice.srbije.lib.sat.Sat;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.KontrolerSoundEffect;
import rs.stefanlezaic.zeleznice.srbije.lib.theme.Tema;

/**
 *
 * @author Stefan
 */
public class KontrolerGlavneForme {

    private GlavnaForma glavnaForma;
    private Tema tema;
    private Sat sat;
    private List<KontrolerInterface> listaKontrolera;
    private KontrolerStanica kontrolerStanica;
    private KontrolerLinija kontrolerLinija;
    private KontrolerMedjustanica kontrolerMedjustanica;
    private KontrolerPolazak kontrolerPolazak;
    private KontrolerUpravljanjePolascima kontrolerUpravljanjePolascima;

    public KontrolerGlavneForme(GlavnaForma glavnaForma) {
        this.glavnaForma = glavnaForma;
        this.tema = new Tema(glavnaForma);
        napraviOstaleKontrolore();
        promeniIkoniceZaTamnuTemu();
        glavnaForma.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/srbija.png")));
        glavnaForma.setTitle("Železnice Srbije");
        pokreniSat();
        addListener();
        ucitajSveStanice();
        ucitajSveLinije();
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
        glavnaForma.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        glavnaForma.setVisible(true);
        glavnaForma.pack();
        glavnaForma.setMinimumSize(new Dimension(1330, 820));
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


    }

    private void napraviOstaleKontrolore() {
        listaKontrolera = new ArrayList<KontrolerInterface>();
        kontrolerStanica = new KontrolerStanica(glavnaForma.getPanelUpravljanjeLinijom().getPanelStanica(), glavnaForma, this);
        listaKontrolera.add((KontrolerInterface) kontrolerStanica);
        kontrolerLinija = new KontrolerLinija(glavnaForma.getPanelUpravljanjeLinijom().getPanelLinija(), glavnaForma, this);
        listaKontrolera.add((KontrolerInterface) kontrolerLinija);
        kontrolerMedjustanica = new KontrolerMedjustanica(glavnaForma.getPanelUpravljanjeLinijom().getPanelMedjustanice(), glavnaForma, this);
        listaKontrolera.add((KontrolerInterface) kontrolerMedjustanica);
        kontrolerPolazak = new KontrolerPolazak(glavnaForma.getPanelPolazak(), glavnaForma);
        listaKontrolera.add((KontrolerInterface) kontrolerPolazak);
        kontrolerUpravljanjePolascima = new KontrolerUpravljanjePolascima(glavnaForma.getPanelUpravljanjePolascima(), glavnaForma);
        listaKontrolera.add((KontrolerInterface) kontrolerUpravljanjePolascima);
        new KontrolerSoundEffect(glavnaForma.getPanelBar().getPanelSound());
   
        
        new KontrolerTemaAdmin(glavnaForma.getPanelBar().getPanelTema(), glavnaForma) {
            @Override
            public void dodajZaSvetlu() {
                promeniIkoniceZaSvetluTemu();
            }

            @Override
            public void dodajZaTamnu() {
                promeniIkoniceZaTamnuTemu();
            }
        };
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

    private void promeniIkoniceZaTamnuTemu() {
        for (KontrolerInterface kontrolerInterface : listaKontrolera) {
            kontrolerInterface.ikoniceTamnaTema();
        }
    }

    private void promeniIkoniceZaSvetluTemu() {
        for (KontrolerInterface kontrolerInterface : listaKontrolera) {
            kontrolerInterface.ikoniceSvetlaTema();
        }
    }

    public void ucitajSveStanice() {
        kontrolerLinija.getPanelLinija().getCmbPocetna().removeAllItems();
        kontrolerLinija.getPanelLinija().getCmbKrajnja().removeAllItems();
        kontrolerMedjustanica.getPanelMedjustanice().getCmbMedjustanica().removeAllItems();
        try {
            ArrayList<Stanica> list = KontrolerHTTP.getInstance().vratiMiSveStanice();
            for (Stanica stanica : list) {
                kontrolerLinija.getPanelLinija().getCmbPocetna().addItem(stanica);
                kontrolerLinija.getPanelLinija().getCmbKrajnja().addItem(stanica);
                kontrolerMedjustanica.getPanelMedjustanice().getCmbMedjustanica().addItem(stanica);
            }
        } catch (Exception ex) {
            System.out.println("Sistem ne moze da vrati stanice!");
        }

    }

    public void ucitajSveLinije() {
        kontrolerPolazak.getPanelPolazak().getCmbLinijaPolazak().removeAllItems();
        kontrolerMedjustanica.getPanelMedjustanice().getCmbLinije().removeAllItems();
        try {
            ArrayList<Linija> list = KontrolerHTTP.getInstance().vratiMiSveLinije();
            for (Linija linija : list) {
                kontrolerPolazak.getPanelPolazak().getCmbLinijaPolazak().addItem(linija);
                kontrolerMedjustanica.getPanelMedjustanice().getCmbLinije().addItem(linija);
            }
        } catch (Exception ex) {
            System.out.println("Sistem ne moze da vrati linije!");
        }
    }

}
