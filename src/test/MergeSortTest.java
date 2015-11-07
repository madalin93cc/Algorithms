package test;

import algorithms.implementation.sort.InsertionSort;
import algorithms.implementation.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by colez on 08/11/2015.
 */
public class MergeSortTest {
    Integer arr[] = {new Integer(3), new Integer(2), new Integer(5), new Integer(1), new Integer(4)};
    Integer rez[] = {new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5)};

    @Test
    public void test_insertion_sort(){
        MergeSort.sort(arr);
        Assert.assertArrayEquals(arr, rez);
    }
}
