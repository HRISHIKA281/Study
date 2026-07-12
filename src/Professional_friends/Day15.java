package Professional_friends;
import java.util.Scanner;
//linkedList

public class Day15 {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    // Create Linked List
    public static Node createList(Scanner sc) {
        int n= sc.nextInt();
        if(n==0) return null;

        Node head=new Node(sc.nextInt());
        Node tail=head;

        for(int i=1;i<n;i++){
            tail.next=new Node(sc.nextInt());
            tail=tail.next;
        }
        return head;
    }

    // Print Linked List
    public static Node printList(Node head) {
        Node temp =head;
        while (temp != null) {
            System.out.print(head.val + " ");
            temp = temp.next;
        }

        System.out.println();
        return head;
    }


    public static Node reverse(Node head){
        Node curr=head;
        Node prev=null;
        Node next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }

    public static boolean isCycle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public static Node mergeSorted(Node head1,Node head2){
        Node Dummy =new Node(0);
        Node t=Dummy;

        Node temp1=head1;
        Node temp2=head2;

        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                t.next=temp1;
                temp1=temp1.next;
            }else{
                t.next=temp2;
                temp2=temp2.next;
            }
            t=t.next;
        }

        if(temp1 != null){
            t.next=temp1;
        }
        if(temp2 != null){
            t.next=temp2;
        }
        return Dummy.next;
    }

    public static Node findMid(Node head){
        Node slow= head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        Node head=createList(sc);
        Node result=findMid(head);
        System.out.println(result.val);
    }
}
