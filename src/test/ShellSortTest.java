package test;

import algorithms.implementation.sort.ShellSort;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Colezea on 06/09/2015.
 */
public class ShellSortTest {
    Integer arr[] = {new Integer(3), new Integer(2), new Integer(5), new Integer(1), new Integer(4)};
    Integer rez[] = {new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5)};

    @Test
    public void test_shell_sort(){
        ShellSort.sort(arr);
        Assert.assertArrayEquals(arr, rez);
    }
}
