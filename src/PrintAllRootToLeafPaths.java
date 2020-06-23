import java.util.ArrayList;

public class PrintAllRootToLeafPaths {
    public static void main(String[] args) {TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<Integer> path = new ArrayList<>();
        printAllPaths(root,path);
        int[] arr = {1,2,4};
        System.out.println(isValidSequence(root,arr));
    }

    public static void printAllPaths(TreeNode root, ArrayList path){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left==null && root.right== null){
            System.out.println(path);
            return;
        }
        printAllPaths(root.left,new ArrayList(path));
        printAllPaths(root.right,new ArrayList(path));
    }

    public static boolean isValidSequence(TreeNode root, int[] arr) {
        int aIndex=0;
        return dfs(root,arr,aIndex);
    }

    public static boolean dfs(TreeNode root, int[] arr, int aIndex) {

        if(root==null){
            return arr.length==0;
        }

        if((root.left==null && root.right==null)&&(root.val==arr[aIndex] && root.val==arr[arr.length-1])){
            return true;
        }
        return (aIndex<arr.length && root.val==arr[aIndex] )&&(dfs(root.left,arr,aIndex+1) || dfs(root.right,arr,aIndex+1));


    }
}
