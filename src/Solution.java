import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Solution {
    /**
     * 相当于是对图结构的遍历了
     * 可以用dfs，也可以用bfs
     * 相对来说，dfs的写法更加简单
     * 设计一个递归函数，传入一个节点，clone这个节点
     * 然后遍历这个节点的相邻节点，如果之前遍历过了，就取出对应的节点加到clone节点的相邻节点里面
     * 不存在的话就递归这个节点，结束之后在添加即可
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return cloneGraph(node, new HashMap<>());
    }

    private Node cloneGraph(Node node, HashMap<Node, Node> hashMap) {
        Node cloneNode = new Node(node.val);
        hashMap.put(node, cloneNode);
        node.neighbors.forEach(eachNode -> {
            if (hashMap.containsKey(eachNode)) {
                cloneNode.neighbors.add(hashMap.get(eachNode));
                return;
            }
            cloneGraph(eachNode, hashMap);
            cloneNode.neighbors.add(hashMap.get(eachNode));
        });
        return cloneNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}