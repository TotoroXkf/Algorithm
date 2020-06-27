package utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import main.Solution;
import struct.Node;
import utils.Case;

public class SolutionTest {
    private Solution solution = new Solution();
    private Case testCase = new Case();

    @Test
    public void test() {
        List<List<Integer>> triangl = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangl.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangl.add(list2);
        int result = solution.minimumTotal(triangl);
        assert result == 5;
    }
} 
