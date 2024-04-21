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
public class Giocatore {
    protected String nomegiocatore;
    protected Mano mano;
    protected PuntoPoker puntoPoker;
    protected int ammontale;

    public Giocatore() {
    }

    public Giocatore(String nomegiocatore,Mano mano, PuntoPoker puntoPoker, int ammontale) {
        this.nomegiocatore = nomegiocatore;
        this.mano = mano;
        this.puntoPoker = puntoPoker;
        this.ammontale = 100;
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
    
    
    
    
    
    
}
