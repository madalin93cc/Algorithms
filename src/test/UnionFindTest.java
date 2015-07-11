package test;

import algorithms.implementation.UnionFindImpl;
import org.junit.Assume;
import org.junit.Test;

/**
 * Created by Colezea on 11/07/2015.
 */
public class UnionFindTest {

    UnionFindImpl unionFindImpl;

    @Test
    public void test_functionality(){
        unionFindImpl = new UnionFindImpl(10);

        Assume.assumeTrue(unionFindImpl.count() == 10);
        for (int i = 0; i < 10; i++){
            for (int j = i + 1; j < 10; j++){
                Assume.assumeFalse(unionFindImpl.connected(i, j));
            }
        }
        unionFindImpl.union(0, 1);
        Assume.assumeTrue(unionFindImpl.connected(0, 1) == true);
        Assume.assumeTrue(unionFindImpl.connected(1, 0) == true);
        Assume.assumeTrue(unionFindImpl.count() == 9);
        unionFindImpl.union(2, 0);
        Assume.assumeTrue(unionFindImpl.connected(2, 1) == true);
        Assume.assumeTrue(unionFindImpl.connected(2, 0) == true);
        Assume.assumeTrue(unionFindImpl.count() == 8);
    }
}
