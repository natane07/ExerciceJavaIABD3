package prog;

public class Main {
    public static void main(String[] args) {
        try {
            if(args.length < 2) {
                System.out.println("Erreur arg inférieur à 2");
                return;
            }
            Alphabet alphabet = new Alphabet();
            alphabet.setAlphabet(args[0]); // Init alphabet
            alphabet.setWord(args[1]); // Init word
            Alphabet.leftRotate(1, args[0]);
            Alphabet.rightRotate(1, args[0]);
            // Option
            for (int i=2; i<args.length; i++){
                if(Alphabet.checkOption(args[i])){
                    alphabet.addParamToList(args[i]);
                    continue;
                }
                alphabet.execParam(args[i]);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}
