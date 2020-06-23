public class AncestorsOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
//        printAncestorsOfBinaryTree(root, new TreeNode(7));
        System.out.println(leastCommonAncestor(root,4, 5).val);
    }

    public static boolean printAncestorsOfBinaryTree(TreeNode root, TreeNode node){
        if(root==null){
            return false;
        }

        if(root.val==node.val){
            return true;
        }


        if(printAncestorsOfBinaryTree(root.left,node) || printAncestorsOfBinaryTree(root.right,node)) {
            System.out.println(root.val);
            return true;
        }
        return false;
    }

    public static TreeNode leastCommonAncestor(TreeNode root, int p, int q) {
        if(root==null || root.val==p || root.val==q) return root;

        TreeNode left = leastCommonAncestor(root.left,p,q);
        TreeNode right = leastCommonAncestor(root.right,p,q);
        if(left==null && right==null) return null;
        if(left!=null && right!=null) return root;
        return left==null?right:left;
    }
}
