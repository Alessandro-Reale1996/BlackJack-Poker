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
import java.util.ArrayList;

/**
 *
 * @author gianf
 */
public class MainProvvisorio {
    
        public static void main(String[] args)
    {
        
        Mazzo mazzo = Mazzo.popolaMazzo();
        Mano mano1 = new Mano();
        Mano mano2 = new Mano();
        
        for (int i=0;i<5;i++)
        {
            mano1.addCartaAsso(mazzo.estraiCarta(mazzo),mano1);
            mano2.addCartaAsso(mazzo.estraiCarta(mazzo), mano2);
        }
        
        System.out.println("\nMano1");
        mano1.mostraMano();
        System.out.println("\nMano2");
        mano2.mostraMano();
        
        PuntoPoker p1 = new PuntoPoker();
        PuntoPoker p2 = new PuntoPoker();
        
        p1.distinguiPunti(mano1);
        p2.distinguiPunti(mano2);
        
        Giocatore g1 =new Giocatore("Player1",mano1,p1);
        Giocatore g2 = new Giocatore("Palyer2",mano2,p2);
        
        ConfrontaPunteggio CP = new ConfrontaPunteggio();
        
        CP.inserisciDueGiocatori(g1, g2);
        
        Giocatore giocatoreVincente = CP.trovaGiocatoreVincente(CP);
        
        System.out.println(giocatoreVincente.getNomegiocatore());
        
        
        
        
        
       
    }
    
}
