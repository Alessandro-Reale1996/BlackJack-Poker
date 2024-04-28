/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import com.mycompany.blackjack_new.Mano;

/**
 *
 * @author gianf
 */
public class Giocatore implements Comparable<Giocatore> {
    protected String nomegiocatore;
    protected Mano mano;
    protected PuntoPoker puntoPoker;
    protected int ammontale;

    public Giocatore() {
    }

   

    public Giocatore(String nomegiocatore,Mano mano, PuntoPoker puntoPoker) {
        this.nomegiocatore = nomegiocatore;
        this.mano = mano;
        this.puntoPoker = puntoPoker;
        this.ammontale = 100;
    }

    public void setNomegiocatore(String nomegiocatore) {
        this.nomegiocatore = nomegiocatore;
    }

    
    
    
    public PuntoPoker getPuntoPoker() {
        return puntoPoker;
    }

    public String getNomegiocatore() {
        return nomegiocatore;
    }

    public Mano getMano() {
        return mano;
    }

    public int getAmmontale() {
        return ammontale;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }
    
    

    @Override
    public int compareTo(Giocatore t) {
        int r = Integer.compare(this.puntoPoker.getCartaaltapunto().getNumero(), t.getPuntoPoker().getCartaaltapunto().getNumero());
        
        if (r==0)
        {
           r = Integer.compare(this.puntoPoker.getCartalta().getNumero(), t.getPuntoPoker().getCartalta().getNumero());
        }
        
        return r;
    }
   
}
