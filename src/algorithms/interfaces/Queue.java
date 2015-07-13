package algorithms.interfaces;

import algorithms.implementation.queue.QueueException;

import java.util.Iterator;

/**
 * Created by Colezea on 11/07/2015.
 */
public interface Queue<E> extends Iterable<E> {
    void enqueue(E s);
    E dequeue() throws QueueException;
    boolean isEmpty();
    int size();
}
