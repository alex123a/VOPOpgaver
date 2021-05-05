import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MatchingBracketsWithList {

    public boolean ckeckBrackets(String expression){
        List<Character> parens = new LinkedList<Character>();

        for (int i = 0; i < expression.length(); i++)
        {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
            {
                parens.add(0, ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}')
            {
                if (parens.isEmpty())
                {
                    System.out.println("Not balanced.");
                    return false;
                }
                char open = parens.remove(0);
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
            System.out.print("Balanced.\t ");
            return true;
        }
        else
        {
            System.out.print("Not balanced.\t");
            return false;

        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        MatchingBracketsWithList pc = new MatchingBracketsWithList();

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
