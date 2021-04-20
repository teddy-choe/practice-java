package algorithm.leetcode_binary_tree_level_order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private List<List<Integer>> output;

    public static void main(String[] args) {
        Main main = new Main();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class ValueLevelPair {
        public TreeNode root;
        public int level;

        public ValueLevelPair(TreeNode root, int level) {
            this.root = root;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = calcLevel(root);

        output = new ArrayList<>();

        for (int i=0; i<level; i++) {
            output.add(new ArrayList<>());
        }

        bfs(root);

        return output;
    }

    public int calcLevel(TreeNode root) {
        int heignt = 0;
        if (root != null) {
            heignt = 1 + Math.max(calcLevel(root.left), calcLevel(root.right));
        }

        return heignt;
    }

    public void bfs(TreeNode root) {
        Queue<ValueLevelPair> q = new LinkedList();
        q.offer(new ValueLevelPair(root,0));

        while (!q.isEmpty()) {
            ValueLevelPair temp = q.poll();
            output.get(temp.level).add(temp.root.val);

            if (temp.root.left != null) {
                q.add(new ValueLevelPair(root.left, temp.level+1));
            }

            if (temp.root.right != null) {
                q.add(new ValueLevelPair(root.right, temp.level+1));
            }
        }
    }
}
