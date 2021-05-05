import java.util.Scanner;
import java.util.Stack;

public class MatchingBrackets
{

    public boolean ckeckBrackets(String expression){
        Stack<Character> parens = new Stack<>();

        for (int i = 0; i < expression.length(); i++)
        {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
            {
                parens.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}')
            {
                if (parens.isEmpty())
                {
                    System.out.println("Not balanced.");
                    return false;
                }
                char open = parens.pop();
                if (!(open == '(' && ch == ')'
                        || open == '[' && ch == ']'
                        || open == '{' && ch == '}'))
                {
                    System.out.println("Not balanced.");
                    return false;
                }
            }
        }
        if (parens.isEmpty())
        {
            System.out.print("Balanced.");
            return true;
        }
        else
        {
            System.out.print("Not balanced.");
            return false;

        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        MatchingBrackets pc = new MatchingBrackets();

        Scanner in = new Scanner(System.in);
        String expression = "";
        do{
            System.out.println("Enter an expression with { [ ( ) ] }: ('q' to stop)");
            expression = in.nextLine();
            if(!expression.equalsIgnoreCase("q")){
                boolean b = pc.ckeckBrackets(expression);
                System.out.println(expression + " has balanced brackets: " + b);
            }
        }while (!expression.equalsIgnoreCase("q"));
    }

}

