/*
        * Binary Trees -
        * parameters
        * data
        * address of left child
        * address of right child
        * 
        * At each level of i ,maximum number of nodes is 2 power i
        * *************1
        * *******2********** 3
        * ****4****5 *****6 ****** 7
        * Operations on tree:- Add,delete, search traversing ,updating element in  ologn complexity
        * Extra operations - height of tree , find level of tree ,find total number of nodes 

        Binary tree traversals - 
        1. DFS(Depth first search)
        2. BFS(Breadth first Search)
        3. Boundary Traversal
        4. Dioganl Traversal

        * *************1
        * *******2**********3
        * ****4****5 *****6 ****** 7

        1.DFS(Depth First search) - 
        inorder : 4 2 5 1 6 3 7 LNR
        preorder : 1 2 4 5 3 6 7 NLR
        postorder : 5 5 2 6 7 3 1  LRN

        2. BFS -
        Levelorder : 1 2 3 4 5 6 7

        3. Boundry Traversal - take only boundry value -  1 2 4 5 6 7 3
        4. Diagonal Traversal - 1 3 7 2 5 only right child will taken


        Types Of Binary Tress:-
        Based on number of childrens
        1. Full Binary tree 
        2. Degenrated Binary tree
        3. Skewed Binary tree
        4.


            1. Full Binary tree (With two child or no child) 
            2. Degenrated Binary tree - Has only one child either left or right
                            10
                            /
                            2 
                             \ 
                              6 
                                \ 
                                12
            3. Skewed Binary tree - left or right only one
                            10
                            /
                          8    left Skewed tree
                        /
                       6
            
        Based on completions of levels - 
            1. Complete binary tree - left child is compulsory right not
            2. Perfect binary tree - all child are complusory
            3. Balanced binary tree - differnce of height of left and right child is alawys less then 1.
        
            Special Types of Trees
                1. Binary Search Tree
                2. AVL Tree
                3. Red Black Tree
                4. B Tree
                5. B+ Tree
                6. Segment Tree
            
            Binary Search Tree - 
                      8 
                    /    \ 
                  3       9
                 /  \      \
                1    4     12
                 \        /
                  2      10 

                  key points - if node is less than root node it will insert at left
                               if node is greater than root node it will insert at right
                               10
                             /    \    
                            5      11
                           / \       \
                          2   7       14
                            / \
                           6   8

         Implementations of tree done in two ways 
         linked reperstations 
         sequential using array 
        */

// Binary seacrh tree Implementations
import java.util.*;

class Trees {

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

  // Inorder
  public static void inorder(Node root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  // Preorder
  public static void preorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  // Postorder
  public static void postorder(Node root) {
    if (root == null) {
      return;
    }
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data + " ");
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

  public static void main(String[] args) {
    Node root = null;
    root = insertNode(root, 8);
    insertNode(root, 3);
    insertNode(root, 10);
    insertNode(root, 12);
    insertNode(root, 15);
    inorder(root);
    System.out.println();
    postorder(root);
    System.out.println();
    preorder(root);
    System.out.println();
    Levelorder(root);
  }
}
