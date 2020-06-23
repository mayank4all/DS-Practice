import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        //System.out.println(heightRecursive(root));
        System.out.println(heightIterative(root));
    }

    public static int heightRecursive(TreeNode root){

        if(root == null){
            return 0;
        }
        int lheight = heightRecursive(root.left);
        int rheight = heightRecursive(root.right);

        if(lheight>rheight){
            return lheight+1;
        }
        else{
            return rheight+1;
        }

    }


    public static int heightIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int count=1;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp!=null){
                if(temp.left==null && temp.right==null){
                    return count;
                }
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            else{
                if(!q.isEmpty()){
                    count++;
                    q.offer(null);
                }
            }
        }
        return count;
    }
}
