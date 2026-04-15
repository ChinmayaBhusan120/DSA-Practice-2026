What is a Graph?

A Graph is a collection of:
- Nodes (Vertices)
- Edges (Connections)

  Types of Graphs

- Undirected Graph
- Directed Graph (Digraph)
- Weighted Graph
- Unweighted Graph
- Cyclic Graph
- Acyclic Graph (DAG)


 Graph Representation

 1️⃣ Adjacency List (Most Common)
    java
    List<List<Integer>> graph = new ArrayList<>();
 2️⃣ Adjacency Matrix
    int[][] graph = new int[n][n];

Graph Traversal Techniques
🔹 Depth First Search (DFS)
     Uses recursion or stack
     Explores as deep as possible

  CODE---->>>>
void dfs(int node) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor);
        }
    }
}

🔹 Breadth First Search (BFS)
      Uses queue
      Explores level by level
      
Queue<Integer> queue = new LinkedList<>();
queue.offer(start);

while (!queue.isEmpty()) {
    int node = queue.poll();

    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            queue.offer(neighbor);
        }
    }
}

🧩 Grid-Based Graph Problems

    Many problems use a 2D grid, where:
    Each cell = node
    Movement = edges

Example directions:int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
                                    
Common Graph Problems
Number of Islands
Flood Fill
Rotting Oranges
Clone Graph
Course Schedule (Topological Sort)
Number of Provinces
Shortest Path (Dijkstra / BFS)


Complexity
Algorithm	Time Complexity
DFS	O(V + E)
BFS	O(V + E)

Where:
V = number of vertices
E = number of edges
