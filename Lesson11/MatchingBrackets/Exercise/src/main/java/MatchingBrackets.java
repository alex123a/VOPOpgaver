import java.util.Scanner;
import java.util.Stack;

/**
 * @author erso
 */
public class MatchingBrackets {


    public boolean ckeckBrackets(String expression) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatchingBrackets pc = new MatchingBrackets();

        Scanner in = new Scanner(System.in);
        String expression = "";
        do {
            System.out.println("Enter an expression with { [ ( ) ] }: ('q' to stop)");
            expression = in.nextLine();
            if (!expression.equalsIgnoreCase("q")) {
                boolean b = pc.ckeckBrackets(expression);
                System.out.println(expression + " has balanced brackets: " + b);
            }
        } while (!expression.equalsIgnoreCase("q"));
    }
}
