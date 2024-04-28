/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new;

import java.util.Scanner;
import com.mycompany.blackjack_new.Poker.InputPoker;
/**
 *
 * @author Siam1838
 */
public class Input 
{
    
    public Input() {
        
    }
    
    
    
    
    
    
    public void Blackjack()
    {
        while(true)
        {
        Mazzo mazzo = Mazzo.popolaMazzo();
        
        Scanner scanner = new Scanner(System.in);
        
        
       while (true)
        {
           
           Carta carta = mazzo.estraiCarta(mazzo);
           Mano mano = new Mano();
           mano.addCartaAsso(carta,mano);
           System.out.print("Valore mano: "+ mano.sumMano()+"\n");
           mano.mostraMano();
           
           
           while(mano.sumMano()<21)
           {
            System.out.println("1-Chiedi carta 2-Stai");
            String input = scanner.nextLine();
            if(input.equals("1"))
            {
               carta = mazzo.estraiCarta(mazzo);
               mano.addCartaAsso(carta,mano);
                System.out.print("Valore mano: "+ mano.sumMano()+"\n");
                mano.mostraMano();
            }
            else
            {
                if(input.equals("2"))
                {
                   break; 
                }
                else
                {
                    System.out.println("input non valido");
                }
                   
            }
            }
            if (mano.sumMano()>21)
            {
                System.out.println("Hai sballato!");
                break;
            }
            else
            {
                Mazziere mazziere = new Mazziere();
                Mano manomazziere = new Mano();
                mazziere.manoMazziere(mazzo,manomazziere);
                if(manomazziere.sumMano()>21)
                {
                    System.out.println("Il mazziere ha sballato");
                    break;
                }
                else
                {
                  if(mano.sumMano()>manomazziere.sumMano())
                  {
                      System.out.println("Mano mazziere:");
                      System.out.println("Valora mano mazziere: "+manomazziere.sumMano());
                      manomazziere.mostraMano();
                      System.out.println("hai vinto!");
                      break;
                      
                  }
                  else
                  {     
                      System.out.println("Mano mazziere:");
                      System.out.println(" ");
                      System.out.println("Valora mano mazziere: "+manomazziere.sumMano());
                      manomazziere.mostraMano();
                      System.out.println("Hai perso!");
                      break;
                  }
                }    
              }
            }
            boolean continua = false;
            while(true)
            {
            System.out.println("Vuoi giocare ancora? y/n");
            String input = scanner.nextLine();
            
            if(input.matches("y"))
            {
                continua=true;
               break;
            }
            else
            {
                if(input.matches("n"))
                {
                    break;
                }
                else
                {
                    System.out.println("input non valido");
                }
            
            }
            }
        if (continua == false)
        {
        break;   
        }
        }
    }
    
    public void Poker()
    {
       InputPoker inputpoker = new InputPoker();
       inputpoker.poker();
    }
    
}


