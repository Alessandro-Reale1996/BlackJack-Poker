/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gianf
 */
public class ConfrontaPunteggio {
    ArrayList<Giocatore> confrontapunteggio;

    public ArrayList<Giocatore> getConfrontapunteggio() {
        return confrontapunteggio;
    }

    
    
    public ConfrontaPunteggio() {
        this.confrontapunteggio = new ArrayList<>();
    }
    
    public void inserisciPunteggi (Giocatore g1,Giocatore g2,Giocatore g3,Giocatore g4,Giocatore g5)
    {
        this.confrontapunteggio.add(g1);
        this.confrontapunteggio.add(g2);
        this.confrontapunteggio.add(g3);
        this.confrontapunteggio.add(g4);
        this.confrontapunteggio.add(g5);
    }
    
    
    public Giocatore trovaPuntoPiùAlto (ConfrontaPunteggio cp)
    {
        Giocatore retvalue = null;
        
        for(int i=0;i<cp.confrontapunteggio.size()-1;i++)
        {
            if(cp.confrontapunteggio.get(i).getPuntoPoker().getValore()>cp.confrontapunteggio.get(i+1).getPuntoPoker().getValore())
            {
                retvalue = cp.confrontapunteggio.get(i);
            }
        }
        
        return retvalue;
    }
    
    public ArrayList<Giocatore> giocatoriStessoValore (Giocatore giocatore,ConfrontaPunteggio cp)
    {
        ArrayList<Giocatore> retvalue = new ArrayList<>();
        
        for(int i=0;i<cp.confrontapunteggio.size()-1;i++)
        {
             if(giocatore.getPuntoPoker().getValore()==cp.confrontapunteggio.get(i+1).getPuntoPoker().getValore())
            {
                retvalue.add(cp.confrontapunteggio.get(i+1));
            }
        }
        
        return retvalue;
    }
    
    
}
