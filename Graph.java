
/*
 * Graph is a non-linear data structure(linked list) consisting vertices and
 * edges.
 * Two components of graph :-
 * Vertices - Nodes
 * Edges - Relation between two nodes
 * 
 * Types of graphs:-
 * Null Graphs: only vertices present edges not there data stored in different
 * arrays
 * 3
 * 5 1
 * 4
 * Trival Graphs: has only single node or vertices
 * 2
 * Directed Graphs: every nodes connected to every other node with arrows if
 * a---->b a can access b but b cannot access a
 * Connected Graph: all nodes are connected with each other
 * Disconnected Graph : there will be n number of list possible and list are
 * connect to each other
 * Complete graph : where all nodes are connected with each and every nodes
 * Cyclic graph : one node is disconnect and form a cycle so if we have to go to
 * that node we take help of any other nodes connected graph is cucle graph
 * 
 * Representation Of graph :
 * Adjacency matrix - have to use 2d array
 * Adjacency List - have to use linkedlist
 * 
 * => size of 2d matrix is no of vertices+1 n*n
 * 3
 * / \
 * 2 1
 * \ /
 * 4
 * using matrix
 * Intially 2d matrix is:-
 * 1 2 3 4
 * 1 0 0 1 1
 * 2 0 0 1 1
 * 3 1 1 0 0
 * 4 1 1 0 0
 * 
 * using list
 * 3 6
 * / \ / |
 * 2 1 |
 * \ / \ |
 * 4-------5
 * 
 * 1 - 3 6 4 5
 * 2 - 3 4
 * 3 - 2 1
 * 4 - 2 1 5
 * 5 - 4 1 6
 * 6 - 1 5
 * 
 * Comparison of matrix and list : Adding edges and deleting a edges and
 * intialize a edge
 * Matrix List
 * Adding Edge - O(1) O(1)
 * Delting Edge - O(1) O(N)
 * Intializing - O(N*N) O(N)
 * 
 * If adding and deleting freqrently use matrix and else we use list (searching
 * more deleting and adding less)
 * 
 * Basic operations of Graphs:-
 * Insert
 * Delete
 * Search
 * Traverse(BFS & DFS)
 * 1
 * / \
 * 2 3
 * \ / \
 * 4 7
 * / \
 * 5 6
 * 
 * Queue: 1X 2X 3X 4X 7X 5X 6X queue is empty break the loop
 * BFS :- 1 2 3 4 7 5 6
 * Array for visited or not : 1 2 3 4 7 6
 * 
 * 
 * DFS :- 1 2 4 5 6 3 7
 * Array - 1 2 4 5 6 3 7
 * Stack - empty stack
 * 
 */