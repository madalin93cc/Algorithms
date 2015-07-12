package algorithms.implementation.stack;

import algorithms.interfaces.Stack;

/**
 * Implementare de stiva folosing linked list
 * + fiecare operatie dureaza timp constant in cel mai rau caz
 * - foloseste timp suplimentar si spatiu pentru legaturi
 * + fiecare operatie are garantia vitezei constante fata de array implementation
 * resize() apelat doar cand dimensiunea stivei este o putere a lui 2
 */
public class StackAsLinkedList<E> implements Stack<E> {

    private Node first = null;
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
    public void push(E s) {
        Node oldfirst = first;
        first = new Node(s, oldfirst);
        N++;
    }

    @Override
    public E pop() throws StackException{
        if (isEmpty()) throw new StackException("stiva goala");
        E item  = first.item;
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
