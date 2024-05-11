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
    public int rilancioAuto(Giocatore giocatore,Piatto piatto)
    {   
        int retvalue = 0;
        //creo uno switch, con una relazione punti(valore)- ammontale scommesso.
        if(giocatore.getAmmontale()>75)
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
                    if(giocatore.puntoPoker.valore>85)
                    {
                        System.out.println(compensaRilancioGenerale(piatto));
                        System.out.println(check());
                    }
                    else
                    {
                        //TODO: metodo fold
                    }
                    
            }
        }
        else if(giocatore.getAmmontale()<75)
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
                    if(giocatore.puntoPoker.valore>85)
                    {
                        System.out.println(compensaRilancioGenerale(piatto));
                        System.out.println(check());
                    }
                    else
                    {
                        //TODO: metodo fold
                    }
                    
            }
        }
        else if(giocatore.getAmmontale()<50)
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
                    if(giocatore.puntoPoker.valore>85)
                    {
                        System.out.println(compensaRilancioGenerale(piatto));
                        System.out.println(check());
                    }
                    else
                    {
                        //TODO: metodo fold
                    }
                    
            }
        }
        else if(giocatore.getAmmontale()<25)
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
                    if(giocatore.puntoPoker.valore>85)
                    {
                        System.out.println(compensaRilancioGenerale(piatto));
                        System.out.println(check());
                    }
                    else
                    {
                        //TODO: metodo fold
                    }
                    
            }
        }
        this.rilancioGiocatore= this.rilancioGiocatore+retvalue;
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
    private String check()
    {
        this.rilancioGiocatore=0;
        this.rilancioGiocatoreNoCompensazione=0;
        return this.nomegiocatore+" check";
    }
}
