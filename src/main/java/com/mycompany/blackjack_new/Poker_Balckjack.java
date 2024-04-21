/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.blackjack_new;

import java.util.Scanner;

/**
 *
 * @author Siam1838
 */
public class Poker_Balckjack {

    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("A cosa vuoi giocare?\n1-Blackjack 2-Poker\n3-Esci");
            String input = scanner.nextLine();
            Input i= new Input();
            switch (input) {
                case "1":
                    i.Blackjack();
                    break;
                case "2":
                    i.Poker();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Input non valido");
                    break;
            }
        }
    }
}
