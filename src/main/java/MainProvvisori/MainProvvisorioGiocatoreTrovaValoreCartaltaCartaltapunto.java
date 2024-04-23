/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainProvvisori;

import com.mycompany.blackjack_new.Carta;
import com.mycompany.blackjack_new.Mano;
import com.mycompany.blackjack_new.Mazzo;
import com.mycompany.blackjack_new.Poker.ConfrontaPunteggio;
import com.mycompany.blackjack_new.Poker.Giocatore;
import com.mycompany.blackjack_new.Poker.PuntoPoker;

/**
 *
 * @author Siam1838
 */
public class MainProvvisorioGiocatoreTrovaValoreCartaltaCartaltapunto {
       public static void main(String[] args)
    {
        
      
        Mano mano2 = new Mano();
        
        
        // Creazione della mano 2
        Carta carta2_1 = new Carta(false, "Picche", 11);
        Carta carta2_2 = new Carta(false, "Quadri", 9);
        Carta carta2_3 = new Carta(false, "Fiori", 11);
        Carta carta2_4 = new Carta(false, "Quadri", 6);
        Carta carta2_5 = new Carta(false, "Picche", 1);
        
        mano2.addCartaAsso(carta2_1,mano2);
        mano2.addCartaAsso(carta2_2,mano2);
        mano2.addCartaAsso(carta2_3,mano2);
        mano2.addCartaAsso(carta2_4,mano2);
        mano2.addCartaAsso(carta2_5,mano2);
        
        
        System.out.println("\nMano2");
        mano2.mostraMano();
        
        
        PuntoPoker p2 = new PuntoPoker();
        
       
        p2.distinguiPunti(mano2);
        
        System.out.println(p2.getValore());
        System.out.println(p2.getCartaaltapunto().getNumero());
        System.out.println(p2.getCartalta().getNumero());
        
        
        
        
        
        
        
        
       
    }
    
}
