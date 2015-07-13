package algorithms.interfaces;

import algorithms.implementation.stack.StackException;

/**
 * Created by Madalin.Colezea on 7/13/2015.
 */
public interface ArithmeticalExpresionEvaluation {
    Double evaluate() throws StackException;
    Double evaluate(String expression) throws StackException;
}
