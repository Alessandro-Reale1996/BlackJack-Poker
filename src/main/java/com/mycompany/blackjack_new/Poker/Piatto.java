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
            this.ammontalePiatto = this.ammontalePiatto + 5;
            giocatore.setAmmontale(giocatore.getAmmontale()-5);
        }        
    }
    
    //Aggiungo i rilanci all'ammontale.
    public void aggiungiRilancio(ArrayList<Giocatore> giocatori, Piatto piatto)
    {
        int retvalue = this.ammontalePiatto;
        for(Giocatore giocatore : giocatori)
        {
            retvalue = retvalue + giocatore.rilancioAuto(giocatore,piatto);
        }
        this.ammontalePiatto = retvalue;
    }

    //trovo il rilancio più alto e lo setto come rilancio generale.
    public void setRilancioGeneralePerGiocatore(ArrayList<Giocatore> giocatori)
    {
        int retvalue = giocatori.get(0).getRilancioGiocatore();
        for(Giocatore giocatore : giocatori)
        {
            if(giocatore.getRilancioGiocatore()>retvalue)
            {
                retvalue = giocatore.getRilancioGiocatore();
            }
        }
        this.setRilancioGenerale(retvalue);
    }
    
    public void nessunoHaRilanciato(ArrayList<Giocatore> giocatori)
    {
        boolean nessunoHaRilanciato=true;
        for(Giocatore giocatore:giocatori)
        {
            if(giocatore.getRilancioGiocatore()!= 0)
            {
                nessunoHaRilanciato=false;
            }
        }
        if (nessunoHaRilanciato)
        {
            this.rilancioGenerale = 0;
        }
    }

    //verifica se tutti i giocatori hanno compensato il rilancio generale
    public boolean RilancioGiocatoreUgualeRilancioGenerale(ArrayList<Giocatore> giocatori,Piatto piatto)
    {
        boolean retvalue = true;
        
        //se esiste un giocatore che non ha compensato, allora retvalue=false
        for(Giocatore giocatore : giocatori)
        {
            if(giocatore.getRilancioGiocatore() != piatto.getRilancioGenerale())
            {
                retvalue = false;
            }
        }
        return retvalue;
    }
    
    //Ritorna a 0 e dai la vincita al giocatore
    public void vincitaGiocatore(Giocatore giocatore)
    {
        giocatore.setAmmontale(giocatore.getAmmontale()+this.ammontalePiatto);
    }
    
}

