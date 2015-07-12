package test;

import algorithms.implementation.queue.QueueAsLinkedList;
import algorithms.implementation.queue.QueueException;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by Colezea on 11/07/2015.
 */
public class QueueAsLinkedListTest {
    QueueAsLinkedList queueAsLinkedList;

    @Test
    public void test_functionality() throws QueueException{
        queueAsLinkedList = new QueueAsLinkedList();
        Assume.assumeTrue(queueAsLinkedList.isEmpty());
        Assume.assumeTrue(queueAsLinkedList.size() == 0);
        queueAsLinkedList.enqueue("A");
        Assume.assumeTrue(!queueAsLinkedList.isEmpty());
        Assume.assumeTrue(queueAsLinkedList.size() == 1);
        queueAsLinkedList.enqueue("B");
        Assume.assumeTrue(queueAsLinkedList.dequeue() == "A");
        queueAsLinkedList.enqueue("C");
        Assume.assumeTrue(queueAsLinkedList.dequeue() == "B");
        Assume.assumeTrue(queueAsLinkedList.size() == 1);
        Assume.assumeTrue(queueAsLinkedList.dequeue() == "C");
        Assume.assumeTrue(queueAsLinkedList.size() == 0);
        Assume.assumeTrue(queueAsLinkedList.isEmpty());
        try {
            queueAsLinkedList.dequeue();
        }
        catch (Exception e){
            Assert.assertThat(e, instanceOf(QueueException.class));
        }
    }
}
