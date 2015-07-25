package algorithms.implementation.stack;

import algorithms.interfaces.Stack;

import java.util.Iterator;

/**
 * Implementare de stiva folosint array
 * + fiecare operatie ia un timp constant amortizat
 * + mai putin spatiu folosit
 * - in worst case o opertie de push/ pop dureaza O(N)
 * + timp total mai buna ca linked list implementation
 */
public class StackAsArray<E> implements Stack<E>{
    private E[] stack = null;
    private int N = 0;

    public StackAsArray(){
        stack = (E[])new Object[1];
    }

    @Override
    public void push(E s) throws StackException{
        if (N == stack.length)
            resize(stack.length * 2);
        stack[N++] = s;
    }

    @Override
    public E pop() throws StackException{
        if (N == 0) throw new StackException("Stiva goala");
        E item = stack[--N];
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

    @Override
    public E peek() throws StackException {
        return stack[N - 1];
    }

    private void resize(int dimension){
        E[] new_stack = (E[])new Object[dimension];
        for (int i = 0; i < N; i++){
            new_stack[i] = stack[i];
        }
        stack = new_stack;
    }

    @Override
    public Iterator<E> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E>{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public E next() {
            return stack[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
