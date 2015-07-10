package algorithms.interfaces;

import algorithms.implementation.stack.StackException;

/**
 * Created by Madalin.Colezea on 7/10/2015.
 */
public interface Stack {
    void push (String s) throws StackException;
    String pop() throws StackException;
    boolean isEmpty();
    int size();
}
