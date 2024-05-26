import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * DFS
 */
public class DFS {

    public String getProblemLink() {
        return "https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1";
    }

    public ArrayList<Integer> dfsIterative(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> traversal = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[V];

        stack.push(0);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            // mark curr node as visited
            if (!visited[curr]) {
                traversal.add(curr);
                visited[curr] = true;
            }

            // add its neighour to stack
            for (int i = adj.get(curr).size() - 1; i >= 0; i--) {
                if (!visited[adj.get(curr).get(i)]) {
                    stack.push(adj.get(curr).get(i));
                }
            }
        }

        return traversal;
    }

    public ArrayList<Integer> dfsRecursive(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> traversal = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfsUtil(adj, 0, visited, traversal);

        return traversal;
    }

    private void dfsUtil(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] visited, ArrayList<Integer> traversal) {
        // check if current node is visited
        if (visited[curr]) {
            return;
        }
        // mark current node as visited
        visited[curr] = true;
        // mark current node as traversed
        traversal.add(curr);

        // visit all neighbours of curr node
        for (int i : adj.get(curr)) {
            dfsUtil(adj, i, visited, traversal);
        }
    }

}
