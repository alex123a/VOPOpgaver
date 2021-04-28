import java.util.Scanner;
import java.util.Stack;

/**
 * @author erso
 */
public class MatchingBrackets {


    public boolean ckeckBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '{' || current == '(' || current == '[') {
                stack.push(current);
            } else if (current == '}' || current == ')' || current == ']') {
                if (stack.isEmpty() || !(current == '}' && stack.lastElement() == '{' ||
                        current == ')' && stack.lastElement() == '(' ||
                        current == ']' && stack.lastElement() == '[')) {
                    return false;
                }

                stack.remove(stack.lastElement());
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ckeckBrackets2(String expression) {
        FastLinkedList<Character> linkedList = new FastLinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '{' || current == '(' || current == '[') {
                linkedList.push(current);
            } else if (current == '}' || current == ')' || current == ']') {
                if (linkedList.isEmpty() || !(current == '}' && linkedList.get() == '{' ||
                        current == ')' && linkedList.get() == '(' ||
                        current == ']' && linkedList.get() == '[')) {
                    return false;
                }
                linkedList.pop();
            }
        }
        if (linkedList.isEmpty()) {
            return true;
        } else {
            return false;
        }
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
                // boolean b = pc.ckeckBrackets(expression);
                boolean b = pc.ckeckBrackets2(expression);
                System.out.println(expression + " has balanced brackets: " + b);
            }
        } while (!expression.equalsIgnoreCase("q"));
    }
}
