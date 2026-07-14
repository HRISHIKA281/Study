package Professional_friends;
import java.util.*;

public class FewMoreQonLL {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static Node printList(Node head){
        if(head==null) return null;
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
        return head;
    }

    public static Node createList(Scanner sc){
        int n=sc.nextInt();
        if(n==0) return null;

        Node head=new Node(sc.nextInt());
        Node tail=head;
        for(int i=1;i<n;i++){
            tail.next=new Node(sc.nextInt());
            tail=tail.next;
        }
        tail.next=null;
        return head;
    }
    public static int size(Node head){
        if(head==null) return 0;
        return 1+size(head.next);
    }
    public static int nthEnd(Node head,int n){
        if(head==null) return -1;
        Node temp=head;
        Node trail=head;
        int i=0;
        while(i<n && trail !=null){
            trail=trail.next;
            i++;
        }
        if(trail==null && i<n) return -1;
        while(temp!=null && trail!=null){
            temp=temp.next;
            trail=trail.next;
        }
        return temp.data;
    }

    public static Node removeDuplicates(Node head){
        if (head==null) return null;
        Node temp=head;
        Node t=head;
        HashSet<Integer> set =new HashSet<>();
        set.add(head.data);
        while(temp!=null){
            if(!set.contains(temp.data)){
                t.next=temp;
                t=t.next;
                set.add(temp.data);
            }
            temp=temp.next;
        }
        t.next=null;
        return head;
    }

    public static Node findMid(Node head){
        if(head==null) return null;
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static boolean isPalindrom(Node head){
        if(head==null || head.next==null) return true;
        Node mid1=findMid(head);
        Node curr = mid1.next;

        mid1.next=null;

        Node prev=null;
        Node next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node temp1=head;
        Node temp2=prev;

        while(temp1!=null && temp2!=null){
            if(temp1.data!=temp2.data) return false;
            temp1=temp1.next;
            temp2=temp2.next;
        }

        return true;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        Node head=createList(sc);
        int n=sc.nextInt();
        System.out.println(nthEnd(head,n));
    }
}
