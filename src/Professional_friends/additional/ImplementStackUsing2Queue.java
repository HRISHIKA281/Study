package Professional_friends.additional;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class ImplementStackUsing2Queue {
    public class StackImp{
        private Queue<Integer> q1=new LinkedList<>();
        private Queue<Integer> q2=new LinkedList<>();
        int size1=0;
        int size2=0;

        public void push(int val){
            q1.offer(val);
            size1++;
        }

        public int pop(){
            if(q1.isEmpty() && q2.isEmpty()){
                System.out.println("Stack Overflow");
                return -1;
            }
            int curr=-1;
            if(q1.isEmpty()){
                int n=size2-1;
                for(int i=0;i<n;i++){
                    q1.offer(q2.poll());
                    size1++;size2--;
                }
                curr=q2.poll();
                size2--;
            }else{
                int n=size1-1;
                for(int i=0;i<n;i++){
                    q2.offer(q1.poll());
                    size1--;size2++;
                }
                curr=q1.poll();
                size1--;
            }
            return curr;
        }
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        ImplementStackUsing2Queue stack=new ImplementStackUsing2Queue();
        ImplementStackUsing2Queue.StackImp s=stack.new StackImp();
        int Q=sc.nextInt();
        for(int i=0;i<Q;i++){
            int input=sc.nextInt();
            if(input==1){
                int value=sc.nextInt();
                s.push(value);
            }else{
                System.out.println(s.pop());
            }
        }
    }
}
