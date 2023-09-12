package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    Map<Integer, Set<Integer>> dependOn = new HashMap<>();
    Set<Integer> record = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        traversal(prerequisites);
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            boolean dfsResult = dfs(course, new HashSet<>());
            if (!dfsResult) {
                return false;
            }
        }
        return true;
    }

    private void traversal(int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int depend = prerequisite[1];
            if (!dependOn.containsKey(course)) {
                Set<Integer> set = new HashSet<>();
                dependOn.put(course, set);
            }
            if (!dependOn.containsKey(depend)) {
                Set<Integer> set = new HashSet<>();
                dependOn.put(depend, set);
            }
            dependOn.get(course).add(depend);
        }
    }

    private boolean dfs(int course, HashSet<Integer> dfsRecord) {
        if (record.contains(course)) {
            return true;
        }
        if (dfsRecord.contains(course)) {
            return false;
        }
        dfsRecord.add(course);
        for (int depend : dependOn.get(course)) {
            boolean dfsResult = dfs(depend, dfsRecord);
            if (!dfsResult) {
                return false;
            }
        }
        record.add(course);
        return true;
    }

    public static void main(String[] args) {
        new Solution().canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1},});
    }
}