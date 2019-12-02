package com.exercice;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public  static void main(String [] args ){
        Instant start = Instant.now();
        ParseFic file = new ParseFic();
        Scanner scan = new Scanner(System.in);
        HashMap map = new HashMap<>();
        map = file.readFile();
        System.out.println("Mail ?");
        String mail = scan.nextLine();

        System.out.println("\nMoyen " + file.moyen(map));
        System.out.println("\nScore de " + mail + ": " + file.score(map, mail));

        // Partie 3
        Duration duration = Duration.between(start, Instant.now());
        System.out.print("\nTemps d'execution du programme: " + duration.getSeconds() + " s");
    }

}
