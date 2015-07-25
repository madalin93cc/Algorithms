package algorithms.implementation.queue;

import algorithms.interfaces.Queue;

import java.util.Iterator;

/**
 * Coada implementata ca linked list
 * enq si deq liniare
 */
public class QueueAsLinkedList<E> implements Queue<E> {

    private Node first, last;
    private int N = 0;

    private class Node{
        E item;
        Node next;

        Node(E item){
            this.item = item;
        }
    }

    @Override
    public void enqueue(E s) {
        Node oldlast = last;
        last = new Node(s);
        if (isEmpty()){
            first = last;
        }
        else {
            oldlast.next = last;
        }
        N++;
    }

    @Override
    public E dequeue() throws QueueException{
        if (N == 0) throw new QueueException("coada goala");
        E item = first.item;
        first = first.next;
        if (isEmpty()){
            last = null;
        }
        N--;
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

    @Override
    public E peek() throws QueueException {
        return first.item;
    }

    @Override
    public Iterator<E> iterator(){
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
