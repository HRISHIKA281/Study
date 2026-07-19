package TreeLearn;
//6
public class ConstructInOrderPreOrder {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val=val;
        }
    }
    public static Node solve(int []preOrder,int []inOrder,int start,int end,int idx){
        if(start>end){
            return null;
        }

        int rootVal=preOrder[idx];
        int j=start;
        while(j<=end){
            if(inOrder[j]==rootVal){
                break;
            }
            j++;
        }

        idx++;

        Node root=new Node(rootVal);
        root.left=solve(preOrder,inOrder,start,j-1,idx);
        root.right=solve(preOrder,inOrder,j+1,end,idx);

        return root;
    }
    int idx=0;
    public static Node constructTree(int []preOrder,int []inOrder,int idx){
        int n=preOrder[0];

        return solve(preOrder,inOrder,0,n-1,idx);
    }
    public static void main(String []args){
        int []preOrder={3,9,20,15,7};
        int []inOrder={9,3,15,20,7};
        ConstructInOrderPreOrder d= new ConstructInOrderPreOrder();

        constructTree(preOrder,inOrder,d.idx);
    }
}
