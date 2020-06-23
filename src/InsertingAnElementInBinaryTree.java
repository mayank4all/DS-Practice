import java.util.LinkedList;
import java.util.Queue;

public class InsertingAnElementInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        inorderTraversal(root);
        insertElementIterative(root,1);
        System.out.println("***************************************************");
        //insertElementRecursive(root,1);
        System.out.println("-----------------------------------------------------");
        inorderTraversal(root);
    }

    public static void insertElementIterative(TreeNode root, int element){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left==null){
                temp.left = new TreeNode(element);
                break;
            }else {
                q.offer(temp.left);
            }
            if(temp.right==null){
                temp.right = new TreeNode(element);
                break;
            }
            else{
                q.offer(temp.right);
            }
        }
    }


    public static void insertElementRecursive(TreeNode root, int element){
        if(root==null){
            root = new TreeNode(element);
        }else {
            insert(root, element);
        }
    }

    private static void insert(TreeNode root, int data){
        if(root.val >= data) {
            if (root.left == null) {
                root.left = new TreeNode(data);
            } else {
                insert(root.left, data);
            }
        }else {
            if (root.right == null) {
                root.right = new TreeNode(data);
            } else {
                insert(root.right, data);
            }
        }

    }

    private static void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}
