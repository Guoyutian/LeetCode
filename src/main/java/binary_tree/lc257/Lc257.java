package binary_tree.lc257;

import binary_tree.treenode.TreeNode;

import java.util.*;

public class Lc257 {
    //Recursion
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> sList = new LinkedList<String>();
        //String s=new String();
        if (root == null) return sList;
        if (root.left == null && root.right == null) {
            sList.add(Integer.toString(root.val));
            return sList;
        }

        for (String s : binaryTreePaths(root.left)) {
            sList.add(Integer.toString(root.val) + "->" + s);
        }
        for (String s : binaryTreePaths(root.right)) {
            sList.add(Integer.toString(root.val) + "->" + s);
        }
        return sList;
    }

    //BFS - Queue
    public List<String> binaryTreePaths_bfs(TreeNode root) {
        List<String> list = new ArrayList<String>();
        Queue<TreeNode> qNode = new LinkedList<TreeNode>();
        Queue<String> qStr = new LinkedList<String>();

        if (root == null) return list;
        qNode.add(root);
        qStr.add("");
        while (!qNode.isEmpty()) {
            TreeNode curNode = qNode.remove();
            String curStr = qStr.remove();

            if (curNode.left == null && curNode.right == null) list.add(curStr + curNode.val);
            if (curNode.left != null) {
                qNode.add(curNode.left);
                qStr.add(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                qNode.add(curNode.right);
                qStr.add(curStr + curNode.val + "->");
            }
        }
        return list;
    }

    //DFS - Stack
    public List<String> binaryTreePaths_dfs(TreeNode root) {
        List<String> list = new ArrayList<String>();
        Stack<TreeNode> sNode = new Stack<TreeNode>();
        Stack<String> sStr = new Stack<String>();

        if (root == null) return list;
        sNode.push(root);
        sStr.push("");
        while (!sNode.isEmpty()) {
            TreeNode curNode = sNode.pop();
            String curStr = sStr.pop();

            if (curNode.left == null && curNode.right == null) list.add(curStr + curNode.val);
            if (curNode.left != null) {
                sNode.push(curNode.left);
                sStr.push(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                sNode.push(curNode.right);
                sStr.push(curStr + curNode.val + "->");
            }
        }
        return list;
    }
}
