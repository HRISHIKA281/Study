package TreeLearn;
//1
public class Implementation {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }

    //preOrder
    public static void display(Node root){
        if(root==null){
            return ;
        }

        System.out.print(root.val+" -> ");
        //left
        if(root.left!=null){
            System.out.print(root.left.val+",");
        }else{
            System.out.print("null"+",");
        }
        //right
        if(root.right!=null){
            System.out.print(root.right.val);
        }else{
            System.out.print("null");
        }

        System.out.println();

        display(root.left);
        display(root.right);
    }
    public static void main(String []args){
        Node n=new Node(2);
        Node a=new Node(4);
        Node b=new Node(10);
        n.left=a;
        n.right=b;
        Node c=new Node(6);
        a.left=c;
        Node d=new Node(5);
        a.right=d;
        Node e=new Node(11);
        b.right=e;
        display(n);
    }
}
