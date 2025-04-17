import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class RootToNodePath {

    // Function to find the path from the root to the target node
    public static boolean findPath(TreeNode root, List<Integer> path, int target) {
        if (root == null) {
            return false;
        }

        // Add the current node to the path
        path.add(root.val);

        // Check if the current node is the target node
        if (root.val == target) {
            return true;
        }

        // Recur for left and right subtrees
        if (findPath(root.left, path, target) || findPath(root.right, path, target)) {
            return true;
        }

        // If target node is not found in this path, remove the current node
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int target = 5;
        List<Integer> path = new ArrayList<>();

        if (findPath(root, path, target)) {
            System.out.println("Path to Node " + target + ": " + path);
        } else {
            System.out.println("Node " + target + " not found in the tree.");
        }
    }
}
