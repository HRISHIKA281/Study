package TreeLearn;
//2
public class sizeMaxSumHeight {
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

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static int size(Node root){
        if(root==null ) return 0;
        return 1+size(root.left)+size(root.right);
    }

    public static int sum(Node root){
        if(root==null)return 0;
        return root.val+sum(root.left)+sum(root.right);
    }

    public static int findMax(Node root){
        if(root==null) return Integer.MIN_VALUE;

        return Math.max(root.val,Math.max(findMax(root.left),findMax(root.right)));
    }

    public static int height(Node root){
        if(root==null || (root.left==null && root.right==null)) return 0;

        return 1+Math.max(height(root.left),height(root.right));
    }

    public static int minValue(Node root){
        if(root == null) return Integer.MAX_VALUE;

        return Math.min(root.val,Math.min(minValue(root.left),minValue(root.right)));
    }

    public static int product(Node root){
        if(root==null)return 1;

        return root.val*product(root.left)*product(root.right);
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

        Node f=new Node (40);
        e.left=f;
        //size of tree
        //size(root)=size(root.left)+size(root.right)+1
        // if size(root) return 0;
//        System.out.println(size(n));
//        System.out.println(findMax(n));
//
//        System.out.println(height(n));
        System.out.println(minValue(n));
        System.out.println(product(n));
    }
}
