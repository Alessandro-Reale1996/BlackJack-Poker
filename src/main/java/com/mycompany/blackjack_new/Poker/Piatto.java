/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import java.util.ArrayList;

/**
 *
 * @author Siam1838
 */
public class Piatto {
    
    protected int ammontalePiatto;
    protected int rilancioGenerale;

    public Piatto() {
        this.ammontalePiatto = 0;
        this.rilancioGenerale = 0;
    }

    public int getAmmontalePiatto() {
        return ammontalePiatto;
    }

    public void setAmmontalePiatto(int ammontalePiatto) {
        this.ammontalePiatto = ammontalePiatto;
    }

    public int getRilancioGenerale() {
        return rilancioGenerale;
    }

    public void setRilancioGenerale(int rilancioGenerale) {
        this.rilancioGenerale = rilancioGenerale;
    }

    
    public void PololaPiattoInizioRound(ArrayList<Giocatore> giocatori) 
    {        
        this.ammontalePiatto = 0;
        for(Giocatore giocatore : giocatori)
        {
            this.ammontalePiatto = this.ammontalePiatto + giocatore.getAmmontale()/10;
            giocatore.setAmmontale(giocatore.getAmmontale()-giocatore.getAmmontale()/10);
        }        
    }

    public void aggiungiRilancio(ArrayList<Giocatore> giocatori)
    {
        for(Giocatore giocatore : giocatori)
        {
            giocatore.rilancioAuto(giocatore);
        }
    }



    
}

