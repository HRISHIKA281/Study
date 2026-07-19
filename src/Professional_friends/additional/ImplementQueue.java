package Professional_friends.additional;
import java.util.*;
public class ImplementQueue {
    public class Queue{
             Stack<Integer> s1=new Stack<>();
             Stack<Integer> s2=new Stack<>();
        public  void enqueue(int val){
            s1.push(val);
        }

        public int dequeue(){
            if(s1.isEmpty() && s2.isEmpty()){
                System.out.println("Queue Underflow");
                return -1;
            }
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }

            int remove=s2.pop();

            return remove;
        }
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int Q=sc.nextInt();
        ImplementQueue q=new ImplementQueue();
        ImplementQueue.Queue queue=q.new Queue();

        for(int i=0;i<Q;i++){
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                queue.enqueue(x);
            } else {
                System.out.println(queue.dequeue());
            }
        }

    }
}
