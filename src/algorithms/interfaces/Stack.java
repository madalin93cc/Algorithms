package algorithms.interfaces;

import algorithms.implementation.stack.StackException;

/**
 * Created by Madalin.Colezea on 7/10/2015.
 */
public interface Stack<E> extends Iterable<E>{
    void push (E s) throws StackException;
    E pop() throws StackException;
    boolean isEmpty();
    int size();
}
