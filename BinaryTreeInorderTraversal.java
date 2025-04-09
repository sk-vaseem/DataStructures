

public class BinaryTreeInorderTraversal {

    // In-order Traversal: Left -> Root -> Right
    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println("Key: " + node.key + ", Value: " + node.value);
            inorderTraversal(node.right);
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

        BinaryTreeInorderTraversal treeTraversal = new BinaryTreeInorderTraversal();

        System.out.println("In-order Traversal:");
        treeTraversal.inorderTraversal(root);
    }
}
