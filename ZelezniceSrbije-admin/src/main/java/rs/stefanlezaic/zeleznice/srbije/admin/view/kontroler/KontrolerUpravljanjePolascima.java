/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler.buttons.AbstractButton;
import rs.stefanlezaic.zeleznice.srbije.admin.kontroler.KontrolerHTTP;
import rs.stefanlezaic.zeleznice.srbije.admin.modeli.tabela.ModelTabelePolaska;
import rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjePolascima;
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
public class KontrolerUpravljanjePolascima implements KontrolerInterface {

    private PanelUpravljanjePolascima panelSviPolasci;
    private JFrame forma;
    private final ModelTabelePolaska mtsp = new ModelTabelePolaska();

    public KontrolerUpravljanjePolascima(PanelUpravljanjePolascima panelSviPolasci, JFrame forma) {
        this.panelSviPolasci = panelSviPolasci;
        this.forma = forma;
        addListener();
        urediTabeluSviPolasci();
        Tabela.urediTabelu(panelSviPolasci.getTabelaSviPolasci());
        ucitajSvePolaske();
        dodajPolaske(KontrolerHTTP.getInstance().getSviPolasci());
    }

    private void addListener() {
        panelSviPolasci.btnObrisiPolazakIzTabeleSviMouseListener(new AbstractButton(panelSviPolasci.getBtnObrisiPolazakIzTabeleSviPolasci(), "delete", "delete1") {
            @Override
            public void execute() {
                obrisiPolazakIzTabeleSviPolasci();
            }
        });
        panelSviPolasci.btnUpdejtujMouseListener(new AbstractButton(panelSviPolasci.getBtnUpdejtuj(), "save", "save1") {
            @Override
            public void execute() {
                updejtuj();
            }
        });
        panelSviPolasci.btnOsveziListuSviPolasciMouseListener(new AbstractButton(panelSviPolasci.getBtnOsveziListuSviPolasci(), "refresh", "refresh1") {
            @Override
            public void execute() {
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
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention("Obeležite polazak koji želite da obriđete!"));
        } else {
            Polazak p = mtsp.getList().get(broj);
                try {
                    KontrolerHTTP.getInstance().obrisiPolazak(new Polazak(p.getPolazakID()));
                    new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspešno ste obrisali polazak!"));
                    mtsp.obrisi(broj);
                    mtsp.fireTableDataChanged();
                } catch (Exception ex) {
                    new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError("Ne možete obrisati ovaj polazak!"));
                }
        }
    }

    private void updejtuj() {
        int row = panelSviPolasci.getTabelaSviPolasci().getSelectedRow();
        if (row != -1) {
            Polazak polazak = mtsp.getList().get(row);
            try {
                Polazak p =new Polazak(polazak.getPolazakID());
                p.setNapomena(polazak.getNapomena());
                  System.out.println(p.getNapomena());
                KontrolerHTTP.getInstance().izmeniPolazak(p);
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspešna ste izmenili polazak!"));
            } catch (Exception ex) {
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
            }
        } else {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention("Izaberite polazak!"));
        }
    }

    private void osveziListu() {
        ucitajSvePolaske();
        dodajPolaske(KontrolerHTTP.getInstance().getSviPolasci());
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
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < panelSviPolasci.getTabelaSviPolasci().getColumnCount(); i++) {
            panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public void ucitajSvePolaske() {
        try {
            KontrolerHTTP.getInstance().setSviPolasci(KontrolerHTTP.getInstance().vratiListuPolazaka());
            dodajPolaske(KontrolerHTTP.getInstance().getSviPolasci());
        } catch (Exception ex) {
            System.out.println("Sistem ne moze da ucita polaske!");
        }
    }
    
    @Override
    public void ikoniceSvetlaTema() {
        panelSviPolasci.getLblLista().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/lista.png")));

        panelSviPolasci.getLblSort().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/sort.png")));
    }

    @Override
    public void ikoniceTamnaTema() {
        panelSviPolasci.getLblLista().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/lista.png")));

        panelSviPolasci.getLblSort().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/sort.png")));
    }

}
