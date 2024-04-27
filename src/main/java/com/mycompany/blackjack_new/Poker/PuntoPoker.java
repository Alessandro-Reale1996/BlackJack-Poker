/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import com.mycompany.blackjack_new.Carta;
import com.mycompany.blackjack_new.Mano;
import com.mycompany.blackjack_new.Mazzo;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gianf
 */
public class PuntoPoker implements Comparable<PuntoPoker>{
    
    protected int valore;
    protected Carta cartalta;
    protected Carta cartaaltapunto;

    public int getValore() {
        return valore;
    }

    public Carta getCartalta() {
        return cartalta;
    }

    public Carta getCartaaltapunto() {
        return cartaaltapunto;
    }

    
    
    public PuntoPoker() {
        this.valore= 0;
        this.cartaaltapunto= new Carta(false,"a",0);
        this.cartalta =new Carta(false,"a",0);
    }

    
    
    @Override
    public int compareTo(PuntoPoker o) {
        return Integer.compare(this.valore, o.valore);
    }
    
    private boolean verificaScala(Mano mano)
    {
        boolean retvalue = true;
        
        for (int i = 0; i<mano.getMano().size()-1;i++)
        {
            if(mano.getMano().get(i).getNumero()+1!= mano.getMano().get(i+1).getNumero())
            {
                retvalue = false;
                break;
            }
        }
        
        return retvalue;
    }
    
    private boolean verificaColore(Mano mano)
    {
        boolean retvalue = true;
        
        for (int i = 0; i<mano.getMano().size()-1;i++)
        {
            if(!mano.getMano().get(i).getSeme().equals(mano.getMano().get(i+1).getSeme()))
            {
                retvalue = false;
                break;
            }
        }
        return retvalue;
    }


    private boolean verificaScalaRealeColore(Mano mano)
    {
        boolean retvalue = false;
        
        if(verificaColore(mano) && verificaScala(mano))
        {
            retvalue = true;
        }
        
        return retvalue;
    }
  
    public ArrayList<ArrayList<Carta>> verificaSeCiSonoCoppie(Mano mano){
       ArrayList ArrayLists = new ArrayList();
        for (int i=0; i<mano.getMano().size()-1;i++)
        { 
            ArrayList<Carta> ArrayCarte = new ArrayList<>();
            Carta carta1= mano.getMano().get(i);
            Carta carta2= mano.getMano().get(i+1);
            
            if (carta1.getNumero()==carta2.getNumero())
            {
                ArrayCarte.add(carta1);
                ArrayCarte.add(carta2);
                ArrayLists.add(ArrayCarte);
            }
        }           
         return ArrayLists;
    }
    
    private boolean èDoppiaCoppia(ArrayList<ArrayList<Carta>> verificaSeCiSonoCoppie)
    {
        boolean retvalue = false;
        
        
        if(verificaSeCiSonoCoppie.get(0).get(1).getNumero() != verificaSeCiSonoCoppie.get(1).get(0).getNumero())
        {
            retvalue = true;
        }
        
        return retvalue;
    }
    
    private boolean èPoker(ArrayList<ArrayList<Carta>> verificaSeCiSonoCoppie)
    {
        boolean retvalue = false;
        
        
        if(verificaSeCiSonoCoppie.get(0).get(1).getNumero() == verificaSeCiSonoCoppie.get(1).get(0).getNumero() &&
                verificaSeCiSonoCoppie.get(1).get(1).getNumero() == verificaSeCiSonoCoppie.get(2).get(0).getNumero())
        {
            retvalue = true;
        }
        
        return retvalue;
    }
    
    private void cartaAlta(Mano mano, ArrayList<ArrayList<Carta>> VSCSC)
    {
        if(this.cartaaltapunto.getNumero() == 0)
        {
        this.cartalta = mano.getMano().get(mano.getMano().size()-1);
        }
        else
        {
            ArrayList<Carta> templist = new ArrayList<>();
            for (ArrayList<Carta> list : VSCSC)
            {
                for(int i=0; i<list.size();i++)
                {
                    templist.add(list.get(i));
                }
            }
            ArrayList<Carta> templist2 =  new ArrayList<>();
            for(Carta carta : mano.getMano())
            {
                
                if(!templist.contains(carta))
                {
                    templist2.add(carta);
                }
                
            }
            Collections.sort(templist2);
            this.cartalta= templist2.get(templist2.size()-1);
            
            
        }
        
    }
    
    private void cartaAltaPunto(ArrayList<ArrayList<Carta>> VSCSC, int valore)
    {
        if (!VSCSC.isEmpty())
        {
            if(valore != 5)
            {
                Carta carta1 = VSCSC.get(0).get(0);
                Carta carta2 = VSCSC.get(VSCSC.size()-1).get(1);
                if (carta1.getNumero()>carta2.getNumero())
                {
                    this.cartaaltapunto=carta1;
                }
                else
                {
                    this.cartaaltapunto = carta2;
                }
            }
            else if (valore == 5)
            {
                if(VSCSC.get(0).get(1).equals(VSCSC.get(1).get(0)))
                {
                    this.cartaaltapunto = VSCSC.get(0).get(0);
                }
                else
                {
                    this.cartaaltapunto = VSCSC.get(VSCSC.size()-1).get(1);
                }
            }
        }
        
        
    }

    
    
    public void distinguiPunti(Mano mano)
    {
        mano.ordinaMano();
        ArrayList<ArrayList<Carta>> verificaSeCiSonoCoppie = verificaSeCiSonoCoppie(mano);
        
        if (verificaScalaRealeColore(mano))
        {
            this.valore =8;
        }
        else if (verificaSeCiSonoCoppie.size() == 3)
        {
            if(èPoker(verificaSeCiSonoCoppie))
            {
                this.valore=7;
            }
            else
            {
                this.valore = 5;
            }
        }
        else if (verificaColore(mano))
        {
            this.valore = 6;
        }
        else if (verificaScala(mano))
        {
            this.valore = 4;
        }
        else if (verificaSeCiSonoCoppie.size() == 2)
        {
            if(èDoppiaCoppia(verificaSeCiSonoCoppie))
            {
                this.valore = 2;
            }
            else
            {
                this.valore = 3;
            }
        }
        else if (verificaSeCiSonoCoppie.size() == 1)
        {
            this.valore = 1;
        }
        else
        {
            this.valore = 0;
        }
        
        cartaAltaPunto(verificaSeCiSonoCoppie, this.valore);
        
        cartaAlta(mano,verificaSeCiSonoCoppie);
        
    }
    
    public boolean verificaScalaColoreScalaReale(Mano mano)
        {
            boolean retvalue = false;
            
            if (verificaScalaRealeColore(mano))
            {
                retvalue = true;
            }   
            else if (verificaColore(mano))
            {
                retvalue = true;
            }
            else if (verificaScala(mano))
            {
                retvalue = true;
            }
                      
            return retvalue;
        }  
    
    public boolean cambiaCarta(Carta carta,Mano mano,Mazzo mazzo)
    {
        boolean add = false;
                
        try
        {
        mano.getMano().remove(carta);
        add = mano.getMano().add(mazzo.estraiCarta(mazzo));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return add;
    }
}