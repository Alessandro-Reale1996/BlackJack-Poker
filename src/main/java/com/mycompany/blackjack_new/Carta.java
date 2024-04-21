/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_new;

/**
 *
 * @author Siam1838
 */
public class Carta implements Comparable<Carta> {
    
    protected boolean verificaCartaPescata;
    protected String seme;
    protected int numero;

    public Carta(boolean verificaCartaPescata, String seme, int numero) {
        this.verificaCartaPescata = verificaCartaPescata;
        this.seme = seme;
        this.numero = numero;
    }

    public boolean getVerificaCartaPescata() {
        return verificaCartaPescata;
    }

    public void setVerificaCartaPescata(boolean verificaCartaPescata) {
        this.verificaCartaPescata = verificaCartaPescata;
    }

    
  

    public String getSeme() {
        return seme;
    }

    public int getNumero() {
        return numero;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
      return numero+" "+seme+"\n";
      
    }

    @Override
    public int compareTo(Carta other) {
        return Integer.compare(this.numero, other.numero);
    }
   
    
}
