/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new;

/**
 *
 * @author Siam1838
 */
public class Mazziere 
{
    public void manoMazziere(Mazzo mazzo,Mano mano)
    {
 
        while(true)
        {
            if(mano.sumMano()<=14)
            {
            Carta carta= mazzo.estraiCarta(mazzo);
            mano.addCartaAsso(carta,mano);
            }
            else
            {
                break;
            }
        }
        
        
    }
}
