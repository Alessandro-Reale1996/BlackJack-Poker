/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author gianf
 */
public class Mazzo{

    protected final ArrayList<Carta> mazzo;
    
    public  Mazzo() {
        this.mazzo = new ArrayList<>();
    }

    public ArrayList<Carta> getMazzo() {
        return mazzo;
    }
    
    
    
    public static Mazzo popolaMazzo()
    {
        Mazzo retvalue = new Mazzo();     
        String[] semi = {"Cuori", "Quadri", "Fiori", "Picche"};
        String[] valori = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
        
        
        for (String seme : semi)
        {
            for (String valore : valori)
            {
                Carta carta = new Carta(false,seme,Integer.parseInt(valore));
                retvalue.mazzo.add(carta);
            }
                   
                Asso asso = new Asso(false, seme, 14);
                retvalue.mazzo.add(asso);
            
        }
        return retvalue;
    }
    
      
      
      public Carta estraiCarta(Mazzo mazzo)
      {   
          Random random = new Random();
          Carta retvalue = null;
          boolean cartatrovata = false;
          
          do
          {
          Carta carta = this.mazzo.get(random.nextInt(this.mazzo.size()));
          
              
            if (!carta.getVerificaCartaPescata())
            {   
                if(carta instanceof Asso)
                {
                    Asso asso = (Asso) carta;
                    retvalue = asso;
                    retvalue.setVerificaCartaPescata(true);
                    cartatrovata=true;
                }
                else
                {
                    retvalue = carta;
                    retvalue.setVerificaCartaPescata(true);
                    cartatrovata=true;
                }
                
            
          } 
          }while(!cartatrovata);
          return retvalue;
      }    
      
}
