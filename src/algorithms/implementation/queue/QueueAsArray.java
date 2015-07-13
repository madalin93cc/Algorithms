package algorithms.implementation.queue;

import algorithms.interfaces.Queue;

import java.util.Iterator;

/**
 * Coada folosing resizable array
 * operatie deq costisitoare
 * operatie enq liniara
 * TODO head si tail modulo capacity pentru deq eficien
 */
public class QueueAsArray<E> implements Queue<E> {

    E [] queue;
    private int N;

    public QueueAsArray() {
        queue = (E[]) new Object[1];
        N = 0;
    }

    @Override
    public void enqueue(E s) {
        if (N == queue.length)
            resize(queue.length * 2);
        queue[N++] = s;
    }

    @Override
    public E dequeue() throws QueueException{
        if (N == 0) throw new QueueException("coada goala");
        E item = queue[0];
        for (int i = 0; i < N - 1; i++){
            queue[i] = queue[i + 1];
        }
        queue[--N] = null;
        if (N > 0 && N == queue.length / 4)
            resize(queue.length / 2);
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    private void resize(int size){
        E[] new_queue = (E[])new Object[size];
        for(int i = 0; i < N; i++){
            new_queue[i] = queue[i];
        }
        queue = new_queue;
    }

    @Override
    public Iterator<E> iterator(){
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E>{
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public E next() {
            return queue[i++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
