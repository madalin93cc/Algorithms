package algorithms.implementation.stack;

import algorithms.interfaces.Stack;
import algorithms.interfaces.StackMinMax;

import java.util.Iterator;

/**
 * Created by Colezea on 25/07/2015.
 */
public class StackMinMaxImpl implements StackMinMax<Integer> {

    Stack<Integer> stack, mins, maxs;

    public StackMinMaxImpl() {
        stack = new StackAsArray<Integer>();
        mins = new StackAsArray<Integer>();
        maxs = new StackAsArray<Integer>();
    }

    @Override
    public void push(Integer s) throws StackException {
        stack.push(s);
        if (stack.size() == 1){
            mins.push(s);
            maxs.push(s);
            return;
        }
        if (s.compareTo(maxs.peek()) > 0){
            maxs.push(s);
        }
        if (s.compareTo(mins.peek()) < 0){
            mins.push(s);
        }
    }

    @Override
    public Integer pop() throws StackException {
        Integer elem = stack.pop();
        if (elem.compareTo(maxs.peek()) == 0){
            maxs.pop();
        }
        if (elem.compareTo(mins.peek()) == 0){
            mins.pop();
        }
        return elem;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public Integer peek() throws StackException {
        return stack.peek();
    }

    @Override
    public Integer min() throws StackException{
        return mins.peek();
    }

    @Override
    public Integer max() throws StackException{
        return maxs.peek();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return stack.iterator();
    }
}
