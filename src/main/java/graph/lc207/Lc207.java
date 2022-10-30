package graph.lc207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Lc207 {

    //BFS
    public boolean canFinishByBfs(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);

        // How many courses don't need prerequisites.
        int canFinishCount = queue.size();
        while (!queue.isEmpty()) {
            int prerequisite = queue.remove(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        canFinishCount++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return (canFinishCount == numCourses);
    }


    //DFS
    HashMap<Integer, Boolean> memo = new HashMap<Integer, Boolean>();//Memorization HashMap for DFS pruning
    public boolean canFinishByDfs(int n, int[][] edges) {
        if (edges.length != 0) {
            HashMap<Integer, HashSet<Integer>> neighbors = new HashMap<Integer, HashSet<Integer>>(); // Neighbors of each node
            HashSet<Integer>curPath = new HashSet<Integer>(); // Nodes on the current path
            for (int i = 0; i < edges.length; i++) {// Convert graph presentation from edge list to adjacency list
                if (!neighbors.containsKey(edges[i][1]))
                    neighbors.put(edges[i][1], new HashSet<Integer>());
                neighbors.get(edges[i][1]).add(edges[i][0]);
            }

            for (int a[] : edges) // The graph is possibly not connected, so need to check every node.
                if (hasCycle(neighbors, a[0], -1, curPath))// Use DFS method to check if there's cycle in any curPath
                    return false;
        }
        return true;
    }

    boolean hasCycle(HashMap<Integer, HashSet<Integer>> neighbors, int kid, int parent, HashSet<Integer>curPath) {
        if (memo.containsKey(kid)) return memo.get(kid);
        if (curPath.contains(kid)) return true;// The current node is already in the set of the current path
        if (!neighbors.containsKey(kid)) return false;

        curPath.add(kid);
        for (Integer neighbor : neighbors.get(kid)) {
            boolean hasCycle = hasCycle(neighbors, neighbor, kid, curPath);// DFS
            memo.put(neighbor, hasCycle); // Bug was here
            if (hasCycle) return true;
        }
        curPath.remove(kid);
        return false;
    }
}
