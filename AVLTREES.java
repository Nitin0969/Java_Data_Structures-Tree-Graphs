import java.util.LinkedList;
import java.util.Queue;

public class AVLTREES {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int cal_height(Node root) {
        if (root == null) {
            return 0;

        }
        return root.height;
    }

    static int getbalance(Node root) {
        if (root == null) {
            return 0;
        }
        return cal_height(root.left) - cal_height(root.right);
    }

    static Node leftRotate(Node root) {
        Node X = root.right;
        Node Y = X.left;

        X.left = root;
        root.right = Y;
        root.height = Math.max(cal_height(root.left), cal_height(root.right)) + 1;
        X.height = Math.max(cal_height(X.left), cal_height(X.right)) + 1;
        return X;
    }

    static Node rightRotate(Node root) {
        Node X = root.left;
        Node Y = X.right;

        X.right = root;
        root.left = Y;
        root.height = Math.max(cal_height(root.left), cal_height(root.right)) + 1;
        X.height = Math.max(cal_height(X.left), cal_height(X.right)) + 1;
        return X;
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return (new Node(data));
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        if (data > root.data) {
            root.right = insert(root.right, data);
        }
        root.height = 1 + Math.max(cal_height(root.left), cal_height(root.right));

        int balance = getbalance(root);
        // left rotation
        if (balance < -1 && data > root.right.data) {
            return leftRotate(root);
        }
        // right rotation
        if (balance > 1 && data < root.left.data) {
            return rightRotate(root);
        }
        // right left rotation
        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // left right rotation
        if (balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    static void Levelorder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 11);
        root = insert(root, 21);
        root = insert(root, 32);
        root = insert(root, 45);
        root = insert(root, 52);
        root = insert(root, 27);
        Levelorder(root);
    }
}
