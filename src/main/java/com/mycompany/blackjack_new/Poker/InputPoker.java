/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import com.mycompany.blackjack_new.Mano;
import com.mycompany.blackjack_new.Mazzo;
import java.util.ArrayList;
import java.util.Iterator;
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
            GiocatoreUmano g1 =new GiocatoreUmano("Player1",100);
            Giocatore g2 = new Giocatore("Palyer2",100);
            Giocatore g3 =new Giocatore("Player3",100);
            Giocatore g4 = new Giocatore("Player4",100);
            Giocatore g5 =new Giocatore("Player5",100);


        while(true)
        {
            //All'inizio di ogni turno creo la lista partita
            ArrayList<Giocatore> giocatori = new ArrayList<>();
            
            /*All'inizio di ogni mano aggiungo i giocatori, se questi hanno un ammontale minore di 5
            vengono eliminati dal Arraylist giocatori di modo che non possano partecipare alla mano.*/
            giocatori.add(g1);
            giocatori.add(g2);
            giocatori.add(g3);
            giocatori.add(g4);
            giocatori.add(g5);
            
             Iterator<Giocatore> iterator = giocatori.iterator();
                
                while(iterator.hasNext())
                {
                    Giocatore giocatore = iterator.next();
                    if(giocatore.getAmmontale()<= 5)
                    {
                        iterator.remove();
                    }
                }
            
            while(true)
            {
                //inizializiamo il piatto
                Piatto piatto = new Piatto();
                //popoliamolo
                piatto.PololaPiattoInizioRound(giocatori);
                //inzializamo il mazzo e popoliamolo
                Mazzo mazzo = Mazzo.popolaMazzo();
                //Creaiamo le mani
                for(Giocatore giocatore : giocatori)
                {
                    giocatore.mano=new Mano();
                }              
                
                //popoliamole
                for(Giocatore giocatore : giocatori){
                    for(int i =0;i<5;i++)
                    {
                        giocatore.mano.addCartaAsso(mazzo.estraiCarta(mazzo), giocatore.mano);
                    }
                }

                //Creaiamo il punto-poker
                for(Giocatore giocatore : giocatori)
                {
                    giocatore.puntoPoker =  new PuntoPoker();
                }
                
                //distinguiamo il punto
                for(Giocatore giocatore : giocatori)
                {
                    giocatore.puntoPoker.distinguiPunti(giocatore.getMano());
                }
                

                /* Qui verrano mostrtate le carte al giocatore, dovrebbero essere numerate 
                di modo che, in un secondo momento, sarà possibile distinguerle in face si cambio
                */
                System.out.println("\nLa tua mano:");
                g1.getMano().mostraMano();
                //qui si mostra l'ammontale
                System.out.println("\nIl tuo ammontale:");
                System.out.println(g1.getAmmontale());

                //Prima fase di rilancio
                FaseRilancio faserilancio = new FaseRilancio();
                faserilancio.faseRilancio(piatto, giocatori, g1);

                //Se il giocatore non ha foldato durante la fase di rilancio.
                if(!faserilancio.fold)
                {
                    /*Diamo la possibilità di cambiare carta, prima chiedendo di cambiare, poi con uno swich si sceglierà
                    la carta,dovrebbe essere tutto contornato da un ciclo while. 
                    */
                    while(true)
                    {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Vuoi cambiare? y/n");
                        String inputCambio= scanner.nextLine();
                        if(inputCambio.equals("y"))
                        {
                            while(true)
                            {
                                System.out.println("Che carte vuoi cambiare? (la virgola è il carattere separatore)");
                                inputCambio= scanner.nextLine();
                                //divido la stirnga e metto il risultato in un Array con un ciclo "for"
                                StringTokenizer tokenizer = new StringTokenizer(inputCambio,",");
                                ArrayList<String> arraytokens = new ArrayList<>();
                                try
                                {
                                    for(int i=0;i<tokenizer.countTokens();i++) //Non ho capito perchè il "+2"
                                    {
                                        arraytokens.add(tokenizer.nextToken());
                                    }
                                    for(String tokens : arraytokens)
                                    {
                                        switch(tokens)
                                        {
                                            case "1":

                                                g1.mano.cambiaCartaGiocatore(g1.mano.getMano().get(0),mazzo,0);
                                                break;
                                            case "2":

                                                g1.mano.cambiaCartaGiocatore(g1.mano.getMano().get(1),mazzo,1);
                                                break;
                                            case "3":

                                                g1.mano.cambiaCartaGiocatore(g1.mano.getMano().get(2),mazzo,2);
                                                break;
                                            case "4":

                                                g1.mano.cambiaCartaGiocatore(g1.mano.getMano().get(3),mazzo,3);
                                                break;
                                            case "5":

                                                g1.mano.cambiaCartaGiocatore(g1.mano.getMano().get(4),mazzo,4);
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
                            g1.mano.mostraMano();
                            break;   
                        }
                        else if(inputCambio.equals("n"))
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Input non valido");
                        }
                    }


                    CambiaCarte cambiaCarte2 = new CambiaCarte();
                    CambiaCarte cambiaCarte3 = new CambiaCarte();
                    CambiaCarte cambiaCarte4= new CambiaCarte();
                    CambiaCarte cambiaCarte5 = new CambiaCarte();

                    cambiaCarte2.cambiaCarte(g2, mazzo);
                    cambiaCarte3.cambiaCarte(g3, mazzo);
                    cambiaCarte4.cambiaCarte(g4, mazzo);
                    cambiaCarte5.cambiaCarte(g5, mazzo);


                    //qui si mostra l'ammontale
                    System.out.println("\nIl tuo ammontale:");
                    System.out.println(g1.getAmmontale());

                    //Distinguiamo di nuovo i punti
                   for(Giocatore giocatore : giocatori)
                    {
                        giocatore.puntoPoker.distinguiPunti(giocatore.getMano());
                    }

                    //Seconda fase di rilancio
                    FaseRilancio faserilancio2 = new FaseRilancio();
                    faserilancio2.faseRilancio(piatto, giocatori, g1);
                }
                
                //se il giocatore ha foldato durante la fase di rilancio
                else
                {
                    FaseRilancioAutomatica.faseRilancioAutomatica(piatto, giocatori);
                    
                }
                ConfrontaPunteggio CP = new ConfrontaPunteggio();

                CP.setConfrontapunteggio(giocatori);

                Giocatore giocatoreVincente = CP.trovaGiocatoreVincente(CP);
                
                //mostriamo le mani dei giocatori ancora in gioco
                for(Giocatore giocatore : giocatori)
                {
                    System.out.println("\n"+giocatore.nomegiocatore);
                    giocatore.mano.mostraMano();
                }
                
                
                
                System.out.println("\nIl vincitore è:");
                System.out.println(giocatoreVincente.getNomegiocatore()); 
                piatto.vincitaGiocatore(giocatoreVincente);
                
                break;
            } 
            if (g1.getAmmontale()<=5)
            {
                System.out.println("Hai perso.");
                break;               
            }
            else if(g1.getAmmontale()>=490)
            {
                System.out.println("Hai vinto!");
                break;        
            }
        }
    }

}  
    
    

