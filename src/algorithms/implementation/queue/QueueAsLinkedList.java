package algorithms.implementation.queue;

import algorithms.interfaces.Queue;

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

        Node(E item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public void enqueue(E s) {
        Node oldlast = last;
        last = new Node(s, oldlast);
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
}
