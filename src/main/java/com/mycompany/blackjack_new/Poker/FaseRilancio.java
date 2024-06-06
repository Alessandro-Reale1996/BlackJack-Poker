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
    // proprietà fold
    protected boolean fold;

    public FaseRilancio() 
    {
        this.fold= false;
    }
     
    public void faseRilancio(Piatto piatto, ArrayList<Giocatore> giocatori,GiocatoreUmano g1)
    {
        // Qui si dà la possibilità al giocatore di rilanciare o check 1
        /*TODO: Necessita ancora della possibilità di "foldare" a GiocatoreUmano
        ,la quale è già stata implementata in rialncioAutomatico() di Giocatore*/
                boolean rispostaValida = false;
                do
                {   int count = 0;
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Vuoi rilanciare, check o fold? r/c/f");
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
                                giocatori.get(i).rilancioAuto(giocatori.get(i), piatto,giocatori));   
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
                                        giocatori.get(i).rilancioAuto(giocatori.get(i), piatto,giocatori));   
                                
                                System.out.println(giocatori.get(i).getNomegiocatore()+"Rilancoogiocatore "+giocatori.get(i).getRilancioGiocatore());
                                piatto.setRilancioGeneralePerGiocatore(giocatori);
                            }
                            break;
                        case "f":
                            //risposta valida
                            rispostaValida=true;
                            
                            //metodo fold, e fold=true
                            g1.fold(giocatori, g1);
                            this.fold= true;
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
                    
                }while((!piatto.RilancioGiocatoreUgualeRilancioGenerale(giocatori) || !rispostaValida) && !this.fold );
    }
    
}
