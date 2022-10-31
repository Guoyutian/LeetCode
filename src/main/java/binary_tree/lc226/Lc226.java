package binary_tree.lc226;

import binary_tree.treenode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Lc226 {
    //DFS
    public TreeNode invertTreeByDfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        final TreeNode left = root.left,
                right = root.right;
        root.left = invertTreeByDfs(right);
        root.right = invertTreeByDfs(left);
        return root;
    }

    //BFS
    public TreeNode invertTreeByBfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }


    public TreeNode invertTreeBy(TreeNode root) {
        if (root == null) {
            return null;
        }
        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
}
