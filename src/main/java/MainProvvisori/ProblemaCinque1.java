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
public class ProblemaCinque1 {
    
    public static void main(String[] args)
    {
        
         // Creazione della mano 1
        Mano mano1 = new Mano();
        Carta carta1_1 = new Carta(false, "Picche", 9);
        Carta carta1_2 = new Carta(false, "Cuori", 1); // Assumo che "Asso Cuori" sia Asso
        Carta carta1_3 = new Carta(false, "Quadri", 11);
        Carta carta1_4 = new Carta(false, "Cuori", 13);
        Carta carta1_5 = new Carta(false, "Picche", 8);

        mano1.addCartaAsso(carta1_1, mano1);
        mano1.addCartaAsso(carta1_2, mano1);
        mano1.addCartaAsso(carta1_3, mano1);
        mano1.addCartaAsso(carta1_4, mano1);
        mano1.addCartaAsso(carta1_5, mano1);

        // Creazione della mano 2
        Mano mano2 = new Mano();
        Carta carta2_1 = new Carta(false, "Quadri", 13);
        Carta carta2_2 = new Carta(false, "Quadri", 12);
        Carta carta2_3 = new Carta(false, "Fiori", 12);
        Carta carta2_4 = new Carta(false, "Picche", 2);
        Carta carta2_5 = new Carta(false, "Quadri", 3);

        mano1.addCartaAsso(carta2_1, mano2);
        mano1.addCartaAsso(carta2_2, mano2);
        mano1.addCartaAsso(carta2_3, mano2);
        mano1.addCartaAsso(carta2_4, mano2);
        mano1.addCartaAsso(carta2_5, mano2);

        // Creazione della mano 3
        Mano mano3 = new Mano();
        Carta carta3_1 = new Carta(false, "Picche", 10);
        Carta carta3_2 = new Carta(false, "Picche", 13);
        Carta carta3_3 = new Carta(false, "Quadri", 1); // Assumo che "Asso Quadri" sia Asso
        Carta carta3_4 = new Carta(false, "Fiori", 2);
        Carta carta3_5 = new Carta(false, "Fiori", 7);

        mano1.addCartaAsso(carta3_1, mano3);
        mano1.addCartaAsso(carta3_2, mano3);
        mano1.addCartaAsso(carta3_3, mano3);
        mano1.addCartaAsso(carta3_4, mano3);
        mano1.addCartaAsso(carta3_5, mano3);

        // Creazione della mano 4
        Mano mano4 = new Mano();
        Carta carta4_1 = new Carta(false, "Quadri", 7);
        Carta carta4_2 = new Carta(false, "Fiori", 4);
        Carta carta4_3 = new Carta(false, "Fiori", 6);
        Carta carta4_4 = new Carta(false, "Quadri", 4);
        Carta carta4_5 = new Carta(false, "Picche", 1); // Assumo che "Asso Picche" sia Asso

        mano1.addCartaAsso(carta4_1, mano4);
        mano1.addCartaAsso(carta4_2, mano4);
        mano1.addCartaAsso(carta4_3, mano4);
        mano1.addCartaAsso(carta4_4, mano4);
        mano1.addCartaAsso(carta4_5, mano4);

        // Creazione della mano 5
        Mano mano5 = new Mano();
        Carta carta5_1 = new Carta(false, "Picche", 6);
        Carta carta5_2 = new Carta(false, "Picche", 12);
        Carta carta5_3 = new Carta(false, "Cuori", 5);
        Carta carta5_4 = new Carta(false, "Quadri", 6);
        Carta carta5_5 = new Carta(false, "Cuori", 9);

        mano1.addCartaAsso(carta5_1, mano5);
        mano1.addCartaAsso(carta5_2, mano5);
        mano1.addCartaAsso(carta5_3, mano5);
        mano1.addCartaAsso(carta5_4, mano5);
        mano1.addCartaAsso(carta5_5, mano5);

        
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
        Giocatore g4 = new Giocatore("Palyer4",mano4,p4);
        Giocatore g5 =new Giocatore("Player5",mano5,p5);
        
        
        ConfrontaPunteggio CP = new ConfrontaPunteggio();
        
        CP.inserisciGiocatori(g1, g2, g3, g4, g5);
        
        Giocatore giocatoreVincente = CP.trovaGiocatoreVincente(CP);
        
        System.out.println(giocatoreVincente.getNomegiocatore()); 
    }
    
}
