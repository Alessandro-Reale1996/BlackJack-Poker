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
        
        Carta carta1 = new Carta(false, "Cuori", 2);
        Carta carta2 = new Carta(false, "Quadri", 13);
        Carta carta3 = new Carta(false, "Fiori", 1);
        Carta carta4 = new Carta(false, "Picche", 4);
        Carta carta5 = new Carta(false, "Cuori", 13);
        
        Mano mano = new Mano();
        
        mano.addCartaAsso(carta1, mano);
        mano.addCartaAsso(carta2, mano);
        mano.addCartaAsso(carta3, mano);
        mano.addCartaAsso(carta4, mano);
        mano.addCartaAsso(carta5, mano);
        
        mano.mostraMano();
        
        mano.ordinaMano();
        
        
        PuntoPoker p=new PuntoPoker();
        
        
        System.out.println("\nIl punteggio");
        
        p.distinguiPunti( mano);
        System.out.println(p.getValore());
        
        System.out.println("\ncarta alta");
        System.out.println(p.getCartalta());
        
        System.out.println("\ncartaaltapunto");
        System.out.println(p.getCartaaltapunto());
                
       
    }
    
}
