package binary_tree.lc103;

import binary_tree.treenode.TreeNode;

import java.util.*;

public class Lc103 {
    //DFS
    public List<List<Integer>> zigzagLevelOrder_Dfs(TreeNode root)
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;
        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }
        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0){
            collection.add(curr.val);
        } else{
            collection.add(0, curr.val);
        }

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }

    //BFS
    public List<List<Integer>> zigzagLevelOrder_Bfs(TreeNode root) {

        List<List<Integer>> zigZag = new ArrayList<>();
        if (root == null)
            return zigZag;
        traverse(root, zigZag);
        return zigZag;
    }

    private void traverse(TreeNode node, List<List<Integer>> arr) {
        /* if tree has only root node */
        if (node.left == null && node.right == null) {
            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(node.val);
            arr.add(sub);
            return;
        }
		/*
				Initialize the queue used to traverse bfs
		*/
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(node);
        int level = 0;
        while (!q.isEmpty()) {
			/*
				traverse each node at each level and store in sub list
			*/
            int size = q.size();
            ArrayList<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.peek();
                if (n.left != null)     q.add(n.left);
                if (n.right != null)    q.add(n.right);
                sub.add(n.val);
                q.poll();
            }
			/*
				check if current level is odd or even :
				if it is odd then reverse the sub list and add to our answer
			*/
            if (level % 2 != 0)     Collections.reverse(sub);
            arr.add(sub);
            level++;
        }
    }
}
