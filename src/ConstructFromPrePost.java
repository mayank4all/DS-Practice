public class ConstructFromPrePost {
    static int preIndex = 0, postIndex = 0;

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        System.out.println(constructFromPrePost(pre,post));
    }

    public static TreeNode constructFromPrePost(int[] pre , int[] post){

        TreeNode root = new TreeNode(pre[preIndex++]);
        if(root.val != post[postIndex])
            root.left = constructFromPrePost(pre,post);
        System.out.println(root.val+"*");
        if(root.val != post[postIndex])
            root.right = constructFromPrePost(pre,post);
        postIndex++;
        return root;
    }

}
