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

            ArrayList<Giocatore> giocatori = new ArrayList<>();

            giocatori.add(g1);
            giocatori.add(g2);
            giocatori.add(g3);
            giocatori.add(g4);
            giocatori.add(g5);

        while(true)
        {
            while(true)
            {
                //inizializiamo il piatto
                Piatto piatto = new Piatto();
                //popoliamolo
                piatto.PololaPiattoInizioRound(giocatori);
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


                g1.setPuntoPoker(p1);
                g2.setPuntoPoker(p2);
                g3.setPuntoPoker(p3);
                g4.setPuntoPoker(p4);
                g5.setPuntoPoker(p5);

                g1.setMano(mano1);
                g2.setMano(mano2);
                g3.setMano(mano3);
                g4.setMano(mano4);
                g5.setMano(mano5);
                

                /* Qui verrano mostrtate le carte al giocatore, dovrebbero essere numerate 
                di modo che, in un secondo momento, sarà possibile distinguerle in face si cambio
                */
                System.out.println("\nLa tua mano:");
                g1.getMano().mostraMano();
                //qui si mostra l'ammontale
                System.out.println("\nIl tuo ammontale:");
                System.out.println(g1.getAmmontale());

                // Qui si dà la possibilità al giocatore di rilanciare o check 
                boolean rispostaValida = false;
                do
                {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Vuoi rilanciare o check? r/c");
                    String input= scanner.nextLine();
                    switch (input) 
                    {
                        case "r":
                            rispostaValida=true;
                            // metodo per rilanciare che sarà in GiocatoreUmano
                            g1.rilancioGiocatoreUmano(g1, piatto);
                            for(int i=1;i<giocatori.size();i++)
                            {
                                 //rilancio automatico
                               
                                System.out.println(giocatori.get(i).getNomegiocatore()+" rilancia "+
                                        giocatori.get(i).rilancioAuto(giocatori.get(i), piatto));                              
                            }
                            break;
                        case "c":
                            rispostaValida=true;
                            //Compenso e check
                            System.out.println(g1.compensaRilancioGenerale(piatto));
                            for(int i=1;i<giocatori.size();i++)
                            {
                                //rilancio automatico                               
                                System.out.println(giocatori.get(i).getNomegiocatore()+" rilancia "+
                                        giocatori.get(i).rilancioAuto(giocatori.get(i), piatto));                                 
                            }
                            break;
                        default:
                            System.out.println("imput non valido");
                            break;
                    }
                    //TODO: c'è un problema in questo while(credo sia di ordine logico)
                }while(!piatto.unGiocatoreMenoRilancioGenerale(giocatori, piatto) || !rispostaValida );

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

                 // Qui si dà la possibilità al giocatore di rilanciare o check II volta
                rispostaValida = false;
                do
                {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Vuoi rilanciare o check? r/c");
                    String input= scanner.nextLine();
                    switch (input) 
                    {
                        case "r":
                            //TODO: problema se rilancio,Bho!
                            rispostaValida=true;
                            // metodo per rilanciare che sarà in GiocatoreUmano
                            g1.rilancioGiocatoreUmano(g1, piatto);
                            for(int i=1;i<giocatori.size();i++)
                            {
                                //rilancio automatico
                                System.out.println(giocatori.get(i).getNomegiocatore()+" ha rilanciato "+
                                        giocatori.get(i).rilancioAuto(giocatori.get(i), piatto));
                            }
                            break;
                        case "c":
                            rispostaValida=true;
                            //Compenso e check
                            g1.compensaRilancioGenerale(piatto);
                            for(int i=1;i<giocatori.size();i++)
                            {
                                //rilancio automatico
                                System.out.println(giocatori.get(i).getNomegiocatore()+" ha rilanciato "+
                                        giocatori.get(i).rilancioAuto(giocatori.get(i), piatto));
                            }
                            break;
                        default:
                            System.out.println("imput non valido");
                            break;
                    }
                   
                }while(!piatto.unGiocatoreMenoRilancioGenerale(giocatori, piatto) || !rispostaValida);

                p1.distinguiPunti(mano1);
                p2.distinguiPunti(mano2);
                p3.distinguiPunti(mano3);
                p4.distinguiPunti(mano4);
                p5.distinguiPunti(mano5);

                g1.setPuntoPoker(p1);
                g2.setPuntoPoker(p2);
                g3.setPuntoPoker(p3);
                g4.setPuntoPoker(p4);
                g5.setPuntoPoker(p5);

                ConfrontaPunteggio CP = new ConfrontaPunteggio();

                CP.setConfrontapunteggio(giocatori);

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
                
                System.out.println("\nIl vincitore è:");
                System.out.println(giocatoreVincente.getNomegiocatore()); 
                piatto.vincitaGiocatore(giocatoreVincente);
                
                Iterator<Giocatore> iterator = giocatori.iterator();
                
                while(iterator.hasNext())
                {
                    Giocatore giocatore = iterator.next();
                    if(giocatore.getAmmontale()<= 5)
                    {
                        iterator.remove();
                    }
                }

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
    
    

