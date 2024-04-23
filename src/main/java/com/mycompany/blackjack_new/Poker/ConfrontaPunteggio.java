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
    //TEMP
    public void inserisciUnGiocatori (Giocatore g1)
    {
        this.confrontapunteggio.add(g1);    
    }
    
    //TEMP
    public void inserisciDueGiocatori (Giocatore g1,Giocatore g2)
    {
        this.confrontapunteggio.add(g1);
        this.confrontapunteggio.add(g2);
        
    }
    
    public void inserisciGiocatori (Giocatore g1,Giocatore g2,Giocatore g3,Giocatore g4,Giocatore g5)
    {
        this.confrontapunteggio.add(g1);
        this.confrontapunteggio.add(g2);
        this.confrontapunteggio.add(g3);
        this.confrontapunteggio.add(g4);
        this.confrontapunteggio.add(g5);
    }
    
    
    private Giocatore trovaPuntoPiùAlto (ConfrontaPunteggio cp)
    {
        Giocatore retvalue = cp.getConfrontapunteggio().get(0);
        
        for(int i=0;i<cp.confrontapunteggio.size()-1;i++)
        {
            if(cp.confrontapunteggio.get(i).getPuntoPoker().getValore()>cp.confrontapunteggio.get(i+1).getPuntoPoker().getValore())
            {
                retvalue = cp.confrontapunteggio.get(i);
            }
        }
        
        return retvalue;
    }
    
    private ArrayList<Giocatore> giocatoriStessoValore (Giocatore giocatore,ConfrontaPunteggio cp)
    {
        ArrayList<Giocatore> retvalue = new ArrayList<>();
        for(Giocatore g : cp.getConfrontapunteggio())
        {
             if(giocatore.getPuntoPoker().getValore()==g.getPuntoPoker().getValore())
            {
                retvalue.add(g);
            }
        }
        
        return retvalue;
    }
    
    private Giocatore confrontaGiocatoriStessoValore (ArrayList<Giocatore> GSV)
    {
        Giocatore retvalue = GSV.get(0);
        
        for (int i=0;i<GSV.size();i++)
        {
            if (GSV.get(i).getPuntoPoker().getCartaaltapunto().getNumero()>retvalue.getPuntoPoker().getCartaaltapunto().getNumero())
            {
                retvalue = GSV.get(i);
            }
            else
            {
              if (GSV.get(i).getPuntoPoker().getCartaaltapunto().getNumero()==retvalue.getPuntoPoker().getCartaaltapunto().getNumero())
              {
                  Collections.sort(GSV);
                  if (GSV.get(i).getPuntoPoker().getCartalta().getNumero()>retvalue.getPuntoPoker().getCartalta().getNumero())
                  {
                      retvalue = GSV.get(i);
                  }
                  else
                  { 
                      Giocatore pari = new Giocatore();
                      pari.setNomegiocatore("Pari");
                      retvalue = pari;
                  }
              }
            }
        }
        
        return retvalue;
    }
    
    public Giocatore trovaGiocatoreVincente(ConfrontaPunteggio CP)
    {
        Giocatore retvalue;
        
        Giocatore giocatorePuntoAlto = CP.trovaPuntoPiùAlto(CP);
        
        ArrayList<Giocatore> GSV = CP.giocatoriStessoValore(giocatorePuntoAlto, CP);
        
        if(GSV.size()==1)
        {
            retvalue = giocatorePuntoAlto;
        }
        else
        {
            retvalue = CP.confrontaGiocatoriStessoValore(GSV);
        }
        
        return retvalue;
    }
    
    
}
