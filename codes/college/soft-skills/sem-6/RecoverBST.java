import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.val = data;
    }

}

/**
 * RecoverBST
 */
public class RecoverBST {

    public void brute(TreeNode root) {
        List<Integer> inorderTraversal = new ArrayList<>();
        _inorderTraversal(root, inorderTraversal);
        inorderTraversal.sort(Integer::compare);

        _buildTree(root, inorderTraversal, new AtomicInteger(0));
    }

    private void _inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        _inorderTraversal(root.left, list);
        list.add(root.val);
        _inorderTraversal(root.right, list);
    }

    private void _buildTree(TreeNode root, final List<Integer> arr, AtomicInteger i) {
        if (root == null)
            return;
        _buildTree(root.left, arr, i);
        root.val = arr.get(i.get());
        i.incrementAndGet();

        _buildTree(root.right, arr, i);
    }

}
