package test;

import algorithms.implementation.sort.KnuthShuffle;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Colezea on 06/09/2015.
 */
public class KnuthShuffleTest {
    Integer arr[] = {new Integer(3), new Integer(2), new Integer(5), new Integer(1), new Integer(4)};

    @Test
    public void test_knuth_shuffle(){

        for (int i = 0; i < 5; i++) {
            Integer rez[] = Arrays.copyOf(arr, arr.length);
            KnuthShuffle.shuffle(rez);
            Assert.assertFalse(rez.equals(arr));
        }
    }

}
