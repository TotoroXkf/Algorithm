package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = createGraph(prerequisites);
        Set<Integer> courseSet = new HashSet<>();
        // for (int i = 0; i < prerequisites.length; i++) {
        // int depend = prerequisites[i][0];
        // int course = prerequisites[i][1];
        // if (graph.containsKey(depend)) {

        // } else {

        // }
        // }
        return true;
    }

    private Map<Integer, Set<Integer>> createGraph(int[][] prerequisites) {
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int depend = prerequisite[0];
            int course = prerequisite[1];
            if (result.containsKey(depend)) {
                result.get(depend).add(course);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(course);
                result.put(depend, set);
            }
        }
        return result;
    }
}