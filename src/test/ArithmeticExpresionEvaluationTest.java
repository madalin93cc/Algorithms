package test;

import algorithms.implementation.ArithmeticExpresionEvaluation;
import algorithms.implementation.stack.StackException;
import org.junit.Assume;
import org.junit.Test;

/**
 * Created by Madalin.Colezea on 7/13/2015.
 */
public class ArithmeticExpresionEvaluationTest {
    private ArithmeticExpresionEvaluation arithmeticExpresionEvaluation;

    @Test
    public void test_operation() throws StackException{
        arithmeticExpresionEvaluation= new ArithmeticExpresionEvaluation();
        Assume.assumeTrue(arithmeticExpresionEvaluation.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )") == 101.0);
        Assume.assumeTrue(arithmeticExpresionEvaluation.evaluate("( 2 + 3 )") == 5);
        Assume.assumeTrue(arithmeticExpresionEvaluation.evaluate("( 3 - 2 )") == 1);
        Assume.assumeTrue(arithmeticExpresionEvaluation.evaluate("( 2 * 3 )") == 6);
        Assume.assumeTrue(arithmeticExpresionEvaluation.evaluate("( 6 / 3 )") == 2);
    }
}
