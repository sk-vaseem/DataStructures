

public class BinaryTreePostorderTraversal {

    // Post-order Traversal: Left -> Right -> Root
    public void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.println("Key: " + node.key + ", Value: " + node.value);
        }
    }

    public static void main(String[] args) {
        // Creating a binary tree with key-value pairs
        TreeNode root = new TreeNode(1, "A");
        root.left = new TreeNode(2, "B");
        root.right = new TreeNode(3, "C");
        root.left.left = new TreeNode(4, "D");
        root.left.right = new TreeNode(5, "E");
        root.right.left = new TreeNode(6, "F");
        root.right.right = new TreeNode(7, "G");

        BinaryTreePostorderTraversal treeTraversal = new BinaryTreePostorderTraversal();

        System.out.println("Post-order Traversal:");
        treeTraversal.postorderTraversal(root);
    }
}
