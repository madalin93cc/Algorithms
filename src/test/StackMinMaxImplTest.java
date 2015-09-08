package test;

import algorithms.implementation.stack.StackException;
import algorithms.implementation.stack.StackMinMaxImpl;
import algorithms.interfaces.StackMinMax;
import org.junit.Assume;
import org.junit.Test;

/**
 * Created by Colezea on 25/07/2015.
 */
public class StackMinMaxImplTest {

    StackMinMax<Integer> stackMinMax;

    @Test
    public void test_functionality() throws StackException{
        stackMinMax = new StackMinMaxImpl();
        stackMinMax.push(1);
        stackMinMax.push(2);
        Assume.assumeTrue(stackMinMax.min().compareTo(1) == 0);
        Assume.assumeTrue(stackMinMax.max().compareTo(2) == 0);

        stackMinMax.push(3);
        Assume.assumeTrue(stackMinMax.max().compareTo(3) == 0);

        stackMinMax.push(0);
        Assume.assumeTrue(stackMinMax.min().compareTo(0) == 0);

        stackMinMax.pop();
        Assume.assumeTrue(stackMinMax.min().compareTo(1) == 0);

        stackMinMax.pop();
        Assume.assumeTrue(stackMinMax.max().compareTo(2) == 0);
    }
}
