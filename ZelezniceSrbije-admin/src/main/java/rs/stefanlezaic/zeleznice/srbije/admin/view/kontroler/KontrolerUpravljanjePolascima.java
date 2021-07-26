/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import rs.stefanlezaic.zeleznice.srbije.admin.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.admin.modeli.tabela.ModelTabelePolaska;
import rs.stefanlezaic.zeleznice.srbije.admin.view.PanelUpravljanjePolascima;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Polazak;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.SoundEffect;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.constant.SoundConst;
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

    private PanelUpravljanjePolascima panelSviPolasci;
    private JFrame forma;
    private final ModelTabelePolaska mtsp = new ModelTabelePolaska();
    private final Tabela tabela = new Tabela();
    private final SoundEffect soundEffect = new SoundEffect();

    public KontrolerUpravljanjePolascima() {
    }

    public KontrolerUpravljanjePolascima(PanelUpravljanjePolascima panelSviPolasci, JFrame forma) {
        this.panelSviPolasci = panelSviPolasci;
        this.forma = forma;
        ucitajIkoniceZaDugmice();
        addListener();
        urediTabeluSviPolasci();
        ucitajSvePolaske();
        dodajPolaske(Kontroler.getInstance().getSviPolasci());
        tabela.urediTabelu(panelSviPolasci.getTabelaSviPolasci());
    }

    private void addListener() {
        panelSviPolasci.btnObrisiPolazakIzTabeleSviMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.KLIK);
                obrisiPolazakIzTabeleSviPolasci();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panelSviPolasci.getBtnObrisiPolazakIzTabeleSviPolasci().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/delete1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelSviPolasci.getBtnObrisiPolazakIzTabeleSviPolasci().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/delete.png")));
            }
        });

        panelSviPolasci.btnUpdejtujMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.KLIK);
                updejtuj();
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
                panelSviPolasci.getBtnUpdejtuj().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/save1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelSviPolasci.getBtnUpdejtuj().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/save.png")));
            }
        });

        panelSviPolasci.btnOsveziListuSviPolasciMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.KLIK);
                osveziListu();
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
                panelSviPolasci.getBtnOsveziListuSviPolasci().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/refresh1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelSviPolasci.getBtnOsveziListuSviPolasci().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/refresh.png")));
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
        int row = panelSviPolasci.getTabelaSviPolasci().getSelectedRow();
        if (row != -1) {
            Polazak polazak = mtsp.getList().get(row);
            ArrayList<Polazak> polasciZaMenjanje = new ArrayList<>();
            try {
                System.out.println(polasciZaMenjanje);
                Kontroler.getInstance().izmeniPolazak(polazak);
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspesna izmena polaska!"));
            } catch (Exception ex) {
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
            }
        } else {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention("Izaberite polazak!"));
        }

    }

    private void osveziListu() {
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
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < panelSviPolasci.getTabelaSviPolasci().getColumnCount(); i++) {
            panelSviPolasci.getTabelaSviPolasci().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void ucitajSvePolaske() {
        try {
            Kontroler.getInstance().setSviPolasci(Kontroler.getInstance().vratiListuPolazaka());
        } catch (Exception ex) {
            System.out.println("Sistem ne moze da ucita polaske!");
        }
    }

    private void ucitajIkoniceZaDugmice() {
        panelSviPolasci.getBtnObrisiPolazakIzTabeleSviPolasci().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/delete.png")));
        panelSviPolasci.getBtnUpdejtuj().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/save.png")));
        panelSviPolasci.getBtnOsveziListuSviPolasci().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/refresh.png")));
    }

    public void ucitajSveIkonicTamnaTema() {
        panelSviPolasci.getLblLista().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/lista.png")));

        panelSviPolasci.getLblSort().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/sort.png")));

    }

    public void ucitajSveIkoniceSvetlaTema() {
        panelSviPolasci.getLblLista().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/lista.png")));

        panelSviPolasci.getLblSort().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/sort.png")));
    }

}
