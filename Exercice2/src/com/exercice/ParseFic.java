package com.exercice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseFic {
    public HashMap readFile(){
        HashMap<String,Integer> mapValue = new HashMap<>() ;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("test.txt"));
        } catch (FileNotFoundException err) {
            System.out.println("Fichier inéxistant" + err.getMessage());
        }
        String line;
            try {
                while((line = reader.readLine()) != null){
                    String[] value = line.split(":");
                    mapValue.put(value[0],Integer.parseInt(value[1])) ;
                }
            } catch (IOException e) {
                System.out.println("Erreur lecture fichier");
                e.printStackTrace();
            }
        return mapValue;
    }

    public double moyen(HashMap map) {
        ArrayList<Integer> list = new ArrayList<Integer>(map.values());
        int somme = 0;
        int numberNote = 0;
        for (Integer value : list) {
            somme += value;
            numberNote++;
        }
        return somme = somme/numberNote;
    }

    static public Integer score(HashMap map, String mail) {
        Integer score = 0;
        if (map.get(mail) != null) {
            score = (Integer) map.get(mail);
        }
        return score;
    }
}
