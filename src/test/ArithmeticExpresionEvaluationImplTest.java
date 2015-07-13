package test;

import algorithms.implementation.ArithmeticExpresionEvaluationImpl;
import algorithms.implementation.stack.StackException;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

/**
 * Created by Madalin.Colezea on 7/13/2015.
 */
public class ArithmeticExpresionEvaluationImplTest {
    private ArithmeticExpresionEvaluationImpl arithmeticExpresionEvaluationImpl;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_operation() throws StackException{
        arithmeticExpresionEvaluationImpl = new ArithmeticExpresionEvaluationImpl();
        Assume.assumeTrue(arithmeticExpresionEvaluationImpl.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )") == 101.0);
        Assume.assumeTrue(arithmeticExpresionEvaluationImpl.evaluate("( 2 + 3 )") == 5);
        Assume.assumeTrue(arithmeticExpresionEvaluationImpl.evaluate("( 3 - 2 )") == 1);
        Assume.assumeTrue(arithmeticExpresionEvaluationImpl.evaluate("( 2 * 3 )") == 6);
        Assume.assumeTrue(arithmeticExpresionEvaluationImpl.evaluate("( 6 / 3 )") == 2);
    }

    @Test
    public void test_nu_such_element() throws StackException{
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("Expresie nespecificata");

        arithmeticExpresionEvaluationImpl = new ArithmeticExpresionEvaluationImpl();
        arithmeticExpresionEvaluationImpl.evaluate();
    }
}
