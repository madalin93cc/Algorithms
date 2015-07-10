package algorithms.implementation.stack;

import algorithms.interfaces.Stack;

/**
 * Created by Madalin.Colezea on 7/10/2015.
 */
public class StackAsLinkedList implements Stack {

    private Node first = null;
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
    public void push(String s) {
        Node oldfirst = first;
        first = new Node(s, oldfirst);
        N++;
    }

    @Override
    public String pop() throws StackException{
        if (isEmpty()) throw new StackException("stiva goala");
        String item  = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }
}
