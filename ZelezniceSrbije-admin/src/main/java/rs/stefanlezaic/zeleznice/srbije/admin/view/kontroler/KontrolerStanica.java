/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import rs.stefanlezaic.zeleznice.srbije.admin.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Mesto;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.ParametarsException;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.SoundEffect;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.constant.SoundConst;
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
    private JFrame forma;
    private final SoundEffect soundEffect = new SoundEffect();

    public KontrolerStanica() {
    }

    public KontrolerStanica(PanelStanica panelStanica, JFrame forma) {
        this.panelStanica = panelStanica;
        this.forma = forma;
        popuniPolje();
        ucitajIkoniceZaDugmice();
        addListener();

    }

    private void addListener() {

        panelStanica.btnUnesiStanicuMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.KLIK);
                unesiStanicu();

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.INTERFEJS);
                panelStanica.getBtnUnesiStanicu().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/add1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelStanica.getBtnUnesiStanicu().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/add.png")));
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

    private void ucitajIkoniceZaDugmice() {
        panelStanica.getBtnUnesiStanicu().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/add.png")));
    }

    public void ucitajSveIkonicTamnaTema() {
        panelStanica.getLblMesto().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/lokacija.png")));

        panelStanica.getLblNazivStanice().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/zastava.png")));
    }

    public void ucitajSveIkoniceSvetlaTema() {
        panelStanica.getLblMesto().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/lokacija.png")));

        panelStanica.getLblNazivStanice().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/zastava.png")));
    }

}
