package TreeLearn;
import java.util.*;
//8
public class PathSum2 {
    public class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }

    public void fill(Node root,int sum,List<Integer> temp,int targetSum){
        if(root ==null) return ;

        sum=sum+root.val;
        temp.add(root.val);

        if(root.left==null && root.right==null){
            if(sum==targetSum){
                result.add(temp);
            }
            return;
        }

        fill(root.left,sum,temp,targetSum);
        fill(root.right,sum,temp,targetSum);
    }

    static int sum=0;
    static List<List<Integer>> result=new ArrayList<>();
    List<List<Integer>> pathSum(Node root,int targetSum){
        List<Integer> temp=new ArrayList<>();
        fill(root,sum,temp,targetSum);
        return result;
    }
    public static void main(String[]args){

    }
}
