/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler;

import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import rs.stefanlezaic.zeleznice.srbije.admin.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.admin.form.kontrolor.KontrolerGlavneForme;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.buttons.AbstractButton;
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
    private KontrolerGlavneForme kontrolerGlavneForme;

    public KontrolerLinija(PanelLinija panelLinija, GlavnaForma glavnaForma, KontrolerGlavneForme kontrolerGlavneForme) {
        this.panelLinija = panelLinija;
        this.forma = forma;
        this.kontrolerGlavneForme = kontrolerGlavneForme;
        popuniPoljeTipLinije();
        addListener();
    }

    public PanelLinija getPanelLinija() {
        return panelLinija;
    }

    private void addListener() {
        panelLinija.btnUnesiLinijuMouseListener(new AbstractButton(panelLinija.getBtnUnesiLiniju(), "add", "add1") {
            @Override
            public void execute() {
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
                kontrolerGlavneForme.ucitajSveLinije();
            } catch (Exception ex) {
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
            }
        } catch (ParametarsException | ParseException ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
        } finally {
            ocistiPolja();
        }
    }

    private Linija pokupiPodatke() throws ParametarsException, ParseException {
        double kilometraza = 0;
        int minutaza = 0;
        try {
            kilometraza = Double.parseDouble(panelLinija.getTxtKilometraza().getText());
            minutaza = Integer.parseInt(panelLinija.getTxtMinutaza().getText().trim());
        } catch (NumberFormatException ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError("U poljima kilometraza i minutaza moraju biti brojevi."));
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

    private void popuniPoljeTipLinije() {
        panelLinija.getCmbTip().removeAllItems();
        ArrayList<TipLinije> list = new ArrayList<>();
        try {
            list = Kontroler.getInstance().vratiMiSveTipoveLinije();
        } catch (Exception ex) {
            ex.toString();
        }
        for (TipLinije tipLinije : list) {
            panelLinija.getCmbTip().addItem(tipLinije);
        }
    }

    public void ucitajSveIkonicTamnaTema() {
        panelLinija.getLblPocetna().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/lokacija.png")));

        panelLinija.getLblKranja().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/lokacija.png")));

        panelLinija.getLblTip().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/voz2.png")));

        panelLinija.getLblKm().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/lenjir.png")));

        panelLinija.getLblMin().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/pescaniSat.png")));
    }

    public void ucitajSveIkoniceSvetlaTema() {
        panelLinija.getLblPocetna().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/lokacija.png")));

        panelLinija.getLblKranja().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/lokacija.png")));

        panelLinija.getLblTip().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/voz2.png")));

        panelLinija.getLblKm().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/lenjir.png")));

        panelLinija.getLblMin().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/pescaniSat.png")));
    }

}
