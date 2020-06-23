import java.util.Stack;

public class MaximumElementInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(findMaxRecursive(root));
        System.out.println("---------------------------------------------------------------");
        System.out.println(findMaxIterative(root));
    }

    public static int findMaxRecursive(TreeNode root){

        int max = Integer.MIN_VALUE;
        if(root!=null) {
            int leftmax = findMaxRecursive(root.left);
            int rightmax = findMaxRecursive(root.right);
            if (leftmax > rightmax) {
                max = leftmax;
            } else {
                max = rightmax;
            }
            if(root.val>max){
                max=root.val;
            }

        }
        return max;
    }

    public static  int findMaxIterative(TreeNode root){
        int max = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(max<temp.val){ max = temp.val; }
            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(temp.right!=null){
                stack.push(temp.right);
            }
        }
        return max;
    }
}
