import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 * https://leetcode-cn.com/problems/deepest-leaves-sum/
 */
public class lc1302 {

    // BFS
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
             sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return sum;
    }

    int sum = 0;
    int depth = 0;
    // dfs
    public int deepestLeavesSum1(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            // [50,null,54,98,6,null,null,null,34]
            if (level > depth) {
                sum = root.val;
                depth = level;
            } else if (level == depth) {
                sum += root.val;
            }
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}
