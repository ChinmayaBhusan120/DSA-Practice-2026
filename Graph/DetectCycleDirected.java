import java.util.*;

class DetectCycleDirected {

    public boolean isCycle(int V, List<List<Integer>> graph) {

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, pathVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node, List<List<Integer>> graph,
                        boolean[] visited, boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, graph, visited, pathVisited)) {
                    return true;
                }
            }
            else if (pathVisited[neighbor]) {
                return true; // cycle found
            }
        }

        pathVisited[node] = false; // backtrack
        return false;
    }
}
