package codes.college.softskills.sem6;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    final int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.val = data;
    }

}

/**
 * RightSideViewBinaryTree
 */
public class RightSideViewBinaryTree {

    public List<Integer> solution(TreeNode root) {
        List<Integer> view = new ArrayList<>();

        _reversePreorderTraversal(root, 0, view);

        return view;
    }

    private void _reversePreorderTraversal(TreeNode root, int level, List<Integer> view) {
        if (root == null) {
            return;
        }

        if (level >= view.size()) {
            view.add(root.val);
        }
        _reversePreorderTraversal(root.right, level + 1, view);
        _reversePreorderTraversal(root.left, level + 1, view);
    }

    public List<Integer> leftView(TreeNode root) {
        List<Integer> view = new ArrayList<>();

        _inorderTraversal(root, 0, view);

        return view;
    }

    private void _inorderTraversal(TreeNode root, int level, List<Integer> view) {
        if (root == null) {
            return;
        }

        if (level >= view.size()) {
            view.add(root.val);
        }
        _inorderTraversal(root.left, level + 1, view);
        _inorderTraversal(root.right, level + 1, view);
    }
}
