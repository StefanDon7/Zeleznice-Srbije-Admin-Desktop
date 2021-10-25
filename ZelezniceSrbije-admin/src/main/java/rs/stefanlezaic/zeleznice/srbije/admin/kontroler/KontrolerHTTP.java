/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.kontroler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.MedjuStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Polazak;
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
        sveLinije = new ArrayList<>();
        httpClient = new OkHttpClient();
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
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
            throw new Exception("Sistem ne može da vrati broj rezervacija za polazak!");
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
            throw new Exception("Sistem ne može da vrati sve medjustanicu!");
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
            throw new Exception("Sistem ne može da vrati stanice!");
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
            throw new Exception("Sistem ne može da vrati mesta!");
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
            throw new Exception("Sistem ne može da vrati tipove linija!");
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
            throw new Exception("Sistem ne može da vrati linije!");
        }
        sveLinije = lista;
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
            throw new Exception("Sistem ne može da izmeni vrati tipove vozova!");
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
            throw new Exception("Sistem ne može da izmeni vrati listu polazaka!");
        }
        System.out.println(lista);
        return lista;

    }

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
            throw new Exception("Sistem ne može da izmeni polazak!");
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
            throw new Exception("Sistem ne može da obriše polazak!");
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
            throw new Exception("Sistem ne može da unese stanicu!");
        }
    }

    public void unesiPolazak(Polazak p) throws Exception {
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
            throw new Exception("Sistem ne može da unese polazak!");
        }
    }

    public void izmeniSveMedjustanice(MedjuStanica medjustanica) throws Exception {
        String json = gson.toJson(medjustanica);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/medjustanica/update")
                .addHeader("Accept-Encoding", "gzip")
                .put(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception ex) {
            throw new Exception("Sistem ne može da izmeni medjustanicu!");
        }
    }

    public void unesiLiniju(Linija l) throws Exception {
        String json = gson.toJson(l);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/linija/add")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception ex) {
            throw new Exception("Sistem ne može da unese liniju!");
        }
    }

    public void obrisiLiniju(Linija l) throws Exception {
        String json = gson.toJson(l);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/linija/delete")
                .addHeader("Accept-Encoding", "gzip")
                .delete(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception ex) {
            throw new Exception("Sistem ne može da obriše liniju!");
        }
    }

    public void obrisiMedjustanicu(MedjuStanica m) throws Exception {
        String json = gson.toJson(m);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/medjustanica/delete")
                .addHeader("Accept-Encoding", "gzip")
                .delete(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception ex) {
            throw new Exception("Sistem ne može da obriše medjustanicu!!");
        }
    }

    public void unesiMedjustanicu(MedjuStanica m) throws Exception {
        String json = gson.toJson(m);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/medjustanica/add")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception ex) {
            throw new Exception("Sistem ne može da unese medjustanicu!");
        }
    }

    public Linija vratiMiPovratnu(Linija l) {
        for (Linija linija : sveLinije) {
            if (linija.getTipLinije().getTipLinijeID() == l.getTipLinije().getTipLinijeID() && linija.getStanicaPocetna().getStanicaID() == l.getStanicaKrajnja().getStanicaID() && linija.getStanicaKrajnja().getStanicaID() == l.getStanicaPocetna().getStanicaID()) {
                return linija;
            }
        }
        return null;
    }

}
