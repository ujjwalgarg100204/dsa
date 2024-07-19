package codes.random.binarytree;

import java.util.List;

class TreeNode {
    final int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

}

/**
 * ConstructCompleteBinaryTreeFromArrayInLeverOrderFashion
 */
public class ConstructCompleteBinaryTreeFromArrayInLeverOrderFashion {

    public String getReferenceLink() {
        return "https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array";
    }

    public TreeNode solution(final List<Integer> arr) {
        return _helper(arr, 0);
    }

    private TreeNode _helper(final List<Integer> arr, int i) {
        TreeNode root = null;

        if (i < arr.size() && arr.get(i) != null) {
            root = new TreeNode(arr.get(i));
            root.left = _helper(arr, 2 * i + 1);
            root.right = _helper(arr, 2 * i + 2);
        }

        return root;
    }

}
