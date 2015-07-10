package algorithms.implementation.stack;

import algorithms.interfaces.Stack;

/**
 * Created by Madalin.Colezea on 7/10/2015.
 */
public class StackAsArray implements Stack{
    private String[] stack = null;
    private int N = 0, max;

    public StackAsArray(int N){
        this.max = N;
        stack = new String[N];
    }

    @Override
    public void push(String s) throws StackException{
        if (N == max) throw new StackException("Stiva plina");
        stack[N++] = s;
    }

    @Override
    public String pop() throws StackException{
        if (N == 0) throw new StackException("Stiva goala");
        String item = stack[--N];
        stack[N] = null;
        return item;
    }

    @Override
    public boolean isEmpty(){
        return N == 0;
    }

    @Override
    public int size(){
        return N;
    }
}
