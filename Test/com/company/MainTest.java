package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kristin on 7/17/2015.
 */
public class MainTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPartition() throws Exception {
        Main tester = new Main();
        int[] arr = new int[]{7, 5, 1, 4, 8, 3, 10, 2, 6, 9};
        Main.partition(arr,"first",0,arr.length);
        int[] arrsorted = new int[]{1,2,3,4,5,6,7,8,9,10};
        assertEquals("The array is sorted.", Arrays.toString(arrsorted), Arrays.toString(arr));


    }

    @Test
    public void testData() throws Exception {

    }
}