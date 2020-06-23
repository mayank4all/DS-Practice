import java.util.HashMap;

public class VerticalSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        verticalSum(root);

    }

    private static void verticalSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        verticalUtil(map,root,0);
        for(Integer k : map.keySet()){
            System.out.println(k+" "+map.get(k));
        }

    }

    public static void verticalUtil(HashMap<Integer,Integer> map, TreeNode root, int c){
        if(root.left!=null) {
            verticalUtil(map, root.left, c - 1);
        }
        if(root.right!=null) {
            verticalUtil(map, root.right, c + 1);
        }
        int data=0;
        if(map.containsKey(c)){
            data=map.get(c);
        }
        map.put(c,root.val+data);

    }
}
