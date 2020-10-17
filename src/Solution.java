import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] ints : prerequisites) {
            edges.get(ints[1]).add(ints[0]);
        }
        // 状态表，0表示从未被搜索过，1表示搜索中，2表示已经完成搜索
        int[] state = new int[numCourses];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                boolean result = dfs(state, edges, i, stack);
                if (!result) {
                    return new int[0];
                }
            }
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    private boolean dfs(int[] state, List<List<Integer>> edges, int node, LinkedList<Integer> stack) {
        if (state[node] == 1) {
            return false;
        }
        if (state[node] == 2) {
            return true;
        }
        state[node] = 1;
        for (int adjacentNode : edges.get(node)) {
            boolean result = dfs(state, edges, adjacentNode, stack);
            if (!result) {
                return false;
            }
        }
        state[node] = 2;
        stack.push(node);
        return true;
    }
}