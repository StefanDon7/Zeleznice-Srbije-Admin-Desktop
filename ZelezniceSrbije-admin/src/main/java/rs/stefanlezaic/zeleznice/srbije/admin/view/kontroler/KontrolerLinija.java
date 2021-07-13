/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import rs.stefanlezaic.zeleznice.srbije.admin.form.FormaLinija;
import rs.stefanlezaic.zeleznice.srbije.admin.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelLinija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Linija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.TipLinije;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.ParametarsException;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelSuccess;

/**
 *
 * @author Stefan
 */
public class KontrolerLinija {

    private PanelLinija panelLinija;
    private Linija linija;
    private JFrame forma;

    public KontrolerLinija() {
    }

    public KontrolerLinija(PanelLinija panelLinija, JFrame forma) {
        this.panelLinija = panelLinija;
        this.forma = forma;
        popuniPoljeStanice();
        popuniPoljeTipLinije();
        addListener();
    }

    private void addListener() {
        panelLinija.btnUnesiLiniju(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unesiLiniju();
            }
        });
    }

    private void unesiLiniju() {
        try {
            linija = pokupiPodatke();
            try {
                Kontroler.getInstance().unesiLiniju(linija);
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspesno sacuvana linija!"));
                ocistiPolja();
            } catch (Exception ex) {
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
            }
        } catch (ParametarsException ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
        } catch (ParseException ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
        }
    }

    private Linija pokupiPodatke() throws ParametarsException, ParseException {
        double kilometraza;
        int minutaza;
        try {
            kilometraza = Double.parseDouble(panelLinija.getTxtKilometraza().getText());
            minutaza = Integer.parseInt(panelLinija.getTxtMinutaza().getText().trim());
        } catch (Exception ex) {
            throw new java.text.ParseException("U poljima kilometraza i minutaza moraju biti brojevi.", 0);
        }
        Stanica stanicaPocetna = (Stanica) panelLinija.getCmbPocetna().getSelectedItem();
        Stanica stanicaKrajnja = (Stanica) panelLinija.getCmbKrajnja().getSelectedItem();
        TipLinije tipLinije = (TipLinije) panelLinija.getCmbTip().getSelectedItem();
        String naziv = stanicaPocetna.getNaziv() + " - " + stanicaKrajnja.getNaziv() + " (" + tipLinije.getNaziv() + ")";
        linija = new Linija();
        linija.setKilometraza(kilometraza);
        linija.setMinutaza(minutaza);
        linija.setStanicaPocetna(stanicaPocetna);
        linija.setStanicaKrajnja(stanicaKrajnja);
        linija.setTipLinije(tipLinije);
        linija.setNaziv(naziv);
        return linija;
    }

    private void ocistiPolja() {
        panelLinija.getTxtKilometraza().setText("");
        panelLinija.getTxtMinutaza().setText("");
    }

    private void popuniPoljeStanice() {
        panelLinija.getCmbPocetna().removeAllItems();
        panelLinija.getCmbKrajnja().removeAllItems();
        ArrayList<Stanica> list = null;
        try {
            list = Kontroler.getInstance().vratiMiSveStanice();
        } catch (Exception ex) {
            Logger.getLogger(FormaLinija.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        for (Stanica stanica : list) {
            panelLinija.getCmbPocetna().addItem(stanica);
            panelLinija.getCmbKrajnja().addItem(stanica);
        }
    }

    private void popuniPoljeTipLinije() {
        panelLinija.getCmbTip().removeAllItems();
        ArrayList<TipLinije> list = null;
        try {
            list = Kontroler.getInstance().vratiMiSveTipoveLinije();
        } catch (Exception ex) {
            Logger.getLogger(FormaLinija.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        for (TipLinije tipLinije : list) {
            panelLinija.getCmbTip().addItem(tipLinije);
        }
    }

}
