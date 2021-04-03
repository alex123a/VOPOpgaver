package test;

import org.junit.Before;
import org.junit.Test;
import vop.RecursiveBinarySearch;


import static org.junit.Assert.*;

public class RecursiveBinarySearchTest {
    private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    @Before
    public void setUp() throws Exception {
    }

    private boolean shouldFindIndexOfNumber() {
        int result = RecursiveBinarySearch.recursiveFind(FIBOS, 13);
        return result >= 0 ? true : false;
    }

    private boolean shouldReturnNegativeInsertionPointWhenNotFound() {
        int result = RecursiveBinarySearch.recursiveFind(FIBOS, 14);
        return result >= 0 ? true : false;
    }

    @Test
    public void recursiveFind() {
        assertTrue(shouldFindIndexOfNumber());
        assertFalse(shouldReturnNegativeInsertionPointWhenNotFound());
    }
}