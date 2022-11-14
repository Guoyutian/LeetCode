package binary_tree.lc111;

import binary_tree.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Lc111 {
    // BFS level order traversal
    public int minDepth_bfs(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // for each level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * Solution: DFS
     * Key point:
     * if a node only has one child -> MUST return the depth of the side with child, i.e. MAX(left, right) + 1
     * if a node has two children on both side -> return min depth of two sides, i.e. MIN(left, right) + 1
     */
    public int minDepth_dfs(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth_dfs(root.left);
        int right = minDepth_dfs(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

    }
}
