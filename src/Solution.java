import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] ints : prerequisites) {
            edges.get(ints[1]).add(ints[0]);
        }
        // 状态表，0表示从未被搜索过，1表示搜索中，2表示已经完成搜索
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                boolean result = dfs(state, edges, i);
                if (!result) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[] state, List<List<Integer>> edges, int node) {
        if (state[node] == 1) {
            return false;
        }
        if (state[node] == 2) {
            return true;
        }
        state[node] = 1;
        for (int adjacentNode : edges.get(node)) {
            boolean result = dfs(state, edges, adjacentNode);
            if (!result) {
                return false;
            }
        }
        state[node] = 2;
        return true;
    }
}