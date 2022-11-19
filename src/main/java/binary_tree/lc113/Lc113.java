package binary_tree.lc113;

import binary_tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lc113 {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(new ArrayList<Integer>(), root, sum);
        return result;
    }

    private void helper(List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) result.add(list);
            return;
        }
        helper(new ArrayList<Integer>(list), root.left, sum);
        helper(new ArrayList<Integer>(list), root.right, sum);
    }
}
