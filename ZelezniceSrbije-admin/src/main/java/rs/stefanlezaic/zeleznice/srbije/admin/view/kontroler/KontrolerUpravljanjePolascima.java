/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import rs.stefanlezaic.zeleznice.srbije.admin.form.FormaLinija;
import rs.stefanlezaic.zeleznice.srbije.admin.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.admin.modeli.tabela.ModelTabelePolaska;
import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelSviPolasci;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Polazak;
import rs.stefanlezaic.zeleznice.srbije.lib.swing.Tabela;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelSuccess;

/**
 *
 * @author Stefan
 */
public class KontrolerUpravljanjePolascima {

    private PanelSviPolasci panelSviPolasci;
    private JFrame forma;
    private final ModelTabelePolaska mtsp = new ModelTabelePolaska();
    private final Tabela tabela = new Tabela();

    public KontrolerUpravljanjePolascima() {
    }

    public KontrolerUpravljanjePolascima(PanelSviPolasci panelSviPolasci, JFrame forma) {
        this.panelSviPolasci = panelSviPolasci;
        this.forma = forma;
        addListener();
        urediTabeluSviPolasci();
        ucitajSvePolaske();
        dodajPolaske(Kontroler.getInstance().getSviPolasci());
        tabela.urediTabelu(panelSviPolasci.getTabelaSviPolasci());
    }

    private void addListener() {
        panelSviPolasci.btnObrisiPolazakIzTabeleSviPolasciActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obrisiPolazakIzTabeleSviPolasci();
            }

        });
        panelSviPolasci.btnUpdejtujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updejtuj();
            }

        });
        panelSviPolasci.btnOsveziListuSviPolasciActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osveziListu();
            }

        });
        panelSviPolasci.cmbSortirajItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                sortiraj();
            }
        });
    }

    private void obrisiPolazakIzTabeleSviPolasci() {
        int broj = panelSviPolasci.getTabelaSviPolasci().getSelectedRow();
        if (broj == -1) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention("Selektujte polazak koji zelite da obrisete!"));
        } else {
            Polazak p = mtsp.getList().get(broj);
            Object[] options = {"Da", "Ne"};
            int n = JOptionPane.showOptionDialog(forma,//parent container of JOptionPane
                    "Da li zaista zelite da obrisete polazak:" + p.getNaziv() + "?",
                    "PAZNJA",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,//do not use a custom Icon
                    options,//the titles of buttons
                    options[1]);//default button title
            if (n == 0) {
                try {
                    Kontroler.getInstance().obrisiPolazak(p);
                    new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspesno ste obrisali polazak!"));
                    mtsp.obrisi(broj);
                    mtsp.fireTableDataChanged();
                } catch (Exception ex) {
                    new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError("Ne mozete obrisati ovaj polazak!"));
                }
            }
        }
    }

    private void updejtuj() {
        ArrayList<Polazak> sviPolasci = mtsp.getList();
        ArrayList<Polazak> polasciZaMenjanje = new ArrayList<>();
        for (Polazak polazak : sviPolasci) {
            if (polazak.getNapomena() == null || !polazak.getNapomena().isEmpty()) {
                polasciZaMenjanje.add(polazak);
            }
        }
        if (polasciZaMenjanje.isEmpty()) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention("Nema polazaka za izmenu!"));
            return;
        }
        try {
            Kontroler.getInstance().updejtujMiPolaske(polasciZaMenjanje);
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("USPESNA IZMENA"));
        } catch (Exception ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
        }
    }

    private void osveziListu() {
//        ArrayList<Polazak> polasci = null;
//        try {
//            polasci = Kontroler.getInstance().vratiListuPolazaka();
//        } catch (Exception ex) {
//            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
//        }
//        dodajPolaske(polasci);
        ucitajSvePolaske();
        dodajPolaske(Kontroler.getInstance().getSviPolasci());
    }

    private void sortiraj() {
        int broj = panelSviPolasci.getCmbSortiraj().getSelectedIndex();
        if (broj == -1) {
            return;
        }
        ArrayList<Polazak> polasci = mtsp.getList();
        Collections.sort(polasci, new Comparator<Polazak>() {
            @Override
            public int compare(Polazak o1, Polazak o2) {
                switch (broj) {
                    case 0:
                        if (o1.getDatumPolaska().after(o2.getDatumPolaska())) {
                            return -1;
                        }
                        return 1;
                    case 1:
                        if (o1.getDatumPolaska().before(o2.getDatumPolaska())) {
                            return -1;
                        }
                        return 1;
                    case 2:
                        return o1.getLinija().getLinijaID() - o2.getLinija().getLinijaID();
                }
                return 0;
            }
        });
        mtsp.setList(polasci);

    }

    private void dodajPolaske(ArrayList<Polazak> lista) {
        panelSviPolasci.getTabelaSviPolasci().setModel(mtsp);
        mtsp.setList(lista);
        mtsp.fireTableDataChanged();
    }

    private void urediTabeluSviPolasci() {
        panelSviPolasci.getTabelaSviPolasci().setModel(mtsp);
        panelSviPolasci.getTabelaSviPolasci().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(0).setResizable(false);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(1).setResizable(false);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(2).setResizable(false);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(3).setResizable(false);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(4).setResizable(false);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(0).setWidth(25);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(1).setMaxWidth(450);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(1).setMinWidth(450);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(2).setMaxWidth(200);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(2).setMinWidth(200);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(3).setMaxWidth(200);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(3).setMinWidth(200);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(4).setMaxWidth(115);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(4).setMinWidth(115);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(5).setMaxWidth(250);
        panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(5).setMinWidth(250);
    }

    private void ucitajSvePolaske() {
        try {
            Kontroler.getInstance().setSviPolasci(Kontroler.getInstance().vratiListuPolazaka());
        } catch (Exception ex) {
            Logger.getLogger(FormaLinija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}