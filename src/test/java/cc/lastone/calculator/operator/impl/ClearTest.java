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
public class ClearTest {

    @Test
    public void testCalculate() {
        List<Double> currentStack = new ArrayList();
        List<List<Double>> historyStack = new ArrayList();
        try {
            String op = "clear";
            Operator operator = OperatorFactory.getOperator(op);
            currentStack.add((double) 1);
            currentStack.add((double) 2);
            historyStack.add(currentStack);
            Assert.assertEquals(2, currentStack.size());
            Assert.assertEquals(1, historyStack.size());
            operator.calculate(currentStack, historyStack, 0, op);
            Assert.assertEquals(0, currentStack.size());
            Assert.assertEquals(0, historyStack.size());
        } catch (Exception e) {

        }
    }
}
