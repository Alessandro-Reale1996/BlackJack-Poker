/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainProvvisori;

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
public class CinqueGiocatori {
     public static void main(String[] args)
    {
        
        Mazzo mazzo = Mazzo.popolaMazzo();
        Mano mano1 = new Mano();
        Mano mano2 = new Mano();
        Mano mano3 = new Mano();
        Mano mano4 = new Mano();
        Mano mano5 = new Mano();
        
        for (int i=0;i<5;i++)
        {
            mano1.addCartaAsso(mazzo.estraiCarta(mazzo),mano1);
            mano2.addCartaAsso(mazzo.estraiCarta(mazzo), mano2);
            mano3.addCartaAsso(mazzo.estraiCarta(mazzo),mano3);
            mano4.addCartaAsso(mazzo.estraiCarta(mazzo), mano4);
            mano5.addCartaAsso(mazzo.estraiCarta(mazzo),mano5);
            
        }
        
        System.out.println("\nMano1");
        mano1.mostraMano();
        System.out.println("\nMano2");
        mano2.mostraMano();
        System.out.println("\nMano3");
        mano3.mostraMano();
        System.out.println("\nMano4");
        mano4.mostraMano();
        System.out.println("\nMano5");
        mano5.mostraMano();
        
        
        
        PuntoPoker p1 = new PuntoPoker();
        PuntoPoker p2 = new PuntoPoker();
        PuntoPoker p3 = new PuntoPoker();
        PuntoPoker p4 = new PuntoPoker();
        PuntoPoker p5 = new PuntoPoker();
        
        
        p1.distinguiPunti(mano1);
        p2.distinguiPunti(mano2);
        p3.distinguiPunti(mano3);
        p4.distinguiPunti(mano4);
        p5.distinguiPunti(mano5);
        
        
        Giocatore g1 =new Giocatore("Player1",mano1,p1);
        Giocatore g2 = new Giocatore("Palyer2",mano2,p2);
        Giocatore g3 =new Giocatore("Player3",mano3,p3);
        Giocatore g4 = new Giocatore("Player4",mano4,p4);
        Giocatore g5 =new Giocatore("Player5",mano5,p5);
        
        CambiaCarte cambiaCarte1 = new CambiaCarte();
        CambiaCarte cambiaCarte2 = new CambiaCarte();
        CambiaCarte cambiaCarte3 = new CambiaCarte();
        CambiaCarte cambiaCarte4= new CambiaCarte();
        CambiaCarte cambiaCarte5 = new CambiaCarte();
        
        cambiaCarte1.cambiaCarte(g1, mazzo);
        cambiaCarte2.cambiaCarte(g2, mazzo);
        cambiaCarte3.cambiaCarte(g3, mazzo);
        cambiaCarte4.cambiaCarte(g4, mazzo);
        cambiaCarte5.cambiaCarte(g5, mazzo);
        
         p1.distinguiPunti(mano1);
        p2.distinguiPunti(mano2);
        p3.distinguiPunti(mano3);
        p4.distinguiPunti(mano4);
        p5.distinguiPunti(mano5);
        
        System.out.println("\nMano1 C");
        mano1.mostraMano();
        System.out.println("\nMano2 C");
        mano2.mostraMano();
        System.out.println("\nMano3 C");
        mano3.mostraMano();
        System.out.println("\nMano4 C");
        mano4.mostraMano();
        System.out.println("\nMano5 C");
        mano5.mostraMano();
        
        ConfrontaPunteggio CP = new ConfrontaPunteggio();
        
        CP.inserisciGiocatori(g1, g2, g3, g4, g5);
        
        Giocatore giocatoreVincente = CP.trovaGiocatoreVincente(CP);
        
        System.out.println(giocatoreVincente.getNomegiocatore()); 
    }
}
