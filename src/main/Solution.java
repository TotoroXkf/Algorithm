package main;

import struct.Node;

public class Solution {
    public Node connect(Node root) {
        connectInternal(null, root);
        return root;
    }

    public void connectInternal(Node parent, Node child) {
        // 连接当前的这一层
        Node tempParent = parent;
        Node tempChild = child;
        while (tempParent != null) {
            if (tempParent.left != null && tempParent.left != tempChild) {
                tempChild.next = tempParent.left;
                tempChild = tempParent.left;
                continue;
            } else if (tempParent.right != null && tempParent.right != tempChild) {
                tempChild.next = tempParent.right;
                tempChild = tempParent.right;
                tempParent = tempParent.next;
                continue;
            }
            tempParent = tempParent.next;
        }
        // 寻找下一层的起始节点，递归这个节点，开始下一层
        tempChild = child;
        while (tempChild != null) {
            if (tempChild.left != null) {
                parent = tempChild;
                child = tempChild.left;
                connectInternal(parent, child);
                break;
            } else if (tempChild.right != null) {
                parent = tempChild;
                child = tempChild.right;
                connectInternal(parent, child);
                break;
            }
            tempChild = tempChild.next;
        }
    }
}