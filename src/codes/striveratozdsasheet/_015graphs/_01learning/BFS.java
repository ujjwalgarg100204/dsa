package codes.striveratozdsasheet._015graphs._01learning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * BFS
 */
public class BFS {

    public String getProblemLink() {
        return "https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1";
    }

    public ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> traversal = new ArrayList<>();

        boolean[] visited = new boolean[V];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);

        while (!q.isEmpty()) {
            int v = q.poll();
            // check if the vertex has already been visited
            if (visited[v])
                continue;
            // mark the vertex as visited
            visited[v] = true;
            // add the vertex to traversal array
            traversal.add(v);
            // add all neighbours of curr vertex to queue
            adj.get(v).forEach(q::offer);
        }

        return traversal;
    }
}
