
Problem Statement
Sameas Course Schedule, but now:

👉 Return the order of courses you should take
👉 If impossible → return empty array []

Example
Input:numCourses = 4
prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output:
[0,1,2,3]
  
🎯 Why This Is Important
Builds on Course Schedule
Introduces Topological Sorting (Order)
VERY frequently asked
🧠 Key Idea
👉 If no cycle → we can get a valid order
👉 Use Kahn’s Algorithm (BFS)

🧠 Approach

1️⃣ Build graph
2️⃣ Compute indegree
3️⃣ Add indegree = 0 nodes to queue
4️⃣ BFS:

remove node
reduce indegree
add new zero indegree nodes
5️⃣ Store order


  
CODE---


import java.util.*;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add indegree 0 nodes
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            result[index++] = node;

            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If cycle exists
        if (index != numCourses) {
            return new int[0];
        }

        return result;

 Pattern Used-
 Topological Sort
 BFS (Kahn’s Algorithm)
 DAG ordering

📊 Complexity

Time → O(V + E)
Space → O(V + E)
    
