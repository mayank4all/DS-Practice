import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalBFS {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        bfs(root);
    }

    public static void bfs(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            System.out.println(tmp.val + " ");
            if (tmp.left != null) {
                q.add(tmp.left);
            }
            if (tmp.right != null) {
                q.add(tmp.right);
            }
        }
    }
}
