/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new;

/**
 *
 * @author gianf
 */
public class Asso extends Carta {

    private final String nomeAsso;
    
    public Asso(boolean verificaCartaPescata, String seme, int numero) {
        super(verificaCartaPescata, seme, numero);
        this.nomeAsso = "Asso";
    }
    
   
  @Override
    public String toString() {
        return this.nomeAsso + " " + getSeme() + "\n"; // Aggiungi altri dettagli se necessario
    }
}

