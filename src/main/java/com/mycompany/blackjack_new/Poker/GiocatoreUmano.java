/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import com.mycompany.blackjack_new.Mano;

/**
 *
 * @author Siam1838
 */
/*
Classe che ha l'unico scopo di non dover fare due arraylist, una con il giocatore umano e una senza
*/
public class GiocatoreUmano extends Giocatore {

    public GiocatoreUmano() {
    }

    public GiocatoreUmano(String nomegiocatore) {
        super(nomegiocatore);
    }
    
    public GiocatoreUmano(int ammontale) {
        super(ammontale);
    }

    public GiocatoreUmano(String nomegiocatore, Mano mano, PuntoPoker puntoPoker)
    {
        super(nomegiocatore, mano, puntoPoker);
    }
    
    //TODO: bisogna mettere il metodo per rilanciare
}
