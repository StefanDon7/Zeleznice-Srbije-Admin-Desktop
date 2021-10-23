/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.kontroler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.MedjuStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Polazak;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Rezervacija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;
import java.util.ArrayList;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
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
public class KontrolerHTTP {

    private static KontrolerHTTP instance;
    private OkHttpClient httpClient;
    private Gson gson;
    private ArrayList<Polazak> sviPolasci;
    private ArrayList<Linija> sveLinije;

    private KontrolerHTTP() {
        sviPolasci = new ArrayList<>();
        httpClient = new OkHttpClient();
        gson = new Gson();
        gson.serializeNulls();
    }

    public static KontrolerHTTP getInstance() {
        if (instance == null) {
            instance = new KontrolerHTTP();
        }
        return instance;
    }

    public ArrayList<Polazak> getSviPolasci() {
        return sviPolasci;
    }

    public void setSviPolasci(ArrayList<Polazak> sviPolasci) {
        this.sviPolasci = sviPolasci;
    }

    public int vratiBrojRezervacija(Polazak p) throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/polazak/reservation/" + p.getPolazakID())
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        int broj = 0;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            JSONObject jsonResponse = new JSONObject(response.body().string());
            Polazak polazak = gson.fromJson(jsonResponse.toString(), Polazak.class);
            broj = polazak.getPolazakID();
        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj registracije!");
        }
        System.out.println(broj);
        return broj;
    }

    public ArrayList<MedjuStanica> vratiMiMedjustaniceLiniju(Linija l) throws Exception {
        String json = gson.toJson(l);
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/medjustanica/" + l.getLinijaID())
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        ArrayList<MedjuStanica> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type tipListe = new TypeToken<ArrayList<MedjuStanica>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), tipListe);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;
    }

    public ArrayList<Stanica> vratiMiSveStanice() throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/stanica/all")
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        ArrayList<Stanica> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type tipListe = new TypeToken<ArrayList<Stanica>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), tipListe);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;
    }

    public ArrayList<Mesto> vratiListuMesta() throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/mesto/all")
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        ArrayList<Mesto> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type tipListe = new TypeToken<ArrayList<Mesto>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), tipListe);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;
    }

    public ArrayList<TipLinije> vratiMiSveTipoveLinije() throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/tipLinije/all")
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        ArrayList<TipLinije> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type tipListe = new TypeToken<ArrayList<TipLinije>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), tipListe);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;
    }

    public ArrayList<Linija> vratiMiSveLinije() throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/linija/all")
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        ArrayList<Linija> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type tipListe = new TypeToken<ArrayList<Linija>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), tipListe);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;
    }

    public ArrayList<Voz> vratiMiSveVozove() throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/voz/all")
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        ArrayList<Voz> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type tipListe = new TypeToken<ArrayList<Voz>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), tipListe);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;
    }

    public ArrayList<Polazak> vratiListuPolazaka() throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/polazak/all")
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        ArrayList<Polazak> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type tipListe = new TypeToken<ArrayList<Polazak>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), tipListe);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;

    }

//    public ArrayList<MedjuStanica> vratiMiSveMedjustaniceZaLiniju(MedjuStanica medjuStanica) throws Exception {
//        kz = new KlijentskiZahtev();
//        kz.setOperacija(Konstante.VRATI_MEDJUSTANICE_LINIJE);
//        kz.setParametar(medjuStanica);
//        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
//        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
//        ArrayList<MedjuStanica> listaMedjustanica = (ArrayList<MedjuStanica>) so.getOdgovor();
//        if (so.getStatus() == ResponseStatus.ERROR) {
//            Exception ex = (Exception) so.getError();
//            throw ex;
//        }
//        return listaMedjustanica;
//    }
//
    public void izmeniPolazak(Polazak polazak) throws Exception {
        String json = gson.toJson(polazak);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/polazak/update")
                .addHeader("Accept-Encoding", "gzip")
                .put(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj rezervacije karata!");
        }
    }

    public void obrisiPolazak(Polazak p) throws Exception {
        String json = gson.toJson(p);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/polazak/delete")
                .addHeader("Accept-Encoding", "gzip")
                .delete(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj rezervacije karata!");
        }
    }

    public void unesiNovuStanicu(Stanica s) throws Exception {
        String json = gson.toJson(s);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/stanica/add")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj rezervacije karata!");
        }
    }

    public void unesiSvePolaske(Polazak p) throws Exception {
        String json = gson.toJson(p);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/polazak/add")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj rezervacije karata!");
        }
    }

//    public void izmeniSveMedjustanice(ArrayList<MedjuStanica> list) throws Exception {
//        kz = new KlijentskiZahtev();
//        kz.setOperacija(Konstante.IZMENI_SVE_MEDJUSTANICE);
//        kz.setParametar(list);
//        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
//        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
//        if (so.getStatus() == ResponseStatus.ERROR) {
//            Exception ex = (Exception) so.getError();
//            throw ex;
//        }
//    }
//
//    public void unesiLiniju(Linija l) throws Exception {
//        kz = new KlijentskiZahtev();
//        kz.setOperacija(Konstante.UNESI_LINIJU);
//        kz.setParametar(l);
//        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
//        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
//        if (so.getStatus() == ResponseStatus.ERROR) {
//            Exception ex = (Exception) so.getError();
//            throw ex;
//        }
//    }
//
//    public void obrisiMedjustanicu(MedjuStanica m) throws Exception {
//        kz = new KlijentskiZahtev();
//        kz.setOperacija(Konstante.OBRISI_MEDJUSTANICU);
//        kz.setParametar(m);
//        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
//        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
//        if (so.getStatus() == ResponseStatus.ERROR) {
//            Exception ex = (Exception) so.getError();
//            throw ex;
//        }
//    }
//
//    public void unesiMedjustanicu(MedjuStanica m) throws Exception {
//        kz = new KlijentskiZahtev();
//        kz.setOperacija(Konstante.UNESI_MEDJUSTANICU);
//        kz.setParametar(m);
//        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
//        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
//        if (so.getStatus() == ResponseStatus.ERROR) {
//            Exception ex = (Exception) so.getError();
//            throw ex;
//        }
//    }
//
//    public Polazak vratiPolazak(Polazak p) throws Exception {
//        kz = new KlijentskiZahtev();
//        kz.setParametar(p);
//        kz.setOperacija(Konstante.VRATI_POLAZAK);
//        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
//        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
//        if (so.getStatus() == ResponseStatus.ERROR) {
//            Exception ex = (Exception) so.getError();
//            throw ex;
//        }
//        return (Polazak) so.getOdgovor();
//    }
    public Linija vratiMiPovratnu(Linija l) {
        for (Linija linija : sveLinije) {
            if (linija.getTipLinije().getTipLinijeID() == l.getTipLinije().getTipLinijeID() && linija.getStanicaPocetna().getStanicaID() == l.getStanicaKrajnja().getStanicaID() && linija.getStanicaKrajnja().getStanicaID() == l.getStanicaPocetna().getStanicaID()) {
                return linija;
            }
        }
        return null;
    }
}
