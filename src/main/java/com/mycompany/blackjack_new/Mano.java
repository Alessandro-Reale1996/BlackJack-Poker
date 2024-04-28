/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Siam1838
 */
public class Mano {
    
    protected ArrayList<Carta> mano;

    public Mano() {
        
        this.mano = new ArrayList<>();
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }
    
    
    
    public void addCartaAsso(Carta carta, Mano mano)
    {
        try
        {
            
            Asso asso = (Asso) carta;
            mano.addAsso(asso);
        }
        catch(Exception e){
           
            mano.addCarta(carta);
        }
    }
    
    private void addCarta(Carta carta)
    {
        this.mano.add(carta);
    }
    
    private void addAsso(Asso asso)
    {
        this.mano.add(asso);
    }
    
   public void mostraMano() {
       int i =0;
    for (Carta carta : mano) {
        i++;
        if (carta instanceof Asso) {           
            Asso asso = (Asso) carta;
            System.out.println(i+"."+" "+asso.toString());
        } else {
            if(carta != null)
            {
            System.out.println(i+"."+" "+carta.toString());
            }
            else
            {
                System.out.println("Problema: carta nulla"); 
            }
        }
    }
}
    
    public int sumMano()
    {
     int retvalue = 0;
     
     for (Carta carta : mano)
     {
         retvalue = retvalue + carta.getNumero();
     }
     
     return retvalue;
    }
    
     public void ordinaMano() {
        Collections.sort(mano); 
    }
     
      public boolean cambiaCarta(Carta carta,Mazzo mazzo)
    {
        boolean add = false;
                
        try
        {
        this.mano.remove(carta);
        add = this.mano.add(mazzo.estraiCarta(mazzo));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return add;
    }

 
}
