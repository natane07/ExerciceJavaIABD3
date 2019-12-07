package prog;

import java.util.ArrayList;
import java.util.Arrays;

public class Alphabet {
    private ArrayList<Character> alphabet = new ArrayList<Character>();
    private String word;
    private ArrayList<String> param = new ArrayList<String>();

    public void setAlphabet(String alphabet) {
        for(char character : alphabet.toCharArray()) {
            this.alphabet.add(character);
        }
    }

    public void setWord(String word) throws Exception {
        if(!this.checkWord(word)) {
            throw new Exception("Incorrect syntaxe word");
        }
        else {
            this.word = word;
        }
    }

    private boolean checkWord(String word) {
        for(char c : word.toCharArray()){
            if(!this.alphabet.contains(c))
                return false;
        }
        return true;
    }

    public static String leftRotate(int nbRotate, String word) {
        if(nbRotate < word.length()) {
            String wordRotate = word.substring(nbRotate, word.length()) + word.substring(0, nbRotate);
            System.out.println("leftRotate: " + wordRotate);
            return wordRotate;
        }
        return word;
    }

    public static String rightRotate(int nbRotate, String word) {
        if(nbRotate < word.length()) {
            // String wordRotate = word.substring(0, nbRotate) + word.substring(nbRotate, word.length());
            String wordRotate = word.substring(word.length() - nbRotate) + word.substring(0, word.length() - nbRotate);
            System.out.println("rightRotate: " + wordRotate);
            return wordRotate;
        }
        return word;
    }

    public static boolean checkOption(String word){
        if(word.substring(0,1).equals("/")){
            return true;
        }
        return false;
    }

    public void addParamToList(String param){
        this.param.add(param);
    }

    public void execParam(String word) {
        String lastOption = this.param.get(this.param.size() - 1);
        if (lastOption.compareTo("/a") == 0) {
            if(this.checkIsAnagramme(this.word, word))
                System.out.println("param /a " + this.word + " et " + word + " sont des anagrammes");
            else
                System.out.println(this.word + " et " + word + " ne sont pas des anagrammes");
        } else if (lastOption.compareTo("/o") == 0) {
            System.out.println("param /o " + this.word + " et " + word + " devient : " + this.rechercheWordDelete(this.word, word));
        }
    }

    private static boolean checkIsAnagramme(String word, String wordAnagramme){
        if (word.length() != wordAnagramme.length())
            return false;
        char[] arrayWord = word.toLowerCase().toCharArray();
        char[] arrayAnagramme = wordAnagramme.toLowerCase().toCharArray();
        Arrays.sort(arrayWord);
        Arrays.sort(arrayAnagramme);
        return Arrays.equals(arrayWord, arrayAnagramme);
    }

    public String rechercheWordDelete(String word, String wordDelete) {
        if(wordDelete.length() > word.length() || !word.contains(wordDelete))
            return word;
        int indexWordDelete = word.indexOf(wordDelete);
        return word.substring(0, indexWordDelete) + word.substring(indexWordDelete + wordDelete.length(), word.length());
    }
}
