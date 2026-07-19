package TreeLearn;
//7
import java.util.List;
import java.util.ArrayList;
public class PathSumFind1 {
    public class Node{
        int val;
        Node left;
        Node right;
        Node (int val){
            this.val=val;
        }
    }
    public static boolean PreOrder(Node root,int sum,int target){
        if(root==null) return false;

        sum+=root.val;
        if(root.left == null && root.right==null){
            if(sum==target) return true;
            else return false;
        }

        boolean leftH=PreOrder(root.left,sum,target);
        boolean rightH=PreOrder(root.right,sum,target);

        return leftH || rightH;
    }
    static int sum=0;
    public static boolean hasPath(Node root,int target){
        boolean result=PreOrder(root,sum,target);
        return result;
    }


    public static void main(String []args){

    }
}
