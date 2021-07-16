/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import rs.stefanlezaic.zeleznice.srbije.admin.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.admin.modeli.tabela.ModelTabelePolaska;
import rs.stefanlezaic.zeleznice.srbije.admin.view.PanelPolazak;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Linija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Polazak;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Voz;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.ParametarsException;
import rs.stefanlezaic.zeleznice.srbije.lib.kalendar.Vreme;
import rs.stefanlezaic.zeleznice.srbije.lib.swing.Tabela;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelSuccess;

/**
 *
 * @author Stefan
 */
public class KontrolerPolazak {

    private PanelPolazak panelPolazak;
    private Polazak polazak;
    private JFrame forma;
    private ModelTabelePolaska mtp = new ModelTabelePolaska();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    private final Tabela tabela = new Tabela();

    public KontrolerPolazak() {
    }

    public KontrolerPolazak(PanelPolazak panelPolazak, JFrame forma) {
        this.panelPolazak = panelPolazak;
        this.forma = forma;
        ucitajLinije();
        ucitajVozove();
        addListener();
        panelPolazak.getPanelDatum().postavi(10, Vreme.Unapred);
        panelPolazak.getPanelDatum().postaviDanasnjiDatum();
        urediTabeluPolazaka();
        tabela.urediTabelu(panelPolazak.getTabelaPolazaka());
    }

    private void ucitajLinije() {
        panelPolazak.getCmbLinijaPolazak().removeAllItems();
        ArrayList<Linija> list = null;
        try {
            list = Kontroler.getInstance().vratiMiSveLinije();
            for (Linija linija : list) {
                panelPolazak.getCmbLinijaPolazak().addItem(linija);
            }
        } catch (Exception ex) {
            System.out.println("Sistem ne moze da ucita linije!");
        }
    }

    private void ucitajVozove() {
        panelPolazak.getCmbVoz().removeAllItems();
        ArrayList<Voz> vozovi = null;
        try {
            vozovi = Kontroler.getInstance().vratiMiSveVozove();

        } catch (Exception ex) {
            System.out.println("Sistem ne moze da ucita vozove!");
        }
        for (Voz voz : vozovi) {
            panelPolazak.getCmbVoz().addItem(voz);
        }
    }

    private void addListener() {
        panelPolazak.btnDodajPolazakActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajPolazak();
            }
        });
        panelPolazak.btnObrisiPolazakActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obrisiPolazak();
            }
        });
        panelPolazak.btnZapamtiPolaskeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zapamtiPolaske();
            }
        });
        panelPolazak.btnObrisiListukActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obrisiPolaske();
            }
        });
    }

    private void dodajPolazak() {
        Linija l = (Linija) panelPolazak.getCmbLinijaPolazak().getSelectedItem();
        Voz v = (Voz) panelPolazak.getCmbVoz().getSelectedItem();

        int broj = panelPolazak.getCmbBrojDanaZaPolazak().getSelectedIndex();
        int brojDana = vratiBrojDana(broj);

        for (int i = 0; i <= brojDana; i++) {
            Polazak polazak = napraviPolazak(l, v, i);
            if (new Date().after(polazak.getDatumPolaska())) {
                new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention("Greska kod datuma polaska"));
                return;
            }
            panelPolazak.getLblNazivPolaska().setText(polazak.getNaziv());
            panelPolazak.getLblDatumDolaska().setText(sdf.format(polazak.getDatumDolaska()));
            mtp.dodajUTabelu(polazak);

            Linija linijaPovratna = Kontroler.getInstance().vratiMiPovratnu(l);
            boolean povratna = panelPolazak.getCboxPovratna().isSelected();
            if (linijaPovratna != null && povratna) {
                Polazak povratniPolazak = napraviPovratniPolazak(polazak, linijaPovratna);
                mtp.dodajUTabelu(povratniPolazak);
            }
        }
    }

    private int vratiBrojDana(int broj) {
        switch (broj) {
            case 0:
                return 0;
            case 1:
                return 6;
            case 2:
                return 9;
            case 3:
                return 14;
            default:
                return 0;
        }
    }

    private void obrisiPolazak() {
        int red = panelPolazak.getTabelaPolazaka().getSelectedRow();
        if (red != -1) {
            mtp.obrisi(red);
        }
    }

    private void zapamtiPolaske() {
        ArrayList<Polazak> list = mtp.vratiListu();
        if (list.isEmpty()) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention("Lista je prazna!"));
            return;
        }
        try {
            Kontroler.getInstance().unesiSvePolazke(list);
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Uspesno ste uneli listu polazaka!"));
            mtp.obrisiListu();
        } catch (Exception ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
        }
    }

    private void obrisiPolaske() {
        mtp.obrisiListu();
    }

    private Polazak napraviPolazak(Linija l, Voz v, int i) {
        int sati = (Integer) panelPolazak.getSpinerSati().getValue();
        int minuti = (Integer) panelPolazak.getSpinerMinuti().getValue();
        int satiLinije = l.getMinutaza() / 60;
        int minutiLinije = l.getMinutaza() % 60;

        Date polazakDatum = napraviDatum(panelPolazak.getPanelDatum().getYear(), panelPolazak.getPanelDatum().getMount(), panelPolazak.getPanelDatum().getDay() + i, sati, minuti);
        Date dolazakDatum = napraviDatum(panelPolazak.getPanelDatum().getYear(), panelPolazak.getPanelDatum().getMount(), panelPolazak.getPanelDatum().getDay() + i, sati + satiLinije, minuti + minutiLinije);

        String datumPocetni = sdf.format(polazakDatum);
        String datumKrajnji = sdf.format(dolazakDatum);

        String naziv = l.getNaziv() + " [" + datumPocetni + " -> " + datumKrajnji + "]";
        polazak = new Polazak();
        try {
            polazak.setNaziv(naziv);
            polazak.setDatumPolaska(polazakDatum);
            polazak.setDatumDolaska(dolazakDatum);
            polazak.setLinija(l);
            polazak.setVoz(v);
        } catch (ParametarsException ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention(ex.getMessage()));
        }
        return polazak;
    }

    private Polazak napraviPovratniPolazak(Polazak polazak, Linija linijaPovratna) {
        int satiLinije = linijaPovratna.getMinutaza() / 60;
        int minutiLinije = linijaPovratna.getMinutaza() % 60;

        Date datumDolaskaPravacPRVI = polazak.getDatumDolaska();

        Calendar calendar = dateUCalendar(datumDolaskaPravacPRVI);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE) + 30);
        Date datumPolaska = calendarUDate(calendar);

        Calendar calendarDolazak = dateUCalendar(datumDolaskaPravacPRVI);
        calendarDolazak.set(calendarDolazak.get(Calendar.YEAR), calendarDolazak.get(Calendar.MONTH), calendarDolazak.get(Calendar.DAY_OF_MONTH), calendarDolazak.get(Calendar.HOUR_OF_DAY) + satiLinije, calendarDolazak.get(Calendar.MINUTE) + minutiLinije);
        Date datumDolaska = calendarUDate(calendarDolazak);

        String datumPocetni = sdf.format(datumPolaska);
        String datumKrajnji = sdf.format(datumDolaska);

        String naziv = linijaPovratna.getNaziv() + " [" + datumPocetni + " -> " + datumKrajnji + "]";
        Polazak polazakPovratni = new Polazak();
        try {
            polazakPovratni.setNaziv(naziv);
            polazakPovratni.setDatumPolaska(datumPolaska);
            polazakPovratni.setDatumDolaska(datumDolaska);
            polazakPovratni.setLinija(linijaPovratna);
            polazakPovratni.setVoz(polazak.getVoz());
        } catch (ParametarsException ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention(ex.getMessage()));
        }
        return polazakPovratni;
    }

    private Calendar dateUCalendar(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal;
    }

    private Date calendarUDate(Calendar calendar) {
        Date datum = calendar.getTime();
        return datum;
    }

    private Date napraviDatum(int godina, int mesec, int dan, int sati, int minuti) {
        System.out.println(dan + "." + mesec + "." + godina + " " + sati + ":" + minuti);
        Calendar datumCalendar = new GregorianCalendar(godina, mesec - 1, dan, sati, minuti);
        Date datum = datumCalendar.getTime();
        return datum;
    }

    private void urediTabeluPolazaka() {
        panelPolazak.getTabelaPolazaka().setModel(mtp);
        panelPolazak.getTabelaPolazaka().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(0).setResizable(false);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(1).setResizable(false);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(2).setResizable(false);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(3).setResizable(false);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(4).setResizable(false);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(0).setWidth(25);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(1).setMaxWidth(540);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(1).setMinWidth(540);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(2).setMaxWidth(150);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(2).setMinWidth(150);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(3).setMaxWidth(150);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(3).setMinWidth(150);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(4).setMaxWidth(150);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(4).setMinWidth(150);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(5).setMaxWidth(250);
        panelPolazak.getTabelaPolazaka().getColumnModel().getColumn(5).setMinWidth(250);
    }

}
