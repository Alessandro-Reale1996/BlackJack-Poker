/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import com.mycompany.blackjack_new.Carta;
import com.mycompany.blackjack_new.Mano;
import java.util.ArrayList;

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

    
    
    public PuntoPoker() {
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
    
    private void cartaAlta(Mano mano){
        this.cartalta = mano.getMano().get(mano.getMano().size()-1);
    }
    
    private void cartaAltaPunto(ArrayList<ArrayList<Carta>> VSCSC)
    {
        if (!VSCSC.isEmpty())
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
        
        
    }

    
    
    public void distinguiPunti(Mano mano)
    {
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
        
        cartaAlta(mano);
        
    }
    
    

}