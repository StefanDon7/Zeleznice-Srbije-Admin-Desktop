/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import rs.stefanlezaic.zeleznice.srbije.admin.form.FormaLinija2;
import rs.stefanlezaic.zeleznice.srbije.admin.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Mesto;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.ParametarsException;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelSuccess;

/**
 *
 * @author Stefan
 */
public class KontrolerStanica {

    private PanelStanica panelStanica;
    private Stanica stanica;
    private FormaLinija2 forma;

    public KontrolerStanica() {
    }

    public KontrolerStanica(PanelStanica panelStanica, FormaLinija2 forma) {
        this.panelStanica = panelStanica;
        this.forma = forma;
        popuniPolje();
        addListener();

    }

    private void addListener() {
        panelStanica.btnUnesiStanicu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unesiStanicu();
            }
        });
    }

    private void unesiStanicu() {
        try {
            stanica = pokupiPodatke();
            try {
                Kontroler.getInstance().unesiNovuStanicu(stanica);
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspesno ste uneli stanicu!"));

                ocistiPolja();
            } catch (Exception ex) {
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
            }
        } catch (ParametarsException ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
        }
    }

    private Stanica pokupiPodatke() throws ParametarsException {
        String nazivStanice = panelStanica.getTxtNazivStanice().getText().trim();
        Mesto mesto = (Mesto) panelStanica.getCmbMestaZaStanice().getSelectedItem();
        stanica = new Stanica();
        stanica.setMesto(mesto);
        stanica.setNaziv(nazivStanice);
        return stanica;

    }

    private void ocistiPolja() {
        panelStanica.getTxtNazivStanice().setText("");
    }

    private void popuniPolje() {
        ArrayList<Mesto> listaMesta = null;
        try {
            listaMesta = Kontroler.getInstance().vratiListuMesta();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage());
        }
        panelStanica.getCmbMestaZaStanice().removeAllItems();
        for (Mesto mesto : listaMesta) {
            panelStanica.getCmbMestaZaStanice().addItem(mesto);
        }
    }

}
