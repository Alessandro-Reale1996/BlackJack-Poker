/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import com.mycompany.blackjack_new.Mano;
import com.mycompany.blackjack_new.Mazzo;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author gianf
 */
public class InputPoker 
{
        public void poker()
    {
        //inzializamo il mazzo
        Mazzo mazzo =new Mazzo();
        //popoliamolo
        mazzo = Mazzo.popolaMazzo();
        //Creaiamo le mani
        Mano mano1 = new Mano();
        Mano mano2 = new Mano();
        Mano mano3 = new Mano();
        Mano mano4 = new Mano();
        Mano mano5 = new Mano();
        //popoliamole

        for(int i =0;i<5;i++)
        {
            mano1.addCartaAsso(mazzo.estraiCarta(mazzo), mano1);
            mano2.addCartaAsso(mazzo.estraiCarta(mazzo), mano2);
            mano3.addCartaAsso(mazzo.estraiCarta(mazzo), mano3);
            mano4.addCartaAsso(mazzo.estraiCarta(mazzo), mano4);
            mano5.addCartaAsso(mazzo.estraiCarta(mazzo), mano5);
        }

        /* Qui verrano mostrtate le carte al giocatore, dovrebbero essere numerate 
        di modo che, in un secondo momento, sarà possibile distinguerle in face si cambio
        */
        mano1.mostraMano();

        /*Diamo la possibilità di cambiare carta, prima chiedendo di cambiare, poi con uno swich si sceglierà
        la carta,dovrebbe essere tutto contornato da un ciclo while. 
        !!!Bisogna trovare un modo di far cambiare quante carte si vuole, ma una sola volta!!!
        */
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vuoi cambiare? y/n");
            String input= scanner.nextLine();
            if(input.equals("y"))
            {
                while(true)
                {
                    System.out.println("Che carte vuoi cambiare? (la virgola è il carattere separatore");
                    input= scanner.nextLine();
                    //divido la stirnga e metto il risultato in un Array con un ciclo "for"
                    StringTokenizer tokenizer = new StringTokenizer(input,",");
                    ArrayList<String> arraytokens = new ArrayList<>();
                    try
                    {
                        for(int i=0;i<=tokenizer.countTokens()+2;i++) //Non ho capito perchè il "+2"
                        {
                            arraytokens.add(tokenizer.nextToken());
                        }
                        for(String tokens : arraytokens)
                        {
                            switch(tokens)
                            {
                                case "1":
                                    
                                    mano1.cambiaCartaGiocatore(mano1.getMano().get(0),mazzo,0);
                                    break;
                                case "2":
                                    
                                    mano1.cambiaCartaGiocatore(mano1.getMano().get(1),mazzo,1);
                                    break;
                                case "3":
                                    
                                    mano1.cambiaCartaGiocatore(mano1.getMano().get(2),mazzo,2);
                                    break;
                                case "4":
                                    
                                    mano1.cambiaCartaGiocatore(mano1.getMano().get(3),mazzo,3);
                                    break;
                                case "5":
                                    
                                    mano1.cambiaCartaGiocatore(mano1.getMano().get(4),mazzo,4);
                                    break;
                                default:
                                    
                                    break;
                            }
                        }
                    break;
                    }
                    catch(Exception e)
                    {
                        System.out.println("Input non valido");
                    }
                }
                mano1.mostraMano();
                break;   
            }
            else if(input.equals("n"))
            {
                break;
            }
            else
            {
                System.out.println("Input non valido");
            }
        }
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
        
        CambiaCarte cambiaCarte2 = new CambiaCarte();
        CambiaCarte cambiaCarte3 = new CambiaCarte();
        CambiaCarte cambiaCarte4= new CambiaCarte();
        CambiaCarte cambiaCarte5 = new CambiaCarte();
        
        cambiaCarte2.cambiaCarte(g2, mazzo);
        cambiaCarte3.cambiaCarte(g3, mazzo);
        cambiaCarte4.cambiaCarte(g4, mazzo);
        cambiaCarte5.cambiaCarte(g5, mazzo);
        
        p2.distinguiPunti(mano2);
        p3.distinguiPunti(mano3);
        p4.distinguiPunti(mano4);
        p5.distinguiPunti(mano5);
        
        ConfrontaPunteggio CP = new ConfrontaPunteggio();
        
        CP.inserisciGiocatori(g1, g2, g3, g4, g5);
        
        Giocatore giocatoreVincente = CP.trovaGiocatoreVincente(CP);
        
        System.out.println("\nGiocatore1");
        mano1.mostraMano();
        System.out.println("\nGiocatore2");
        mano2.mostraMano();
        System.out.println("\nGiocatore3");
        mano3.mostraMano();
        System.out.println("\nGiocatore4");
        mano4.mostraMano();
        System.out.println("\nGiocatore5");
        mano5.mostraMano();
        
        System.out.println(giocatoreVincente.getNomegiocatore()); 
        
        
    }   

}  
    
    

