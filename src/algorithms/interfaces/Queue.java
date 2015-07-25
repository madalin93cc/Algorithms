package algorithms.interfaces;

import algorithms.implementation.queue.QueueException;

/**
 * Created by Colezea on 11/07/2015.
 */
public interface Queue<E> extends Iterable<E> {
    void enqueue(E s);
    E dequeue() throws QueueException;
    boolean isEmpty();
    int size();
    E peek() throws QueueException;
}
