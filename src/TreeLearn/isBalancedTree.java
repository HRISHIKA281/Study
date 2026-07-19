package TreeLearn;
//4

public class isBalancedTree {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val=val;
        }
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }

        int leftH=height(root.left);
        int rightH=height(root.right);

        return 1+Math.max(leftH,rightH);
    }

    public static boolean isBalancedTree(Node root){
        if(root==null){
            return true;
        }

        int leftH=height(root.left);
        int rightH=height(root.right);

        if(Math.abs(leftH-rightH) > 1) return false;

        return isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    public static void main(String []args){
        Node root=new Node(1);
        Node a=new Node(2);
        root.left=a;
        Node b=new Node(4);
        root.right=b;
        Node c=new Node(6);
        Node d=new Node(8);
        a.left=c;
        a.right=d;
        Node e=new Node(9);
        b.right=e;
        System.out.println(isBalancedTree(root));
    }
}
