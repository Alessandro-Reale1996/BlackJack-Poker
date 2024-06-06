/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new.Poker;

import java.util.ArrayList;

/**
 *
 * @author gianf
 */
public class FaseRilancioAutomatica {
    //TODO: Risolvere problema di Loop Infinito
    public static void faseRilancioAutomatica(Piatto piatto, ArrayList<Giocatore> giocatori)
    {
        do
        {
            for(int i=1; i<giocatori.size(); i++)
            {
                giocatori.get(i).rilancioAuto(giocatori.get(i), piatto, giocatori);
                piatto.setRilancioGeneralePerGiocatore(giocatori);

            }
        }while(!piatto.RilancioGiocatoreUgualeRilancioGenerale(giocatori));
    }
    
}
