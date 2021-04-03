package test;

import org.junit.Before;
import org.junit.Test;
import vop.IterativeBinarySearch;

import static org.junit.Assert.*;

public class IterativeBinarySearchTest {

    private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    @Before
    public void setUp() throws Exception {
    }

    private boolean shouldFindIndexOfNumber() {
        int result = IterativeBinarySearch.find(FIBOS, 13);
        return result >= 0 ? true : false;
    }

    private boolean shouldReturnNegativeInsertionPointWhenNotFound() {
        int result = IterativeBinarySearch.find(FIBOS, 14);
        return result >= 0 ? true : false;
    }

    @Test
    public void testFind() {
        assertTrue(shouldFindIndexOfNumber());
        assertFalse(shouldReturnNegativeInsertionPointWhenNotFound());
    }

}
