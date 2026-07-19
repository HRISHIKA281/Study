package TreeLearn;
//5
public class DiameterOfTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    static int result=Integer.MIN_VALUE;
    public static int diameterOfTree(Node root){
        if(root==null) return 0;

        int leftAns=diameterOfTree(root.left);
        int rightAns=diameterOfTree(root.right);
        result=Math.max(result,leftAns+rightAns);
        return 1+Math.max(leftAns,rightAns);
    }

    public static void main(String []args){
        Node root=new Node(1);
        Node a=new Node(2);
        root.left=a;
        Node b=new Node(3);
        root.right=b;
        Node c=new Node(4);
        a.left=c;
        Node e=new Node(5);
        a.right=e;

        diameterOfTree(root);
        System.out.println(result);
    }
}
