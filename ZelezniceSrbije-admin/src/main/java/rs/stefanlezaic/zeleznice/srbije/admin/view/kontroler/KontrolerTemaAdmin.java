/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.view.kontroler;

import javax.swing.JFrame;
import rs.stefanlezaic.zeleznice.srbije.lib.theme.KontrolerTema;
import rs.stefanlezaic.zeleznice.srbije.lib.theme.PanelTema;

/**
 *
 * @author Stefan
 */
public abstract class KontrolerTemaAdmin extends KontrolerTema {

    public KontrolerTemaAdmin(PanelTema panelTema, JFrame glavnaForma) {
        super(panelTema, glavnaForma);
    }

    @Override
    protected void ukljuciTamnuTemu() {
        super.ukljuciTamnuTemu();
        dodajZaTamnu();
    }

    @Override
    protected void ukljuciSvetluTemu() {
        super.ukljuciSvetluTemu();
        dodajZaSvetlu();
    }

    public abstract void dodajZaSvetlu();

    public abstract void dodajZaTamnu();

}
