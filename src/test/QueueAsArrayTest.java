package test;

import algorithms.implementation.queue.QueueAsArray;
import algorithms.implementation.queue.QueueException;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by Colezea on 12/07/2015.
 */
public class QueueAsArrayTest {

    QueueAsArray queueAsArray;

    @Test
    public void test_functionality() throws QueueException{
        queueAsArray = new QueueAsArray();
        Assume.assumeTrue(queueAsArray.isEmpty());
        Assume.assumeTrue(queueAsArray.size() == 0);
        queueAsArray.enqueue("A");
        Assume.assumeTrue(!queueAsArray.isEmpty());
        Assume.assumeTrue(queueAsArray.size() == 1);
        queueAsArray.enqueue("B");
        Assume.assumeTrue(queueAsArray.dequeue() == "A");
        queueAsArray.enqueue("C");
        Assume.assumeTrue(queueAsArray.dequeue() == "B");
        Assume.assumeTrue(queueAsArray.size() == 1);
        Assume.assumeTrue(queueAsArray.dequeue() == "C");
        Assume.assumeTrue(queueAsArray.size() == 0);
        Assume.assumeTrue(queueAsArray.isEmpty());
        try {
            queueAsArray.dequeue();
        }
        catch (Exception e){
            Assert.assertThat(e, instanceOf(QueueException.class));
        }
    }
}
