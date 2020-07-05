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
        int[] array = new int[]{1, 2, 3, 4, 5};
        assert solution.maxProfit(array) == 4;

        array = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        assert solution.maxProfit(array) == 6;

        array = new int[]{6, 1, 3, 2, 4, 7};
        assert solution.maxProfit(array) == 7;

        array = new int[]{7, 6, 5, 4, 3, 2, 1};
        assert solution.maxProfit(array) == 0;
    }
} 
