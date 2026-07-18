package Professional_friends;
import java.util.Stack;
import java.util.Scanner;

public class Day17 {
    public static int precedence(char c){
        if(c=='^'||c=='$') return 3;
        else if(c=='*'||c=='/') return 2;
        else if (c=='+'|| c=='-') return 1;
        else return 0;
    }
    public static String infixToPostfix(String s){
        Stack<Character> stack=new Stack<>();
        StringBuilder result=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetter(c)){
                result.append(c);
            }else if(c=='(') stack.push('(');
            else if(c==')') {
                while(!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.pop());
                }
                if(stack.peek()=='(') stack.pop();
                else return "Invalid String";
            }
            else if(c=='^'){
                while(!stack.isEmpty() && precedence(stack.peek())> precedence(c)){
                    result.append(stack.pop());
                }
                stack.push(c);
            }
            else if(c=='+'|| c=='-' || c=='*' || c=='/' || c=='$'){
                while(!stack.isEmpty() && precedence(stack.peek())>= precedence(c)){
                    result.append(stack.pop());
                }
                stack.push(c);
            }else return "Invalid String";
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static String infixToPrefix(String infix) {

        // Step 1: Reverse
        StringBuilder rev = new StringBuilder(infix).reverse();

        // Step 2: Swap brackets
        for (int i = 0; i < rev.length(); i++) {

            if (rev.charAt(i) == '(')
                rev.setCharAt(i, ')');

            else if (rev.charAt(i) == ')')
                rev.setCharAt(i, '(');
        }

        // Step 3: Convert reversed expression to postfix
        String postfix = infixToPostfix(rev.toString());

        // Step 4: Reverse postfix
        return new StringBuilder(postfix).reverse().toString();
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(infixToPostfix(str));
        System.out.println(infixToPrefix(str));
    }
}
