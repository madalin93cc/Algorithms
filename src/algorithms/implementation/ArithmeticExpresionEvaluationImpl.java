package algorithms.implementation;

import algorithms.implementation.stack.StackAsLinkedList;
import algorithms.implementation.stack.StackException;
import algorithms.interfaces.ArithmeticalExpresionEvaluation;
import algorithms.interfaces.Stack;

import java.util.NoSuchElementException;

/**
 * Clasa pentru evaluarea expresiilor aritmetice in forma infixata
 * E.W. Dijkstra
 */
public final class ArithmeticExpresionEvaluationImpl implements ArithmeticalExpresionEvaluation {
    private Stack<String> ops = new StackAsLinkedList<String>();
    private Stack<Double> nums = new StackAsLinkedList<Double>();
    private String expression;

    public ArithmeticExpresionEvaluationImpl(){
        super();
    }

    public ArithmeticExpresionEvaluationImpl(String expression){
        this.expression = expression;
    }

    public Double evaluate() throws StackException{
        if (this.expression == null) throw new NoSuchElementException("Expresie nespecificata");
        return evaluate(this.expression);
    }

    public Double evaluate(String expression) throws StackException{
        String[] strings = expression.split(" ");
        for (String s:strings){
            if (s.equals("("));
            else if ((s.equals("+")) || (s.equals("-")) || (s.equals("*")) || (s.equals("/"))){
                ops.push(s);
            }
            else if (s.equals(")")){
                String op = ops.pop();
                if(op.equals("+")){
                    nums.push(nums.pop() + nums.pop());
                }
                else if(op.equals("-")){
                    Double d = nums.pop();
                    nums.push(nums.pop() - d);
                }
                else if(op.equals("*")){
                    nums.push(nums.pop() * nums.pop());
                }
                else if(op.equals("/")){
                    Double d = nums.pop();
                    nums.push(nums.pop() / d);
                }
            }
            else {
                nums.push(Double.parseDouble(s));
            }
        }
        return nums.pop();
    }
}
