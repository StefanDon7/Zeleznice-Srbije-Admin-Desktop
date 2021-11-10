/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import rs.stefanlezaic.zeleznice.srbije.admin.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.admin.form.kontrolor.KontrolerGlavneForme;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.buttons.AbstractButton;
import rs.stefanlezaic.zeleznice.srbije.admin.kontroler.KontrolerHTTP;
import rs.stefanlezaic.zeleznice.srbije.admin.modeli.tabela.ModelTabeleMedjustanica;
import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelMedjustanice;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Linija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.MedjuStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.ParametarsException;
import rs.stefanlezaic.zeleznice.srbije.lib.swing.Tabela;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelSuccess;

/**
 *
 * @author Stefan
 */
public class KontrolerMedjustanica implements KontrolerInterface {

    private PanelMedjustanice panelMedjustanice;
    private MedjuStanica medjuStanica;
    private JFrame forma;
    private KontrolerGlavneForme kontrolerGlavneForme;

    private final ModelTabeleMedjustanica mtms = new ModelTabeleMedjustanica();

    public KontrolerMedjustanica(PanelMedjustanice panelMedjustanice, GlavnaForma glavnaForma, KontrolerGlavneForme kontrolerGlavneForme) {
        this.panelMedjustanice = panelMedjustanice;
        this.forma = forma;
        this.kontrolerGlavneForme = kontrolerGlavneForme;
        urediTabeluMedjuStanica();
        popuniPoljeLinije();
        addListener();
        Tabela.urediTabelu(panelMedjustanice.getTabelaMedjustanica());
        promeniLiniju();
    }

    public PanelMedjustanice getPanelMedjustanice() {
        return panelMedjustanice;
    }

    private void addListener() {
        panelMedjustanice.btnDodajMedjustanicuMouseListener(new AbstractButton(panelMedjustanice.getBtnDodajMedjustanicu(), "add", "add1") {
            @Override
            public void execute() {
                dodajMedjustanicu();
            }
        });
        panelMedjustanice.btnIzmeniRedosledMedjustanicaMouseListener(new AbstractButton(panelMedjustanice.getBtnIzmeniRedosledMedjustanica(), "save", "save1") {
            @Override
            public void execute() {
                izmeniRedosled();
            }
        });

        panelMedjustanice.btnObrisiLinijuMouseListener(new AbstractButton(panelMedjustanice.getBtnObrisiLiniju(), "delete", "delete1") {
            @Override
            public void execute() {
                obrisiLiniju();
            }
        });

        panelMedjustanice.btnObrisiMedjustanicuMouseListener(new AbstractButton(panelMedjustanice.getBtnObrisiMedjustanicu(), "minus", "minus1") {
            @Override
            public void execute() {
                obrisiMedjustanicu();
            }
        });

        panelMedjustanice.cmbLinije(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                promeniLiniju();
            }
        });
    }

    private void dodajMedjustanicu() {
        int redniBroj = mtms.vratiSizeListe();
        Linija linija = (Linija) panelMedjustanice.getCmbLinije().getSelectedItem();
        Stanica stanica = (Stanica) panelMedjustanice.getCmbMedjustanica().getSelectedItem();
        medjuStanica = new MedjuStanica();
        try {
            medjuStanica.setLinija(linija);
            medjuStanica.setRedniBroj(redniBroj);
            medjuStanica.setStanica(stanica);
            KontrolerHTTP.getInstance().unesiMedjustanicu(medjuStanica);
            mtms.dodajUTabelu(medjuStanica);
        } catch (ParametarsException ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
        } catch (Exception ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
        }
    }

    private void izmeniRedosled() {
        ArrayList<MedjuStanica> list = mtms.vratiListu();
        if (!list.isEmpty()) {
            try {
                for (MedjuStanica medjustanica : list) {
                    KontrolerHTTP.getInstance().izmeniSveMedjustanice(medjustanica);
                }
            } catch (Exception ex) {
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
            }
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspešno sačuvano!"));
            promeniMedjustaniceZaLiniju();
        }
    }

    private void promeniMedjustaniceZaLiniju() {
        mtms.izbrisiListu();
        Linija linija = (Linija) panelMedjustanice.getCmbLinije().getSelectedItem();
        if (linija == null) {
            return;
        }
        ArrayList<MedjuStanica> lista = null;
        try {
            lista = KontrolerHTTP.getInstance().vratiMiMedjustaniceLiniju(linija);
        } catch (Exception ex) {
            System.out.println("Sistem ne može da izmeni redosled međustanica!");
        }
        mtms.setList(lista);
    }

    private void obrisiMedjustanicu() {
        int red = panelMedjustanice.getTabelaMedjustanica().getSelectedRow();
        if (red != -1) {
            MedjuStanica m = mtms.getList().get(red);

            Object[] options = {"Da", "Ne"};
            int n = JOptionPane.showOptionDialog(forma,//parent container of JOptionPane
                    "Da li želite da obrišete međustanicu " + m.getStanica().getNaziv() + "?",
                    "PAŽNJA",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,//do not use a custom Icon
                    options,//the titles of buttons
                    options[1]);//default button title
            if (n == 0) {
                try {
                    KontrolerHTTP.getInstance().obrisiMedjustanicu(m);
                    new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspešno ste obrisali međustanicu!"));
                    mtms.obrisi(red);
                    izmeniRedosled();
                } catch (Exception ex) {
                    new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
                }
            }
        } else {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention("Obeležite međustanicu koju želite da obrišete!"));
        }
    }

    private void obrisiLiniju() {
        Linija l = (Linija) panelMedjustanice.getCmbLinije().getSelectedItem();
        Object[] options = {"Da", "Ne"};
        int n = JOptionPane.showOptionDialog(forma,//parent container of JOptionPane
                "Da li želite da obrišete liniju: " + l.getNazivLinije() + "?",
                "PAŽNJA",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,//do not use a custom Icon
                options,//the titles of buttons
                options[1]);//default button title

        if (n == 0) {
            try {
                KontrolerHTTP.getInstance().obrisiLiniju(new Linija(l.getLinijaID()));
                kontrolerGlavneForme.ucitajSveLinije();
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspešno ste obrisali liniju!"));
            } catch (Exception ex) {
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
            }
        }
        popuniPoljeLinije();
    }

    private void promeniLiniju() {
        mtms.izbrisiListu();
        Linija linija = (Linija) panelMedjustanice.getCmbLinije().getSelectedItem();
        if (linija == null) {
            return;
        }
        ArrayList<MedjuStanica> lista = null;
        try {
            lista = KontrolerHTTP.getInstance().vratiMiMedjustaniceLiniju(linija);
        } catch (Exception ex) {
            System.out.println("Sistem ne može da promeni liniju!");
        }
        mtms.setList(lista);
    }

    private void popuniPoljeLinije() {
        panelMedjustanice.getCmbLinije().removeAllItems();
        ArrayList<Linija> list = new ArrayList<>();
        try {
            list = KontrolerHTTP.getInstance().vratiMiSveLinije();
            for (Linija linija : list) {
                panelMedjustanice.getCmbLinije().addItem(linija);
            }
        } catch (Exception ex) {
            System.out.println("Sistem ne može da vrati linije!");
        }
    }

    private void urediTabeluMedjuStanica() {
        panelMedjustanice.getTabelaMedjustanica().setModel(mtms);
        panelMedjustanice.getTabelaMedjustanica().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        panelMedjustanice.getTabelaMedjustanica().getColumnModel().getColumn(0).setResizable(false);
        panelMedjustanice.getTabelaMedjustanica().getColumnModel().getColumn(1).setResizable(false);

        panelMedjustanice.getTabelaMedjustanica().getColumnModel().getColumn(0).setWidth(50);
        panelMedjustanice.getTabelaMedjustanica().getColumnModel().getColumn(1).setMinWidth(300);
        panelMedjustanice.getTabelaMedjustanica().getColumnModel().getColumn(1).setMaxWidth(300);
        panelMedjustanice.getTabelaMedjustanica().getColumnModel().getColumn(2).setMinWidth(300);
        panelMedjustanice.getTabelaMedjustanica().getColumnModel().getColumn(2).setMaxWidth(300);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        panelMedjustanice.getTabelaMedjustanica().getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        panelMedjustanice.getTabelaMedjustanica().getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        panelMedjustanice.getTabelaMedjustanica().getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

    }

    @Override
    public void ikoniceSvetlaTema() {
        panelMedjustanice.getLblLinija().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/voz.png")));

        panelMedjustanice.getLblMedjustanica().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/zastava.png")));

        panelMedjustanice.getLblListaMedjustanica().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/lista.png")));

    }

    @Override
    public void ikoniceTamnaTema() {
        panelMedjustanice.getLblLinija().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/voz.png")));

        panelMedjustanice.getLblMedjustanica().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/zastava.png")));

        panelMedjustanice.getLblListaMedjustanica().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/lista.png")));
    }

}
