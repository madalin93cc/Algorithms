package algorithms.interfaces;

import algorithms.implementation.stack.StackException;

/**
 * Created by Colezea on 25/07/2015.
 */
public interface StackMinMax<E> extends Stack<E> {
    E min() throws StackException;
    E max() throws StackException;
}
