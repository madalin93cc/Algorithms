package test;

import algorithms.implementation.stack.StackAsLinkedList;
import algorithms.implementation.stack.StackException;
import org.junit.Assume;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by Madalin.Colezea on 7/10/2015.
 */
public class StackAsLinkedListTest {

    StackAsLinkedList<String> stackAsLinkedList;

    @Test
    public void test_push_and_pop() throws StackException{
        stackAsLinkedList = new StackAsLinkedList();
        stackAsLinkedList.push("A");
        Assume.assumeTrue(stackAsLinkedList.size() == 1);
        stackAsLinkedList.push("B");
        Assume.assumeTrue(stackAsLinkedList.size() == 2);
        Assume.assumeTrue(stackAsLinkedList.pop() == "B");
        Assume.assumeTrue(stackAsLinkedList.size() == 1);
        Assume.assumeFalse(stackAsLinkedList.isEmpty());
        Assume.assumeTrue(stackAsLinkedList.pop() == "A");
        Assume.assumeTrue(stackAsLinkedList.isEmpty());
    }

    @Test
    public void test_stack_exception() throws StackException{
        stackAsLinkedList = new StackAsLinkedList();

        try {
            stackAsLinkedList.pop();
        }
        catch (Exception e){
            Assume.assumeThat(e, instanceOf(StackException.class));
        }
    }

    @Test
    public void test_iterator(){
        stackAsLinkedList = new StackAsLinkedList();
        Iterator<String> iterator = stackAsLinkedList.iterator();
        Assume.assumeFalse(iterator.hasNext());
        stackAsLinkedList.push("A");
        iterator = stackAsLinkedList.iterator();
        Assume.assumeTrue(iterator.hasNext());
        stackAsLinkedList.push("B");
        stackAsLinkedList.push("C");
        for (String s: stackAsLinkedList){
            System.out.println(s);
        }
    }
}
