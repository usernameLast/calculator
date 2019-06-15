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
public class DivisionTest {

    @Test
    public void testCalculate() {
        List<Double> currentStack = new ArrayList();
        try {
            String op = "/";
            Operator operator = OperatorFactory.getOperator(op);
            currentStack.add((double) 1);
            currentStack.add((double) 2);
            operator.calculate(currentStack, null, 0, op);
            Assert.assertEquals((double) 0.5, (double) currentStack.get(currentStack.size() - 1), 0.0);
        } catch (Exception e) {

        }
    }
}
