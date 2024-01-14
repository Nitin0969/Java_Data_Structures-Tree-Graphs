import java.util.Iterator;
import java.util.*;

public class DFS_OF_GRAPH {
    private int V;
    private LinkedList<Integer> adj[];

    DFS_OF_GRAPH(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdgeinDFS(int v, int w) {
        adj[v].add(w);
    }

    void DFSutil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSutil(n, visited);
            }
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSutil(v, visited);
    }

    public static void main(String[] args) {
        DFS_OF_GRAPH g = new DFS_OF_GRAPH(4);
        g.addEdgeinDFS(0, 1);
        g.addEdgeinDFS(0, 2);
        g.addEdgeinDFS(1, 2);
        g.addEdgeinDFS(2, 0);
        g.addEdgeinDFS(2, 3);
        g.addEdgeinDFS(3, 3);

        g.DFS(2);

    }
}
