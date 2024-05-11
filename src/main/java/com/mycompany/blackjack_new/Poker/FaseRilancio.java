/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gianf
 */
public class FaseRilancio {
    //TODO: per qualche ragione la compensazione non funzione
    //(non tiene conto di quanto si è compensato nel turno precedente).
    public static void faseRilancio(Piatto piatto, ArrayList<Giocatore> giocatori,GiocatoreUmano g1)
    {
        // Qui si dà la possibilità al giocatore di rilanciare o check 1
                boolean rispostaValida = false;
                do
                {   int count = 0;
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Vuoi rilanciare o check? r/c");
                    String input= scanner.nextLine();
                    switch (input) 
                    {
                        case "r":
                            rispostaValida=true;
                            //prima di tutto il giocatore compensa
                            System.out.println(g1.compensaRilancioGenerale(piatto));
                            // metodo per rilanciare che sarà in GiocatoreUmano
                            g1.rilancioGiocatoreUmano(g1, piatto);
                            piatto.setRilancioGeneralePerGiocatore(giocatori);
                            System.out.println("\nRilancio giocatore: "+g1.getRilancioGiocatore());
                            for(int i=1;i<giocatori.size();i++)
                            {
                                 //rilancio automatico
                               
                                System.out.println(giocatori.get(i).getNomegiocatore()+" rilancia "+
                                giocatori.get(i).rilancioAuto(giocatori.get(i), piatto));   
                                piatto.setRilancioGeneralePerGiocatore(giocatori);
                                
                                System.out.println(giocatori.get(i).getNomegiocatore()+"Rilancoogiocatore "+giocatori.get(i).getRilancioGiocatore());
                            }
                            break;
                        case "c":
                            rispostaValida=true;
                            //Compenso e check
                            System.out.println(g1.compensaRilancioGenerale(piatto));
                            g1.check();
                            piatto.setRilancioGeneralePerGiocatore(giocatori);
                            
                            for(int i=1;i<giocatori.size();i++)
                            {
                                //rilancio automatico                               
                                System.out.println(giocatori.get(i).getNomegiocatore()+" rilancia "+
                                        giocatori.get(i).rilancioAuto(giocatori.get(i), piatto));   
                                
                                System.out.println(giocatori.get(i).getNomegiocatore()+"Rilancoogiocatore "+giocatori.get(i).getRilancioGiocatore());
                                piatto.setRilancioGeneralePerGiocatore(giocatori);
                            }
                            break;
                        default:
                            System.out.println("imput non valido");
                            break;
                    }
                    piatto.nessunoHaRilanciato(giocatori);
                    System.out.println("\nRilancio generale "+piatto.rilancioGenerale);
                    System.out.println("\nAmmnontale piatto "+piatto.ammontalePiatto);
                    
                    if(count == 6)
                    {
                        System.out.println("Raggiunto massimo di puntate in questa fase");
                        for (Giocatore giocatore:giocatori)
                        {
                            giocatore.check(piatto);
                            giocatore.rilancioGiocatore = 0;
                            giocatore.rilancioGiocatoreNoCompensazione = 0;
                        }
                    }
                    else
                    {
                        count++;
                    }
                    
                }while(!piatto.RilancioGiocatoreUgualeRilancioGenerale(giocatori) || !rispostaValida );
    }
    
}
