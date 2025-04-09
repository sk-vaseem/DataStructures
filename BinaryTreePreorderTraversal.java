public class BinaryTreePreorderTraversal {

    // Pre-order Traversal: Root -> Left -> Right
    public void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.println("Key: " + node.key + ", Value: " + node.value);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
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

        BinaryTreePreorderTraversal treeTraversal = new BinaryTreePreorderTraversal();

        System.out.println("Pre-order Traversal:");
        treeTraversal.preorderTraversal(root);
    }
}
