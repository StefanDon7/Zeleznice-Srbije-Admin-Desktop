/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.admin.form.kontrolor;

import rs.stefanlezaic.zeleznice.srbije.admin.form.FormaLinija;

/**
 *
 * @author Stefan
 */
public class KontrolorForm {
    FormaLinija f;

    public KontrolorForm() {
    }

    public KontrolorForm(FormaLinija f) {
        this.f = f;
    }
    public void prikaziFormu(){
        f.setVisible(true);
    }
    public void zatvoriFormu(){
        f.setVisible(false);
    }
    
    
    
}
