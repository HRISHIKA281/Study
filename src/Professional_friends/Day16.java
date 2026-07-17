package Professional_friends;
import java.util.Stack;
import java.util.Scanner;
import java.util.Arrays;

public class Day16 {
    public static boolean isBalanced(String str){
        Stack<Character> s=new Stack<>();
        for(char c:str.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                s.push(c);
            }
            else if((c==')' && !s.isEmpty() && s.peek()=='(') || (c=='}' && !s.isEmpty() && s.peek()=='{') || (c==']' && !s.isEmpty() && s.peek()=='[')){
                s.pop();
            }else{
                return false;
            }
        }
        if(s.isEmpty()) return true;
        return false;
    }

    public static int[] nextGreatestElement(int []arr){
        Stack<Integer>stack=new Stack<>();
        int []result=new int[arr.length];
        Arrays.fill(result,-1);
        for(int i=0;i<arr.length;i++){
            int curr=arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] < curr){
                int index=stack.pop();
                result[index]=curr;
            }
            stack.push(i);
        }
        return result;
    }

    public static void insertAtBottom(Stack<Integer> stack, int val) {

        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }

        int top = stack.pop();

        insertAtBottom(stack, val);

        stack.push(top);
    }

    public void reverse(Stack<Integer> stack){
        if (stack.isEmpty())
            return;

        int top = stack.pop();

        reverse(stack);

        insertAtBottom(stack, top);
    }

    public static int postFixExpEvaluation(String str){
        Stack<Integer> s=new Stack<>();
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)) s.push(c-'0');
            else{
                if(s.size()>=2){
                    int b=s.pop();
                    int a=s.pop();
                    if(c=='+')  s.push(a+b);
                    else if(c=='-') s.push(a-b);
                    else if(c=='*') s.push(a*b);
                    else{
                        if(b!=0) s.push(a/b);
                        else {
                            System.out.println("InValid Input");
                            return -1;
                        }
                    }
                } else {
                    System.out.println("InValid Input");
                    return -1;
                }
            }
        }
        if(s.size() == 1) return s.pop();
        return -1;
    }

    public static int prefixEvaluation(String str){
        Stack<Integer> s=new Stack<>();
        for(int i=str.length()-1;i>=0;i--){
            char curr=str.charAt(i);
            if(Character.isDigit(curr)) s.push(curr-'0');
            else{
                if(s.size()>=2){
                    int a=s.pop();
                    int b=s.pop();
                    if(curr=='+') s.push(a+b);
                    else if(curr=='-') s.push(a-b);
                    else if(curr=='*') s.push(a*b);
                    //since give b will not be 0
                    else if(curr=='/') s.push(a/b);
                    else{
                        System.out.println("Invalid string");
                        return -1;
                    }
                }else{
                    System.out.println("Invalid string");
                    return -1;
                }
            }
        }
        if(s.size()==1) return s.pop();
        else{
            System.out.println("Invalid string");
            return -1;
        }
    }
    public static int priority(char c){
        if(c=='^' ||c=='$') return 3;
        else if(c=='*' || c=='/') return 2;
        else if(c=='+' || c=='-') return 1;
        else return 0;
    }
    public static int infixEvaluation(String str){
        Stack<Integer> numberStack=new Stack<>();
        Stack<Character> operator=new Stack<>();

        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(Character.isDigit(c)){
                numberStack.push(c-'0');
            }else if(c=='('){
                operator.push('(');
            }else if(c==')'){

                while(!operator.isEmpty() && operator.peek()!='('){
                    char o=operator.pop();
                    int b=numberStack.pop();
                    int a=numberStack.pop();
                    if(o=='+') numberStack.push(a+b);
                    else if(o=='-') numberStack.push(a-b);
                    else if(o=='*') numberStack.push(a*b);
                    else if(o=='/') numberStack.push(a/b);
                    else {
                        System.out.println("Invalid expression");
                        return -1;
                    }
                }
                if(operator.peek()=='(') operator.pop();
            }
            else if(c=='+' ||c=='-' ||c=='*' ||c=='/'){
                while(!operator.isEmpty() && priority(operator.peek()) >= priority(c)){
                    char o=operator.pop();
                    int b=numberStack.pop();
                    int a=numberStack.pop();
                    if(o=='+') numberStack.push(a+b);
                    else if(o=='-') numberStack.push(a-b);
                    else if(o=='*') numberStack.push(a*b);
                    else if(o=='/') numberStack.push(a/b);
                    else {
                        System.out.println("Invalid expression");
                        return -1;
                    }
                }
                operator.push(c);
            }else{
                System.out.println("Invalid expression");
                return -1;
            }
        }
        while(!operator.isEmpty()){
            int b=numberStack.pop();
            int a=numberStack.pop();
            char o=operator.pop();
            if(o=='+') numberStack.push(a+b);
            else if(o=='-') numberStack.push(a-b);
            else if(o=='*') numberStack.push(a*b);
            else if(o=='/') numberStack.push(a/b);
            else {
                System.out.println("Invalid expression");
                return -1;
            }
        }
        if(numberStack.size()==1) return numberStack.pop();
        else return -1;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
//        String str=sc.nextLine();
//        System.out.println(isBalanced(str));

//        int n=sc.nextInt();
//        sc.nextLine();
//        String s=sc.nextLine();
//        Stack<Integer> stack=new Stack<>();
//        int i=0;
//        while(i<s.length()){
//            char curr=s.charAt(i);
//            if(Character.isDigit(curr)){
//                int r=0;
//                while(i<s.length() && Character.isDigit(s.charAt(i))){
//                    r=r*10+s.charAt(i)-'0';
//                    i++;
//                }
//                stack.push(r);
//            }
//            i++;
//        }

        String str=sc.nextLine();
        System.out.println(postFixExpEvaluation(str));
    }
}
