package algorithms.implementation.queue;

import algorithms.interfaces.Queue;

/**
 * Coada folosing resizable array
 * operatie deq costisitoare
 * operatie enq liniara
 * TODO head si tail modulo capacity pentru deq eficien
 */
public class QueueAsArray implements Queue {

    String [] queue;
    private int N;

    public QueueAsArray() {
        queue = new String[1];
        N = 0;
    }

    @Override
    public void enqueue(String s) {
        if (N == queue.length)
            resize(queue.length * 2);
        queue[N++] = s;
    }

    @Override
    public String dequeue() throws QueueException{
        if (N == 0) throw new QueueException("coada goala");
        String item = queue[0];
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
        String[] new_queue = new String[size];
        for(int i = 0; i < N; i++){
            new_queue[i] = queue[i];
        }
        queue = new_queue;
    }
}
