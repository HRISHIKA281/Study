package TreeLearn;
//3
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PreInPost {
    public static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val=val;
        }
    }
    public static void preOrder(Node root){
        if(root==null) return ;

        // kaam left right -> root left right
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root==null) return ;

        // left kaam right -> left root right
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root==null) return ;

        // left right kaam -> left right root
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");

    }

    public static void nthLevel(Node root,int n){
        //recursion,n is the level bfs
        if(root==null) return;
        if(n==1) {
            System.out.print(root.val+" ");
            return;
        }
        nthLevel(root.left,n-1);
        nthLevel(root.right,n-1);
    }

    public static void bfs(Node root){
        //itterative way no recursion
        Queue<Node> q=new LinkedList<>();
        //root
        if(root!=null) q.add(root);
        while(!q.isEmpty()){
            Node curr=q.remove();
            //bache
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
            //print
            System.out.print(curr.val);

        }
//curr bache print
    }

    public static void dfs(Node root){
        Stack<Node> stack=new Stack<>();
        if(root!=null) stack.push(root);
        while(!stack.isEmpty()){
            Node curr=stack.pop();
            System.out.println(curr.val);
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
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
        preOrder(n);
        System.out.println();
        inOrder(n);
        System.out.println();
        postOrder(n);

        // print elements of nth level
    }
}
