package Professional_friends.additional;

import java.util.Scanner;

public class ImplementStack {
    public class StackUsingArray{
        int []arr;
        StackUsingArray(int n){
            arr=new int[n];
        }
        int top=-1;
        public void push(int val){
            if(top==arr.length-1) return;
            top++;
            arr[top]=val;
        }

        public int pop(){
            if(top<0) {
                System.out.println("Stack underFlow");
                return -1;
            }
            int delete=arr[top];
            top--;
            return delete;
        }

        public int peek(){
            if(top<0){
                System.out.println("Stack underFlow");
                return -1;
            }
            return arr[top];
        }

        public boolean isEmpty(){
            if(top<0) return true;
            else return false;
        }
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        ImplementStack stack=new ImplementStack();
        int n= sc.nextInt();
        ImplementStack.StackUsingArray s= stack.new StackUsingArray(n);
        int S=sc.nextInt();
        for(int i=0;i<S;i++){
            int input=sc.nextInt();
            if(input==1){
                int curr=sc.nextInt();
                s.push(curr);
            }else{
                s.pop();
            }
        }
    }
}
