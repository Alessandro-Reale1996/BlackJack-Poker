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
    protected int rilancioGiocatore;

    public Giocatore() {
    }

    public Giocatore(int ammontale) {
        this.ammontale = ammontale;
        this.rilancioGiocatore = 0;
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

    public int getRilancioGiocatore() {
        return rilancioGiocatore;
    }
    
    

    public void setMano(Mano mano) {
        this.mano = mano;
    }

    public void setPuntoPoker(PuntoPoker puntoPoker) {
        this.puntoPoker = puntoPoker;
    }

    public void setAmmontale(int ammontale) {
        this.ammontale = ammontale;
    }

    public void setRilancioGiocatore(int rilancioGiocatore) {
        this.rilancioGiocatore = rilancioGiocatore;
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
   
    //Creo il metodo per il rilancio automatizzato
    public int rilancioAuto(Giocatore giocatore)
    {
        int retvalue = 0;
        //creo uno switch, con una relazione punti(valore)- ammontale scommesso.
        if(giocatore.getAmmontale()>75)
        {
            switch(giocatore.getPuntoPoker().getValore())
            {

                case 2:
                   retvalue = giocatore.ammontale/10;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 3:
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 4:
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 5:
                   retvalue = giocatore.ammontale/6;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 6:
                   retvalue = giocatore.ammontale/6;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 7:
                   retvalue = giocatore.ammontale/4;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 8:
                   retvalue = giocatore.ammontale/2;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                default:
                    //TODO
                    
            }
        }
        else if(giocatore.getAmmontale()<75)
        {
            switch(giocatore.getPuntoPoker().getValore())
            {

                case 3:
                   retvalue = giocatore.ammontale/10;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 4:
                   retvalue = giocatore.ammontale/10;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 5:
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 6:
                   retvalue = giocatore.ammontale/6;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 7:
                   retvalue = giocatore.ammontale/4;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 8:
                   retvalue = giocatore.ammontale/2;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                default:
                    //TODO
                    
            }
        }
        else if(giocatore.getAmmontale()<50)
        {
            switch(giocatore.getPuntoPoker().getValore())
            {

                case 2:
                   retvalue = giocatore.ammontale/10;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 3:
                   retvalue = giocatore.ammontale/10;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 4:
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 5:
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 6:
                   retvalue = giocatore.ammontale/6;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 7:
                   retvalue = giocatore.ammontale/4;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 8:
                   retvalue = giocatore.ammontale/2;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                default:
                    //TODO
                    
            }
        }
        else if(giocatore.getAmmontale()<25)
        {
            switch(giocatore.getPuntoPoker().getValore())
            {
                case 5:
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 6:
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 7:
                   retvalue = giocatore.ammontale/4;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 8:
                   retvalue = giocatore.ammontale/2;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                default:
                    //TODO
                    
            }
        }
        return retvalue;
    }
}
