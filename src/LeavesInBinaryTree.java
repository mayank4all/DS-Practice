import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.LinkedList;
import java.util.Queue;

public class LeavesInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        System.out.println(numberOfLeaves(root));
    }

    public static int numberOfLeaves(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count=0;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left==null && temp.right==null){
                count++;
            }
            else{
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
        }
        return count;
    }
}
