import java.util.Stack;

public class ZigZagTreeTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        zigzagTreeTraversal(root);
    }

    public static void zigzagTreeTraversal(TreeNode root) {
        boolean isZigZag = false;
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();

        current.push(root);
        while(!current.isEmpty()) {
            TreeNode tmp = current.pop();
            System.out.print(tmp.val + " ");

            if(isZigZag){
                if(tmp.left!=null) {
                    next.push(tmp.left);
                }
                if(tmp.right!=null) {
                    next.push(tmp.right);
                }
            }
            else {
                if(tmp.right!=null){
                    next.push(tmp.right);
                }
                if(tmp.left!=null){
                    next.push(tmp.left);
                }
            }

            if(current.isEmpty()){
                isZigZag = !isZigZag;
                Stack<TreeNode> temp = current;
                current=next;
                next=temp;
            }
        }

    }
}
