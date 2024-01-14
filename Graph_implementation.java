import java.util.*;

public class Graph_implementation {
    static void addedge(int arr[][], int S, int D) {
        arr[S][D] = 1;
        arr[D][S] = 1;
    }

    public static void Addedgeusinglist(ArrayList<Integer> adj[], int S, int D) {
        adj[S].add(D);
        adj[D].add(S);
    }

    public static void main(String[] args) {

        // Using Adjancey Matrix
        // int V = 5;
        // int E = 6;
        // int arr[][] = new int[V + 1][V + 1];
        // addedge(arr, 1, 2);
        // addedge(arr, 1, 4);
        // addedge(arr, 1, 5);
        // addedge(arr, 4, 2);
        // addedge(arr, 4, 5);
        // addedge(arr, 3, 5);

        // for (int i = 0; i < V + 1; i++) {
        // for (int j = 0; j < V + 1; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }

        // Using Adjancey List
        int V = 5;
        int E = 6;
        ArrayList<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList();
        }
        Addedgeusinglist(adj, 0, 1);
        Addedgeusinglist(adj, 0, 4);
        Addedgeusinglist(adj, 1, 2);
        Addedgeusinglist(adj, 1, 3);
        Addedgeusinglist(adj, 1, 4);
        Addedgeusinglist(adj, 2, 3);
        Addedgeusinglist(adj, 3, 4);
        System.out.println(adj);
    }
}
