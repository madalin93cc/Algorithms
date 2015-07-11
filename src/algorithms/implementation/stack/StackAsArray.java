package algorithms.implementation.stack;

import algorithms.interfaces.Stack;

/**
 * Implementare de stiva folosint array
 * + fiecare operatie ia un timp constant amortizat
 * + mai putin spatiu folosit
 * - in worst case o opertie de push/ pop dureaza O(N)
 * + timp total mai buna ca linked list implementation
 */
public class StackAsArray implements Stack{
    private String[] stack = null;
    private int N = 0;

    public StackAsArray(){
        stack = new String[1];
    }

    @Override
    public void push(String s) throws StackException{
        if (N == stack.length)
            resize(stack.length * 2);
        stack[N++] = s;
    }

    @Override
    public String pop() throws StackException{
        if (N == 0) throw new StackException("Stiva goala");
        String item = stack[--N];
        stack[N] = null;
        if (N > 0 && N == stack.length / 4)
            resize(stack.length / 2);
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

    private void resize(int dimension){
        String [] new_stack = new String[dimension];
        for (int i = 0; i < N; i++){
            new_stack[i] = stack[i];
        }
        stack = new_stack;
    }
}
