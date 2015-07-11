package test;

import algorithms.implementation.stack.StackAsArray;
import algorithms.implementation.stack.StackException;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by Madalin.Colezea on 7/10/2015.
 */
public class StackAsArrayTest {

    StackAsArray stackAsArray;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_push_and_pop() throws StackException{
        stackAsArray = new StackAsArray();

        stackAsArray.push("A");
        Assume.assumeTrue(stackAsArray.size() == 1);
        stackAsArray.push("B");
        Assume.assumeTrue(stackAsArray.size() == 2);
        Assume.assumeTrue(stackAsArray.pop() == "B");
        Assume.assumeTrue(stackAsArray.size() == 1);
        Assume.assumeFalse(stackAsArray.isEmpty());
        Assume.assumeTrue(stackAsArray.pop() == "A");
        Assume.assumeTrue(stackAsArray.isEmpty());
        stackAsArray.push("C");
        stackAsArray.push("D");
        stackAsArray.push("");
    }

    /* pentru situatia in care nu se folosea redimensionarea array-ului
    * trebuie modificat si in implementare pentru ca exceptia sa fie auncata
    * */
    @Test
    public void test_overflow_exception() throws StackException{
        stackAsArray = new StackAsArray();
        stackAsArray.push("A");
        stackAsArray.push("B");
        try {
            stackAsArray.push("C");
        }
        catch (Exception e){
            Assert.assertThat(e, instanceOf(StackException.class));
        }

    }

    @Test
    public void test_underflow_exception() throws StackException{
        expectedException.expect(StackException.class);
        expectedException.expectMessage("Stiva goala");

        stackAsArray = new StackAsArray();
        stackAsArray.pop();
    }
}
