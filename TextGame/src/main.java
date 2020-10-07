import textgame.TextGame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author juanm
 */
public class main {
    
    static TextGame textgame;

    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output;
        TextGame textgame = new TextGame();
        in = new BufferedReader(new InputStreamReader(System.in));
        textgame.Intro();
        do {
            System.out.print("> ");
            input = in.readLine();
            output = textgame.runCommand(input);
            System.out.println(output);
        } while (!"q".equals(input));
        
    }

}
