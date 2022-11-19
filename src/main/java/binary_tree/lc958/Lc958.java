package binary_tree.lc958;

import binary_tree.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Lc958 {
    //recursive
    public boolean isCompleteTree_recursive(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null) bfs.poll();
        return bfs.isEmpty();
    }

    //interative
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean seenEmpty = false;

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                seenEmpty = true;
                continue;
            } else if (seenEmpty) {
                return false;
            }

            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return true;
    }
}
