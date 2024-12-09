package recursion_lab12;

import org.junit.Test;
import static org.junit.Assert.*;

public class RecursiveExpressionParserTest {

    @Test
    public void testEvaluateSimpleExpression() {
        double result = RecursiveExpressionParser.evaluateExpression("3 + 5");
        assertEquals(8.0, result, 0.001);
    }

    @Test
    public void testEvaluateExpressionWithMultiplication() {
        double result = RecursiveExpressionParser.evaluateExpression("3 * 5 + 2");
        assertEquals(17.0, result, 0.001);
    }

    @Test
    public void testEvaluateExpressionWithDivision() {
        double result = RecursiveExpressionParser.evaluateExpression("10 / 2 - 3");
        assertEquals(2.0, result, 0.001);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testEvaluateInvalidExpression() {
        RecursiveExpressionParser.evaluateExpression("3 + * 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEvaluateDivisionByZero() {
        RecursiveExpressionParser.evaluateExpression("10 / 0");
    }
}
