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
public class UndoTest {

    @Test
    public void testCalculate() {
        List<Double> currentStack = new ArrayList();
        List<List<Double>> historyStack = new ArrayList();
        List<Double> tempCurrentStack;
        try {
            String op = "undo";
            Operator operator = OperatorFactory.getOperator(op);

            // 第一步
            currentStack.add((double) 1);
            Assert.assertEquals((double) 1.0, (double) currentStack.get(currentStack.size() - 1), 0.0);

            // 第二步
            historyStack.add((List<Double>) ((ArrayList) currentStack).clone());
            currentStack.add((double) 2);
            Assert.assertEquals((double) 2.0, (double) currentStack.get(currentStack.size() - 1), 0.0);
            tempCurrentStack = historyStack.get(historyStack.size() - 1);
            Assert.assertEquals((double) 1.0, (double) tempCurrentStack.get(tempCurrentStack.size() - 1), 0.0);

            // 第三步
            historyStack.add((List<Double>) ((ArrayList) currentStack).clone());
            currentStack.add((double) 3);
            Assert.assertEquals((double) 3.0, (double) currentStack.get(currentStack.size() - 1), 0.0);
            tempCurrentStack = historyStack.get(historyStack.size() - 1);
            Assert.assertEquals((double) 2.0, (double) tempCurrentStack.get(tempCurrentStack.size() - 1), 0.0);

            // 退回到第二步
            operator.calculate(currentStack, historyStack, 0, op);
            Assert.assertEquals((double) 2.0, (double) currentStack.get(currentStack.size() - 1), 0.0);
            tempCurrentStack = historyStack.get(historyStack.size() - 1);
            Assert.assertEquals((double) 1.0, (double) tempCurrentStack.get(tempCurrentStack.size() - 1), 0.0);

        } catch (Exception e) {

        }
    }
}
