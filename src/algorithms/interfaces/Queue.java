package algorithms.interfaces;

import algorithms.implementation.queue.QueueException;

/**
 * Created by Colezea on 11/07/2015.
 */
public interface Queue {
    void enqueue(String s);
    String dequeue() throws QueueException;
    boolean isEmpty();
    int size();
}
