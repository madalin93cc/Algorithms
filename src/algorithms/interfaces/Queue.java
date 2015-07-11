package algorithms.interfaces;

/**
 * Created by Colezea on 11/07/2015.
 */
public interface Queue {
    void enqueue(String s);
    String dequeue();
    boolean isEmpty();
    int size();
}
