/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import com.mycompany.blackjack_new.Mano;
import com.mycompany.blackjack_new.Mazzo;
import java.util.Scanner;

/**
 *
 * @author gianf
 */
public class InputPoker {
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
    Scanner scanner = new Scanner(System.in);
        System.out.println("Vuoi cambiare? y/n");
        String input= scanner.nextLine();
        if(input.equals("y"))
        {
            while(true)
            {
                System.out.println("Che carte vuoi cambiare?");
                input= scanner.nextLine();
                switch(input)
                {
                    case "1":
                        mano1.cambiaCarta(mano1.getMano().get(0),mazzo);
                    case "2":
                        mano1.cambiaCarta(mano1.getMano().get(1),mazzo);
                    case "3":
                        mano1.cambiaCarta(mano1.getMano().get(2),mazzo);
                    case "4":
                        mano1.cambiaCarta(mano1.getMano().get(3),mazzo);
                    case "5":
                        mano1.cambiaCarta(mano1.getMano().get(4),mazzo);
                }
                System.out.println("vuoi Cambiare un'altra carta?");
                
            }
        }
        else
        {
            
        }
    
    
    }
    
}
