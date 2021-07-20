/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.main;

import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import rs.stefanlezaic.zeleznice.srbije.admin.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.admin.form.kontrolor.KontrolerGlavneForme;

/**
 *
 * @author Stefan
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("OptionPane.background", Color.WHITE);
                UIManager.put("Panel.background", Color.WHITE);
                UIManager.put("Button.background", new Color(155, 155, 155));
            }
        });
        KontrolerGlavneForme kontrolerGlavneForme = new KontrolerGlavneForme(new GlavnaForma());
        kontrolerGlavneForme.otvoriGlavnuFormu();

    }
}
