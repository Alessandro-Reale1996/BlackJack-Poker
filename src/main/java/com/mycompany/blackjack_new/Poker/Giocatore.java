/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import com.mycompany.blackjack_new.Mano;
import java.util.ArrayList;

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
    protected int rilancioGiocatoreNoCompensazione;
    

    public Giocatore() {
    }

    public Giocatore(String nomegiocatore,int ammontale) {
        this.nomegiocatore = nomegiocatore;
        this.ammontale = ammontale;
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
    public int rilancioAuto(Giocatore giocatore,Piatto piatto,ArrayList<Giocatore> giocatori)
    {   
        int retvalue = 0;
        //creo uno switch, con una relazione punti(valore)- ammontale scommesso.
        //TODO: aggiungere metodo Fold
        if(giocatore.getAmmontale()>80)
        {
            switch(giocatore.getPuntoPoker().getValore())
            {
                case 1:
                    //prima di tutto il giocatore compensa.
                    System.out.println(compensaRilancioGenerale(piatto));                   
                    retvalue = giocatore.ammontale/10;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 2:
                    System.out.println(compensaRilancioGenerale(piatto));     
                   retvalue = giocatore.ammontale/10;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 3:
                    System.out.println(compensaRilancioGenerale(piatto));     
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 4:
                    System.out.println(compensaRilancioGenerale(piatto));     
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 5:
                    System.out.println(compensaRilancioGenerale(piatto));     
                   retvalue = giocatore.ammontale/6;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 6:
                    System.out.println(compensaRilancioGenerale(piatto));     
                   retvalue = giocatore.ammontale/6;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 7:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/4;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 8:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/2;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                default:
                    //Bivio: check or fold
                    if(giocatore.ammontale>85)
                    {
                        System.out.println(check(piatto));
                    }
                    else if (giocatore.puntoPoker.valore<2)
                    {
                        fold(giocatori,giocatore);
                    }
                    
            }
        }
        else if(giocatore.getAmmontale()<80)
        {
            switch(giocatore.getPuntoPoker().getValore())
            {

                case 3:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/10;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 4:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/10;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 5:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 6:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/6;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 7:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/4;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 8:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/2;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                default:
                    //Bivio: check or fold
                    if(giocatore.ammontale>65)
                    {
                        System.out.println(check(piatto));
                    }
                    else if(giocatore.puntoPoker.valore<2)
                    {
                        fold(giocatori,giocatore);
                    }
                    
            }
        }
        else if(giocatore.getAmmontale()<60)
        {
            switch(giocatore.getPuntoPoker().getValore())
            {

                case 2:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/10;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 3:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/10;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 4:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 5:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 6:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/6;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 7:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/4;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 8:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/2;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                default:
                    //Bivio: check or fold
                    if(giocatore.ammontale>45)
                    {
                        System.out.println(check(piatto));
                    }
                    else
                    {
                        fold(giocatori,giocatore);
                    }
                    
            }
        }
        else if(giocatore.getAmmontale()<40)
        {
            switch(giocatore.getPuntoPoker().getValore())
            {
                case 5:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 6:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 7:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/4;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 8:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/2;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                default:
                    //Bivio: check or fold
                    if(giocatore.ammontale>25)
                    {
                        System.out.println(check(piatto));
                    }
                    else if (giocatore.puntoPoker.valore<2)
                    {
                        fold(giocatori,giocatore);
                    }
                    
            }
        }
        else if(giocatore.getAmmontale()<20)
        {
            switch(giocatore.getPuntoPoker().getValore())
            {
                case 6:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/8;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 7:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/4;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                case 8:
                    System.out.println(compensaRilancioGenerale(piatto));
                   retvalue = giocatore.ammontale/2;
                   this.ammontale = this.ammontale - retvalue;
                   break;
                default:
                    //Bivio: check or fold
                    if(giocatore.ammontale>10)
                    {
                        System.out.println(check(piatto));
                    }
                    else if (giocatore.puntoPoker.valore<2)
                    {
                       fold(giocatori,giocatore);
                    }
                    
            }
        }
        this.rilancioGiocatore= this.rilancioGiocatore+retvalue;
        //Impedire che rilancio giocatore minore di zero
        if(this.rilancioGiocatore <0)
        {
            this.rilancioGiocatore=0;
        }
        this.rilancioGiocatoreNoCompensazione=retvalue;
        return retvalue;       
    }
    
    //Trovo il Delta tra il rilancio generale e il rilancioGiocatore
    public int differenzaRilancioGiocRilancioGen(Piatto piatto)
    {
        int differenza = piatto.getRilancioGenerale()-this.rilancioGiocatore;
        if(differenza <0)
        {
            differenza = 0;
        }
        return differenza;
            
    }
    
    //Capisci il valore del delta e comportati di conseguenza
    public String compensaRilancioGenerale(Piatto piatto)
    {
        String retvalue = "";
           
            //tolgo il delta dall'ammontale giocatore
           this.ammontale = this.ammontale-differenzaRilancioGiocRilancioGen(piatto);    
           //aggiumgo il delta all'ammontale piatto
           piatto.setAmmontalePiatto(piatto.getAmmontalePiatto()+differenzaRilancioGiocRilancioGen(piatto));
           //dico di quanto compensa il giocatore
           retvalue = this.nomegiocatore+" compensa per "+differenzaRilancioGiocRilancioGen(piatto);
           //Compenso il rilancio giocatore
           this.rilancioGiocatore=this.rilancioGiocatore+ differenzaRilancioGiocRilancioGen(piatto);

        return retvalue;
    }
    
    //creo il metodo "check"
    public String check(Piatto piatto)
    {
        System.out.println(compensaRilancioGenerale(piatto));
        return this.nomegiocatore+" check";
    }
    
    
    public void fold(ArrayList<Giocatore> giocatori,Giocatore giocatore)
    {
        giocatori.remove(giocatore);
    }
}
