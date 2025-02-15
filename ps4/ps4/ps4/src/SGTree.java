import com.sun.source.tree.Tree;

/**
 * Scapegoat Tree class
 *
 * This class contains an implementation of a Scapegoat tree.
 */

public class SGTree {
    /**
     * TreeNode class.
     *
     * This class holds the data for a node in a binary tree.
     *
     * Note: we have made things public here to facilitate problem set grading/testing.
     * In general, making everything public like this is a bad idea!
     *
     */
    public static class TreeNode {
        int key;
        int weight;
        public TreeNode left = null;
        public TreeNode right = null;
        public TreeNode parent = null;

        TreeNode(int k) {
            this.weight = 1;
            key = k;
        }
    }

    // Root of the binary tree
    public TreeNode root = null;

    /**
     * Counts the number of nodes in the subtree rooted at node
     *
     * @param node the root of the subtree
     * @return number of nodes
     */
    public int countNodes(TreeNode node) {
        // TODO: Implement this
        if (node == null) {
            return 0;
        } else {
            return 1 + countNodes(node.right) + countNodes(node.left);
        }
    }

    /**
     * Builds an array of nodes in the subtree rooted at node
     *
     * @param node the root of the subtree
     * @return array of nodes
     */
    private int index;
    public TreeNode[] enumerateNodes(TreeNode node) {
        // TODO: Implement this
        TreeNode[] nodes = new TreeNode[countNodes(node)];
        index = 0; //index should reset each tim enumerateNodes is called; or else creating each tree is affected by other trees
        inOrderTraversal(nodes, node);
        return nodes;
    }

    public void inOrderTraversal(TreeNode[] nodesArray, TreeNode nodeRoot) {
//        if (nodeRoot.left != null) {
//            inOrderTraversal(nodesArray, nodeRoot.left);
//        }
//        nodesArray[index] = nodeRoot;
//        index ++;
//        if (nodeRoot.right != null) {
//            inOrderTraversal(nodesArray, nodeRoot.right);
//        }
        if (nodeRoot != null) {
            inOrderTraversal(nodesArray, nodeRoot.left); //recursion: assume left tree is already traversed!
            nodesArray[index] = nodeRoot;
            index ++;
            inOrderTraversal(nodesArray, nodeRoot.right);
        }
    }

    /**
     * Builds a tree from the list of nodes
     * Returns the node that is the new root of the subtree
     *
     * @param nodeList ordered array of nodes
     * @return the new root node
     */
    public TreeNode buildTree(TreeNode[] nodeList) {
        // TODO: Implement this
        return buildTreeRecursion(nodeList, 0, nodeList.length - 1);
    }

    public TreeNode buildTreeRecursion(TreeNode[] nodeList, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode root = nodeList[mid];
            root.left = buildTreeRecursion(nodeList, start, mid - 1);
            root.right=buildTreeRecursion(nodeList, mid + 1, end);
            if (root.left != null) {
                root.left.parent=root;
            }
            if (root.right != null) {
                root.right.parent=root;
            }
            return root;
        } else {
            return null;
        }
    }

    /**
     * Determines if a node is balanced. If the node is balanced, this should return true. Otherwise, it should return
     * false. A node is unbalanced if either of its children has weight greater than 2/3 of its weight.
     *
     * @param node a node to check balance on
     * @return true if the node is balanced, false otherwise
     */
    public boolean checkBalance(TreeNode node) {
        // TODO: Implement this
        if (node != null) {
            double twoOverThree = 2.0 / 3.0; //prevent 2/3 become 0
            return (node.left == null || node.left.weight <= twoOverThree * node.weight)
                                    && (node.right == null || node.right.weight <= twoOverThree * node.weight);
        } else {
            return true;
        }
    }

    /**
    * Rebuilds the subtree rooted at node
    * 
    * @param node the root of the subtree to rebuild
    */
    public void rebuild(TreeNode node) {
        // Error checking: cannot rebuild null tree
        if (node == null) {
            return;
        }

        TreeNode p = node.parent;
        TreeNode[] nodeList = enumerateNodes(node);
        TreeNode newRoot = buildTree(nodeList);

        if (p == null) {
            root = newRoot;
        } else if (node == p.left) {
            p.left = newRoot;
        } else {
            p.right = newRoot;
        }
        newRoot.parent = p;
        fixWeight(newRoot);
    }

    public void fixWeight (TreeNode node) {
        if (node != null) {
            node.weight = countNodes(node);
            fixWeight(node.left);
            fixWeight(node.right);
        }
    }

    /**
    * Inserts a key into the tree
    *
    * @param key the key to insert
    */
    public void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
            return;
        }

        insert(key, root);
        if (!checkBalance(root)) {
            rebuild(root);
        } else if (!checkBalance(root.left)) {
            rebuild(root.left);
        } else if (!checkBalance(root.right)) {
            rebuild(root.right);
        } else {
            return;
        }
    }

    // Helper method to insert a key into the tree
    private void insert(int key, TreeNode node) {
        if (key <= node.key) {
            if (node.left == null) {
                node.left = new TreeNode(key);
                node.left.parent = node;

            } else {

                insert(key, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(key);
                node.right.parent = node;

            } else {
                insert(key, node.right);

            }
        }
        fixWeight(node);
    }

    // Simple main function for debugging purposes
    public static void main(String[] args) {
        SGTree tree = new SGTree();
        for (int i = 0; i < 100; i++) {
            tree.insert(i);
        }

        // Check balance before rebuild
        System.out.println("Is tree balanced? " + tree.checkBalance(tree.root));

        // Rebuild the tree and check balance again
        //tree.rebuild(tree.root);
        //System.out.println("Is tree balanced after rebuild? " + tree.checkBalance(tree.root));
    }
}
