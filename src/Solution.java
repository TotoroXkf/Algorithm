import java.util.HashMap;

public class Solution {
    public Node copyRandomList(Node head) {
        return copyRandomList(head, new HashMap<>());
    }

    private Node copyRandomList(Node head, HashMap<Node, Node> hashMap) {
        if (head == null) {
            return null;
        }
        if (hashMap.containsKey(head)) {
            return hashMap.get(head);
        }
        Node cloneNode = new Node(head.val);
        hashMap.put(head, cloneNode);
        cloneNode.next = copyRandomList(head.next, hashMap);
        cloneNode.random = copyRandomList(head.random, hashMap);
        return cloneNode;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
