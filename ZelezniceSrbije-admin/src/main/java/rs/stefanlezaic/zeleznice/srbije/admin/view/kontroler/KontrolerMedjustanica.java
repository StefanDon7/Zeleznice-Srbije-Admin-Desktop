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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import rs.stefanlezaic.zeleznice.srbije.admin.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.admin.modeli.tabela.ModelTabeleMedjustanica;
import rs.stefanlezaic.zeleznice.srbije.admin.view.component.PanelMedjustanice;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Linija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.MedjuStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.ParametarsException;
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
public class KontrolerMedjustanica {

    private PanelMedjustanice panelMedjustanice;
    private MedjuStanica medjuStanica;
    private JFrame forma;
    private final ModelTabeleMedjustanica mtms = new ModelTabeleMedjustanica();
    private final Tabela tabela = new Tabela();
    private final SoundEffect soundEffect = new SoundEffect();

    public KontrolerMedjustanica(PanelMedjustanice panelMedjustanice, JFrame forma) {
        this.panelMedjustanice = panelMedjustanice;
        this.forma = forma;
        urediTabeluMedjuStanica();
        popuniPoljeStanice();
        popuniPoljeLinije();
        ucitajIkoniceZaDugmice();
        addListener();
        tabela.urediTabelu(panelMedjustanice.getTabelaMedjustanica());
    }

    private void addListener() {
        panelMedjustanice.btnDodajMedjustanicuMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.KLIK);
                dodajMedjustanicu();
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
                panelMedjustanice.getBtnDodajMedjustanicu().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/add1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelMedjustanice.getBtnDodajMedjustanicu().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/add.png")));
            }
        });

        panelMedjustanice.btnIzmeniRedosledMedjustanicaMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.KLIK);
                izmeniRedosled();
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
                panelMedjustanice.getBtnIzmeniRedosledMedjustanica().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/save1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelMedjustanice.getBtnIzmeniRedosledMedjustanica().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/save.png")));
            }
        });

        panelMedjustanice.btnObrisiMedjustanicuMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.KLIK);
                obrisiMedjustanicu();
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
                panelMedjustanice.getBtnObrisiMedjustanicu().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/minus1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelMedjustanice.getBtnObrisiMedjustanicu().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/minus.png")));
            }
        });

        panelMedjustanice.btnObrisiLinijuMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.INTERFEJS);
                obrisiLiniju();
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
                panelMedjustanice.getBtnObrisiLiniju().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/delete1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelMedjustanice.getBtnObrisiLiniju().setIcon(new ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/delete.png")));
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
            Kontroler.getInstance().unesiMedjustanicu(medjuStanica);
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
                Kontroler.getInstance().izmeniSveMedjustanice(list);
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspesno sacuvano"));
            } catch (Exception ex) {
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
            }
            promeniMedjustaniceZaLiniju();
        }
    }

    private void promeniMedjustaniceZaLiniju() {
        mtms.izbrisiListu();
        Linija l = (Linija) panelMedjustanice.getCmbLinije().getSelectedItem();
        if (l == null) {
            return;
        }
        ArrayList<MedjuStanica> lista = null;
        try {
            lista = Kontroler.getInstance().vratiMiSveMedjustaniceZaLiniju(new MedjuStanica(null, l, -1));
        } catch (Exception ex) {
            System.out.println("Sistem ne moze da vrati promeni medjustanice!");
        }
        mtms.setList(lista);
    }

    private void obrisiMedjustanicu() {
        int red = panelMedjustanice.getTabelaMedjustanica().getSelectedRow();
        if (red != -1) {
            MedjuStanica m = mtms.getList().get(red);

            Object[] options = {"Da", "Ne"};
            int n = JOptionPane.showOptionDialog(forma,//parent container of JOptionPane
                    "Da li zaista zelite da obrisete medjustanicu:" + m.getStanica().getNaziv() + "?",
                    "PAZNJA",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,//do not use a custom Icon
                    options,//the titles of buttons
                    options[1]);//default button title
            if (n == 0) {
                try {
                    Kontroler.getInstance().obrisiMedjustanicu(m);
                    new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspesno ste obrisali medjustanicu iz baze!"));
                    mtms.obrisi(red);
                    izmeniRedosled();
                } catch (Exception ex) {
                    new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
                }
            }
        } else {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention("Morate da izaberete medjustanicu koju zelite da obrisete!"));
        }
    }

    private void obrisiLiniju() {
        Linija l = (Linija) panelMedjustanice.getCmbLinije().getSelectedItem();
        Object[] options = {"Da", "Ne"};
        int n = JOptionPane.showOptionDialog(forma,//parent container of JOptionPane
                "Da li zaista zelite da obrisete liniju: " + l.getNaziv() + "?",
                "PAZNJA",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,//do not use a custom Icon
                options,//the titles of buttons
                options[1]);//default button title

        if (n == 0) {
            try {
                Kontroler.getInstance().obrisiLiniju(l);
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspesno ste obrisali liniju: "));
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
            lista = Kontroler.getInstance().vratiMiSveMedjustaniceZaLiniju(new MedjuStanica(null, linija, -1));
        } catch (Exception ex) {
            System.out.println("Sistem ne moze da promeni linije!");
        }
        mtms.setList(lista);
    }

    private void popuniPoljeStanice() {
        panelMedjustanice.getCmbMedjustanica().removeAllItems();
        ArrayList<Stanica> list = new ArrayList<>();
        try {
            list = Kontroler.getInstance().vratiMiSveStanice();
        } catch (Exception ex) {
            System.out.println("Sistem ne moze da vrati stanice!");
        }
        for (Stanica stanica : list) {
            panelMedjustanice.getCmbMedjustanica().addItem(stanica);
        }
    }

    private void popuniPoljeLinije() {
        panelMedjustanice.getCmbLinije().removeAllItems();
        ArrayList<Linija> list = new ArrayList<>();
        try {
            list = Kontroler.getInstance().vratiMiSveLinije();
            for (Linija linija : list) {
                panelMedjustanice.getCmbLinije().addItem(linija);
            }
        } catch (Exception ex) {
            System.out.println("Sistem ne moze da vrati linije!");
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

    private void ucitajIkoniceZaDugmice() {
        panelMedjustanice.getBtnDodajMedjustanicu().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/add.png")));

        panelMedjustanice.getBtnObrisiMedjustanicu().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/minus.png")));

        panelMedjustanice.getBtnObrisiLiniju().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/delete.png")));

        panelMedjustanice.getBtnIzmeniRedosledMedjustanica().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/buttons/save.png")));

    }

    public void ucitajSveIkonicTamnaTema() {
        panelMedjustanice.getLblLinija().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/voz.png")));

        panelMedjustanice.getLblMedjustanica().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/zastava.png")));

        panelMedjustanice.getLblListaMedjustanica().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label/lista.png")));

    }

    public void ucitajSveIkoniceSvetlaTema() {
        panelMedjustanice.getLblLinija().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/voz.png")));

        panelMedjustanice.getLblMedjustanica().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/zastava.png")));

        panelMedjustanice.getLblListaMedjustanica().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/admin/resources/icons/label1/lista.png")));

    }
}
