package algorithms.implementation;

import algorithms.implementation.stack.StackAsLinkedList;
import algorithms.implementation.stack.StackException;
import algorithms.interfaces.Stack;

/**
 * Clasa pentru evaluarea expresiilor aritmetice in forma infixata
 * E.W. Dijkstra
 */
public final class ArithmeticExpresionEvaluation {
    private Stack<String> ops = new StackAsLinkedList<String>();
    private Stack<Double> nums = new StackAsLinkedList<Double>();
    private String expression;

    public ArithmeticExpresionEvaluation(){
        super();
    }

    public ArithmeticExpresionEvaluation(String expression){
        this.expression = expression;
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

    public static void main(String args[]) throws StackException{
        ArithmeticExpresionEvaluation arithmeticExpresionEvaluation = new ArithmeticExpresionEvaluation();
        arithmeticExpresionEvaluation.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
    }
}
