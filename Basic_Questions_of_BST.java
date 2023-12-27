
/*
 * Basic Questions of Binary search Tree 
 * 1.  Levelorder traversal
 * 2.  Print Nodes of specific level
 * 3.  Print leaf Nodes
 * 4.  Print Non leaf Nodes
 * 5.  Height of Tree
 * 6.  Min Node of Tree
 * 7.  Max Node of Tree
 * 8.  Total number of nodes
 * 9.  Left view of Tree
 * 10. Right veiw of Tree
 * 11. Lowest coman Ancestor
 * 12. Print path of specific node from root of Tree
 */
import java.util.*;

class Basic_Questions_of_BST {

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }

    }

    // Insertation of Nodes
    static Node insertNode(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertNode(root.left, data);
        } else if (data > root.data) {
            root.right = insertNode(root.right, data);
        }
        return root;
    }

    // Levelorder
    public static void Levelorder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    // Print nodes of specfic level
    static void printlevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.println(root.data);
            return;
        } else if (level > 1)
            printlevel(root.left, level - 1);
        printlevel(root.right, level - 1);

    }

    // print leaf node
    static void leafnodes(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        if (root.left != null) {
            leafnodes(root.left);
        }
        if (root.right != null) {
            leafnodes(root.right);
        }
    }

    // print all non leafs nodes
    static void nonleafs(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            System.out.println(root.data + " ");
        }
        if (root.left != null) {
            nonleafs(root.left);
        }
        if (root.right != null) {
            nonleafs(root.right);
        }
    }

    // height of tree
    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);

        if (leftheight > rightheight) {
            return (leftheight + 1);
        } else {
            return rightheight + 1;
        }
    }

    // Find the smallest node in Bst
    static int MinNode(Node root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // Find the largest node in Bst
    static int MaxNode(Node root) {
        while (root != null && root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // Total node in BST
    static int totalNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return totalNodes(root.left) + totalNodes(root.right) + 1;
    }

    // Delte BST
    static Node DelteBstNode(Node root) {
        if (root != null) {
            DelteBstNode(root.left);
            DelteBstNode(root.right);

            System.out.print(root.data + " ");
            root = null;
        }
        return root;
    }

    // Left veiw of BST
    static int Maxlevel;

    static void leftveiw(Node root, int level) {
        if (root == null) {
            return;
        }
        if (Maxlevel < level) {
            System.out.print(root.data + " ");
            Maxlevel = level;
        }
        leftveiw(root.left, level + 1);
        leftveiw(root.right, level + 1);
    }

    // Right veiw of Bst
    static int Maxi = 0;

    static void rightveiw(Node root, int level) {
        if (root == null) {
            return;
        }
        if (Maxi < level) {
            System.out.print(root.data + " ");
            Maxi = level;
        }
        rightveiw(root.right, level + 1);
        rightveiw(root.left, level + 1);

    }
    // Top veiw of tree

    // Bottom veiw of tree

    // Lowest coman Ancestor
    static int Lca(Node root, int n1, int n2) {
        if (root == null) {
            return -1;
        }
        if (n1 <= root.data && n2 >= root.data) {
            return root.data;
        } else if (n1 < root.data && n2 < root.data) {
            return Lca(root.left, n1, n2);
        } else if (n1 > root.data && n2 > root.data) {
            return Lca(root.right, n1, n2);
        }
        return -1;
    }

    // Path to specidic node
    static boolean haspath(Node root, int ele) {
        if (root == null) {
            return false;
        }
        if (root != null && root.data == ele) {
            return true;
        }
        if (ele < root.data) {
            return haspath(root.left, ele);
        }
        if (ele > root.data) {
            return haspath(root.right, ele);
        }
        return false;
    }

    static void PrintPath(Node root, int ele) {
        if (!haspath(root, ele)) {
            System.out.println("Element does not ecit in tree");
            return;
        }
        if (root != null && root.data == ele) {
            System.out.print(root.data + " ");
            return;
        }
        if (ele < root.data) {
            System.out.print(root.data + " ");
            PrintPath(root.left, ele);
        }
        if (root.data < ele) {
            System.out.print(root.data + " ");
            PrintPath(root.right, ele);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root, 8);
        insertNode(root, 3);
        insertNode(root, 10);
        insertNode(root, 1);
        insertNode(root, 6);
        insertNode(root, 14);
        insertNode(root, 4);
        insertNode(root, 7);
        insertNode(root, 13);
        // Levelorder(root);

        // printlevel(root, 1);

        // leafnodes(root);

        // nonleafs(root);

        // Height of tree
        // int height = Math.max(height(root.left), height(root.right)) + 1;
        // System.out.println("height of tree " + height);
        // // Min and max node of tree
        // System.out.println("Min Node " + MinNode(root));
        // System.out.println("Max Node " + MaxNode(root));
        // // total number of nodes
        // System.out.println("Total Nodes " + totalNodes(root));
        // System.out.println();

        // delete BST
        // DelteBstNode(root);

        // Left and Right veiw

        // leftveiw(root, 1);
        // rightveiw(root, 1);

        // Lowest coman Ancestor
        // System.out.println(Lca(root, 3, 13));

        // Print path to specifoc node
        PrintPath(root, 7);

    }
}
