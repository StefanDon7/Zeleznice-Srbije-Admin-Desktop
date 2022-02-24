/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.kontroler;

import rs.stefanlezaic.zeleznice.srbije.lib.domen.MedjuStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Polazak;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Rezervacija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;
import java.util.ArrayList;
import rs.stefanlezaic.zeleznice.srbije.admin.komunikacija.KomunikacijaSaServerom;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Linija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Mesto;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.TipLinije;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Voz;
import rs.stefanlezaic.zeleznice.srbije.lib.kons.Konstante;
import rs.stefanlezaic.zeleznice.srbije.lib.kons.ResponseStatus;
import rs.stefanlezaic.zeleznice.srbije.lib.transfer.KlijentskiZahtev;
import rs.stefanlezaic.zeleznice.srbije.lib.transfer.ServerskiOdgovor;

/**
 *
 * @author sleza
 */
public class KontrolerTCP {

    private static KontrolerTCP instance;
    private KlijentskiZahtev kz;
    private ArrayList<Polazak> sviPolasci;
    private ArrayList<Linija> sveLinije;

    private KontrolerTCP() {
        sviPolasci = new ArrayList<>();
    }

    public static KontrolerTCP getInstance() {
        if (instance == null) {
            instance = new KontrolerTCP();
        }
        return instance;
    }
    
     public ArrayList<Polazak> getSviPolasci() {
        return sviPolasci;
    }

    public void setSviPolasci(ArrayList<Polazak> sviPolasci) {
        this.sviPolasci = sviPolasci;
    }

   

    public int vratiBrojRezervacija(Rezervacija r) throws Exception {
        int broj = 0;
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_REZERVACIJE_ZA_POLAZAK);
        kz.setParametar(r);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        broj = ((ArrayList<Rezervacija>) so.getOdgovor()).size();
        return broj;
    }

    public ArrayList<MedjuStanica> vratiMiSveMedjustanica() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_MEDJUSTANICE);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<MedjuStanica> listaMedjuStanica = (ArrayList<MedjuStanica>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaMedjuStanica;
    }

    public ArrayList<MedjuStanica> vratiMiMedjustaniceLiniju(MedjuStanica medjuStanica) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_MEDJUSTANICE_LINIJE);
        kz.setParametar(medjuStanica);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<MedjuStanica> listaMedjustanica = (ArrayList<MedjuStanica>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaMedjustanica;
    }

    public ArrayList<Stanica> vratiMiSveStanice() throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_STANICE);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Stanica> listaStanica = (ArrayList<Stanica>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaStanica;
    }

    public ArrayList<Polazak> vratiMiPolaskeZaDatum(Polazak p) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_POLASKE);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Polazak> listaPolazaka = (ArrayList<Polazak>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaPolazaka;
    }

    //
    public ArrayList<Mesto> vratiListuMesta() throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_MESTA);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Mesto> listaMesta = (ArrayList<Mesto>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaMesta;
    }

    public ArrayList<TipLinije> vratiMiSveTipoveLinije() throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_TIPOVE_LINIJA);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<TipLinije> listaTipovaLinija = (ArrayList<TipLinije>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaTipovaLinija;
    }

    public ArrayList<Linija> vratiMiSveLinije() throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_LINIJE);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Linija> listaLinija = (ArrayList<Linija>) so.getOdgovor();
        sveLinije = listaLinija;
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaLinija;
    }

    public ArrayList<Voz> vratiMiSveVozove() throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_VOZOVE);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Voz> listaVozova = (ArrayList<Voz>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaVozova;
    }

    public ArrayList<Polazak> vratiListuPolazaka() throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_POLASKE);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Polazak> listaPolazaka = (ArrayList<Polazak>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaPolazaka;
    }

    public ArrayList<MedjuStanica> vratiMiSveMedjustaniceZaLiniju(MedjuStanica medjuStanica) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_MEDJUSTANICE_LINIJE);
        kz.setParametar(medjuStanica);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<MedjuStanica> listaMedjustanica = (ArrayList<MedjuStanica>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaMedjustanica;
    }

    public void izmeniPolazak(Polazak polazak) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.IZMENI_POLASKE);
        kz.setParametar(polazak);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public void obrisiPolazak(Polazak p) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.OBRISI_POLAZAK);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public Linija vratiLinijuNaOsnovuStanicaITipa(Linija linijaZaPretrazivanje) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_LINIJU_NA_OSNOVU_STANICE_I_TIPA);
        kz.setParametar(linijaZaPretrazivanje);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        Linija linija = (Linija) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return linija;
    }

    public void unesiNovuStanicu(Stanica s) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.UNESI_STANICU);
        kz.setParametar(s);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public void obrisiLiniju(Linija l) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.OBRISI_LINIJU);
        kz.setParametar(l);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public void unesiSvePolazke(ArrayList<Polazak> list) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.UNESI_SVE_POLASKE);
        kz.setParametar(list);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public void izmeniSveMedjustanice(ArrayList<MedjuStanica> list) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.IZMENI_SVE_MEDJUSTANICE);
        kz.setParametar(list);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public void unesiLiniju(Linija l) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.UNESI_LINIJU);
        kz.setParametar(l);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public void obrisiMedjustanicu(MedjuStanica m) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.OBRISI_MEDJUSTANICU);
        kz.setParametar(m);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public void unesiMedjustanicu(MedjuStanica m) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.UNESI_MEDJUSTANICU);
        kz.setParametar(m);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public ArrayList<Rezervacija> vratiRezervacijePolaska(Rezervacija rezervacija) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_REZERVACIJE_ZA_POLAZAK);
        kz.setParametar(rezervacija);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Rezervacija> listaRezervacija = (ArrayList<Rezervacija>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaRezervacija;
    }

   

    public Linija vratiMiPovratnu(Linija l) {
        for (Linija linija : sveLinije) {
            if (linija.getTipLinije().getTipLinijeID() == l.getTipLinije().getTipLinijeID() && linija.getStanicaPocetna().getStanicaID() == l.getStanicaKrajnja().getStanicaID() && linija.getStanicaKrajnja().getStanicaID() == l.getStanicaPocetna().getStanicaID()) {
                return linija;
            }
        }
        return null;
    }

    public Polazak vratiPolazak(Polazak p) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setParametar(p);
        kz.setOperacija(Konstante.VRATI_POLAZAK);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return (Polazak) so.getOdgovor();
    }
}
