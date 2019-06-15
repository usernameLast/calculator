package cc.lastone.calculator.operator.impl;

import cc.lastone.calculator.operator.Operator;
import cc.lastone.calculator.operator.OperatorFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Unit test for simple App.
 */
public class SqrtTest {

    @Test
    public void testCalculate() {
        List<Double> currentStack = new ArrayList();
        try {
            String op = "sqrt";
            Operator operator = OperatorFactory.getOperator(op);
            currentStack.add((double) 4);
            operator.calculate(currentStack, null, 0, op);
            Assert.assertEquals((double) 2.0, (double) currentStack.get(currentStack.size() - 1), 0.0);
        } catch (Exception e) {

        }
    }
}
