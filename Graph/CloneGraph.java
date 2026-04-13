Problem Statement

You are given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.

Each node contains:

value
list of neighbors
Example
1 --- 2
|     |
4 --- 3

Output:
👉 Exact same structure but new nodes (deep copy)

🧠 Key Idea

We need to:

✔ Copy each node
✔ Maintain connections
✔ Avoid infinite loops

🧠 Important Trick

Use a HashMap:
Original Node → Cloned Node
This helps:
Avoid revisiting nodes
Build connections correctly
🧠 Approach (DFS)

1️⃣ If node already cloned → return it
2️⃣ Create clone
3️⃣ Store in map
4️⃣ Recursively clone neighbors



CODE---->>>>>>>>>
import java.util.*;

class CloneGraph {

    public Node cloneGraph(Node node) {

        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();

        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }

        return clone;
    }
}
