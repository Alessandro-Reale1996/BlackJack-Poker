/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import com.mycompany.blackjack_new.Carta;
import com.mycompany.blackjack_new.Mano;
import com.mycompany.blackjack_new.Mazzo;

/**
 *
 * @author gianf
 */
public class MainProvvisorio {
    
        public static void main(String[] args)
    {
        
        Mazzo mazzo = Mazzo.popolaMazzo();
        Mano mano = new Mano();
        
        for(int i=0; i<5; i++)
        {
            Carta carta = mazzo.estraiCarta(mazzo);
            mano.addCartaAsso(carta, mano);
        }

        
        mano.mostraMano();
        
        mano.ordinaMano();
        
        
        PuntoPoker p=new PuntoPoker();
        
        
        System.out.println("\nIl punteggio");
        
        p.distinguiPunti( mano);
        System.out.println(p.getValore());
        
        System.out.println("\ncarta alta");
        System.out.println(p.getCartalta());
                
       
    }
    
}
