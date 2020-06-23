public class MirrorTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        inorder(root);
        System.out.println("----------------------------------------------------");
        makeMirrorTree(root);
        inorder(root);
    }

    public static TreeNode makeMirrorTree(TreeNode root){

        if(root!=null){
            makeMirrorTree(root.left);
            makeMirrorTree(root.right);
            /*Swapping the places*/
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    private static void inorder(TreeNode root){
        if(root == null){ return; }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}
