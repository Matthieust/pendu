package pendu;
import java.util.*;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }
    public static String word(){
        return "WORD";
    }

    public static boolean checkLetter(String word, String letterTry) {
        for(int i = 0; i < word.length(); i++){
            if (word.charAt(i) == Character.toUpperCase(letterTry.charAt(0))){
                return (true);
            }
        }
        return (false);
    }

    public static boolean game(String word){
        boolean win = false;
        boolean lose = false;
        int attempt = 7;

        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < word.length(); i++){
            System.out.printf("%s", "_ ");
        }
        while (!win && !lose){
            System.out.println("Try to guess letter :");
            String letterTry = scanner.nextLine();
            if (checkLetter(word, letterTry)){
                win = true;
            }
            else {
                lose = true;
            }
        }
        if (win){
            System.out.println("You win !");
            return (win);
        }
        else{
            System.out.println("You lose !");
            return (lose);
        }
    }

    public static void main(String[] args) {
        String word = word();
        game(word);
    }
}
