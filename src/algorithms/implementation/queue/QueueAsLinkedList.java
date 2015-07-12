package algorithms.implementation.queue;

import algorithms.interfaces.Queue;

/**
 * Coada implementata ca linked list
 * enq si deq liniare
 */
public class QueueAsLinkedList implements Queue {

    private Node first, last;
    private int N = 0;

    private class Node{
        String item;
        Node next;

        Node(String item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public void enqueue(String s) {
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
    public String dequeue() throws QueueException{
        if (N == 0) throw new QueueException("coada goala");
        String item = first.item;
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
