/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainProvvisori;

import com.mycompany.blackjack_new.Carta;
import com.mycompany.blackjack_new.Mano;
import com.mycompany.blackjack_new.Mazzo;
import com.mycompany.blackjack_new.Poker.CambiaCarte;
import com.mycompany.blackjack_new.Poker.ConfrontaPunteggio;
import com.mycompany.blackjack_new.Poker.Giocatore;
import com.mycompany.blackjack_new.Poker.PuntoPoker;

/**
 *
 * @author Siam1838
 */
public class ProblemaCinqueTemplates {
    
    public static void main(String[] args)
    {
        Mazzo mazzo = new Mazzo();
        
       Mano mano1 = new Mano();
        Carta carta1_1 = new Carta(false, "Fiori", 9);
        Carta carta1_2 = new Carta(false, "Quadri", 10);
        Carta carta1_3 = new Carta(false, "Cuori", 12);
        Carta carta1_4 = new Carta(false, "Quadri", 2);
        Carta carta1_5 = new Carta(false, "Picche", 2);

        mano1.addCartaAsso(carta1_1, mano1);
        mano1.addCartaAsso(carta1_2, mano1);
        mano1.addCartaAsso(carta1_3, mano1);
        mano1.addCartaAsso(carta1_4, mano1);
        mano1.addCartaAsso(carta1_5, mano1);

        
        
        System.out.println("\nMano1");
        mano1.mostraMano();
      
        
        
        
        PuntoPoker p1 = new PuntoPoker();
    
        
        p1.distinguiPunti(mano1);
       
        
        
        Giocatore g1 =new Giocatore("Player1",mano1,p1);

        
        CambiaCarte cambiaCarte = new CambiaCarte();
        
        
        cambiaCarte.cambiaCarte(g1, mazzo);
     
        
        
        
        System.out.println("\nMano1 Dopo cambio");
        mano1.mostraMano();
      
        
        
        
        
        ConfrontaPunteggio CP = new ConfrontaPunteggio();
        
        CP.inserisciUnGiocatori(g1);
        
        Giocatore giocatoreVincente = CP.trovaGiocatoreVincente(CP);
        
        System.out.println(giocatoreVincente.getNomegiocatore()); 
    }
    
}
