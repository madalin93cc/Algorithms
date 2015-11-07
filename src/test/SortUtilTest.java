package test;

import algorithms.implementation.sort.SortUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Colezea on 06/09/2015.
 */
public class SortUtilTest {

    @Test
    public void test_less(){
        Assert.assertTrue(SortUtil.less(new Integer(0), new Integer(1)));
        Assert.assertFalse(SortUtil.less(new Integer(1), new Integer(0)));
        Assert.assertFalse(SortUtil.less(new Integer(1), new Integer(1)));
    }

    @Test
    public void test_xchg(){
        Integer [] arr = {new Integer(0), new Integer(1), new Integer(2)};
        Integer [] rez = {new Integer(2), new Integer(1), new Integer(0)};
        SortUtil.xchg(arr, 0, 2);
        Assert.assertArrayEquals(arr, rez);
    }
}
