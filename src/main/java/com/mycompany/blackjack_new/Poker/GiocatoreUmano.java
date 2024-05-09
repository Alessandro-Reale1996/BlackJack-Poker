/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import com.mycompany.blackjack_new.Carta;
import com.mycompany.blackjack_new.Mano;
import java.util.Scanner;

/**
 *
 * @author Siam1838
 */
/*
Classe che ha l'unico scopo di non dover fare due arraylist, una con il giocatore umano e una senza
*/
public class GiocatoreUmano extends Giocatore {

    public GiocatoreUmano() {
    }

    public GiocatoreUmano(String nomegiocatore, int ammontale) {
        super(nomegiocatore, ammontale);
    }

    

    public GiocatoreUmano(String nomegiocatore, Mano mano, PuntoPoker puntoPoker)
    {
        super(nomegiocatore, mano, puntoPoker);
    }
    
    //Metodo per far rilanciare giocatore umano 
    public void rilancioGiocatoreUmano(Giocatore giocatore, Piatto piatto)
    {
        boolean inputvalido = false;
        do
        {
            Scanner scanner = new Scanner(System.in);       
            System.out.println("Quanto vuoi puntare?");
            try
            {
                int input = scanner.nextInt();
                if(input>=giocatore.getAmmontale())
                {
                    //PROBLEMA FITTIZIO
                    for(Carta carta : giocatore.getMano().getMano())
                    {
                        giocatore.getMano().getMano().remove(carta);
                    }
                }
                giocatore.setRilancioGiocatore(input);
                giocatore.setAmmontale(giocatore.getAmmontale()-input);
                piatto.setAmmontalePiatto(piatto.getAmmontalePiatto()+input);
                inputvalido=true;
            }
            catch(Exception e)
            {
                System.out.println("Input non valido o quantità rilanciata superiore all'ammontale.");
            }
        }while(!inputvalido);
    }

    public void check() {
       this.rilancioGiocatore=0;
        this.rilancioGiocatoreNoCompensazione=0;
    }

}
