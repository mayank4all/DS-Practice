public class ConstructTreeFromInAndPre {

    int preIndex=0;
    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] in = {4,2,5,1,6,3,7};
        int[] post = {4,5,2,6,7,3,1};
        //TreeNode root = constructTreeFromInOrderAndPreorder(0,0,in.length-1,pre,in);
        TreeNode root = constructTreeFromInOrderAndPostorder(0, post.length-1,0,in.length-1, post, in);
        inorder(root);
        System.out.println("------------------------------------------");
        preorder(root);

    }

    private static TreeNode constructTreeFromInOrderAndPreorder(int preIndex, int inStart, int inEnd,int[] pre, int[] in) {
        if(preIndex>pre.length || inStart>inEnd){
            return null;
        }

        TreeNode node = new TreeNode(pre[preIndex]);

        int inIndex=0;
        for(int i=inStart; i<=inEnd; i++) {
            if(in[i] == node.val){
                inIndex=i;
            }
        }
        node.left = constructTreeFromInOrderAndPreorder(preIndex + 1, inStart, inIndex-1, pre, in);
        node.right = constructTreeFromInOrderAndPreorder(preIndex+inIndex-inStart+1,inIndex+1, inEnd, pre, in);
        return node;
    }

    private static TreeNode constructTreeFromInOrderAndPostorder(int postStart, int postEnd, int inStart, int inEnd,int[] post, int[] in) {
        if(postStart>post.length || inStart>inEnd){
            return null;
        }

        TreeNode node = new TreeNode(post[postEnd]);

        int inIndex=0;
        for(int i=inStart; i<=inEnd; i++) {
            if(in[i] == node.val){
                inIndex=i;
            }
        }
        node.left = constructTreeFromInOrderAndPostorder(postStart, postStart+inIndex-inStart-1, inStart, inIndex-1, post, in);
        node.right = constructTreeFromInOrderAndPostorder(postStart+inIndex-inStart, postEnd-1,inIndex+1, inEnd, post, in);
        return node;
    }

    private static void inorder(TreeNode root) {
        if(root==null){ return; }
        inorder(root.left);
        System.out.print(root.val + "");
        inorder(root.right);
    }

    private static void postorder(TreeNode root) {
        if(root==null){ return; }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val);
    }

    private static void preorder(TreeNode root) {
        if(root==null){ return; }
        System.out.print(root.val);
        preorder(root.left);
        preorder(root.right);
    }

}
