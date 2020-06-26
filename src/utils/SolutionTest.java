package utils;

import org.junit.Test;

import main.Solution;
import struct.Node;
import utils.Case;

public class SolutionTest {
    private Solution solution = new Solution();
    private Case testCase = new Case();

    @Test
    public void test() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        solution.connect(root);
        System.out.println();
    }
} 
