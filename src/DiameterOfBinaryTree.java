public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        System.out.println(diameter(root));
    }

    public static int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        return heightOfSubtree(root);
    }

    private static int heightOfSubtree(TreeNode root){
        int ans = Integer.MIN_VALUE;
        if(root==null){
            return 0;
        }
        int left = heightOfSubtree(root.left);
        int right = heightOfSubtree(root.right);
        ans = Math.max(ans,left+right);
        return Math.max(left,right)+1;
    }
}
