package pendu;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public final class App {
    private App() {
    }

    public static String choseWord(){
        List<String> word_list = new ArrayList<>();
        int randomNum = ThreadLocalRandom.current().nextInt(0, 6 + 1);
        word_list.add("WORD");
        word_list.add("YOLO");
        word_list.add("FOO");
        word_list.add("MATTHIEU");
        word_list.add("NEW");
        word_list.add("TORTANK");
        word_list.add("SIMPLON");
        return word_list.get(randomNum);
    }

    public static List<String> word(){
        String chosenWord = choseWord();
        List<String> word = new ArrayList<>();

        for (int i = 0; i < chosenWord.length(); i++){
            word.add(Character.toString(chosenWord.charAt(i)));
        }
        return (word);
    }

    public static List<String> blankWord(List<String> word){
        List<String> blank_word = new ArrayList<>();
        for (int i = 0; i < word.size(); i++) {
            blank_word.add("_");
        } 
        return (blank_word);
    }

    public static boolean checkLetter(List<String> word, String letterTry) {
        for(int i = 0; i < word.size(); i++){
            if (word.get(i).charAt(0) == Character.toUpperCase(letterTry.charAt(0))){
                return (true);
            }
        }
        return (false);
    }

    public static void printBlank(List<String> word){
        for (String string : word) {
            System.out.printf(string);
            System.out.printf(" ");
        }
    }

    public static List<String> fillBlank(List<String>blank_word, List<String>word, String letter){
        for(int i = 0; i < word.size(); i++){
            if(word.get(i).charAt(0) == Character.toUpperCase(letter.charAt(0))){
                blank_word.set(i, letter);
            }
        }
        return (blank_word);
    }

    public static boolean isWin(List<String> word){
        int check = 0;
        for (int i = 0; i < word.size(); i++){
            if (word.get(i) == "_"){
                check++;
            }
        }
        if (check > 0) {
            return (false);
        }
        else {
            return (true);
        }
    }

    public static boolean game(List<String> word, List<String> blank_word){
        boolean win = false;
        boolean lose = false;
        int attempt = 7;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println();
        while (!win && !lose && attempt > 0){
            printBlank(blank_word);
            System.out.println("Try to guess letter :");
            String letter_try = scanner.nextLine();
            if (checkLetter(word, letter_try)){
                blank_word = fillBlank(blank_word, word, letter_try);
                win = isWin(blank_word);
            }
            else {
                attempt--;
            }
        }
        if (win){
            System.out.printf("You win ! You have %d attempts left !%n", attempt);
            scanner.close();
            return (win);
        }
        else{
            System.out.println("You lose !");
            scanner.close();
            return (lose);
        }
    }
    public static void main(String[] args) {
        List<String> word = word();
        List<String> blank_word = blankWord(word);
        game(word, blank_word);
    }
}
