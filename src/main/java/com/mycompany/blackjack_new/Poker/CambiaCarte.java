/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import com.mycompany.blackjack_new.Carta;
import com.mycompany.blackjack_new.Mano;
import com.mycompany.blackjack_new.Mazzo;
import java.util.ArrayList;

/**
 *
 * @author gianf
 */
public class CambiaCarte {

    public CambiaCarte() {
    }
    
    
    
    /**
     *
     * @param giocatore
     * @param mazzo
     */
    public void cambiaCarte(Giocatore giocatore,Mazzo mazzo)
    {
        if(giocatore.getPuntoPoker().verificaSeCiSonoCoppie(giocatore.getMano()).isEmpty())
        {
            for(Carta carta : giocatore.getMano().getMano())
            {
                giocatore.getMano().cambiaCarta(carta, giocatore.getMano(), mazzo);
            }
        }
        else
        {
            ArrayList<Carta> templist = new ArrayList<>();
            for (ArrayList<Carta> list : giocatore.getPuntoPoker().verificaSeCiSonoCoppie(giocatore.getMano()))
            {
                for(int i=0; i<list.size();i++)
                {
                    templist.add(list.get(i));
                }
            }
            ArrayList<Carta> templist2 =  new ArrayList<>();
            for(Carta carta : giocatore.getMano().getMano())
            {
                if(!templist.contains(carta))
                {
                    templist2.add(carta);
                }
                
            for(int i=0;i<templist2.size();i++)
            {
                cambiaCarte(giocatore, mazzo);
            }
                
            }
            
        }
    }
}
