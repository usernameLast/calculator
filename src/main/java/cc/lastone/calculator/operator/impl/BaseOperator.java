package cc.lastone.calculator.operator.impl;

import cc.lastone.calculator.operator.Operator;
import cc.lastone.calculator.utils.OperatorWarning;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseOperator implements Operator {
    @Override
    public void calculate(List currentStack, List historyStack, int position, String operator) throws Exception {
        int size = currentStack.size();
        // 获得两个数字
        if (size < 2) {
            throw new Exception(OperatorWarning.getWarning(position, operator));
        }
        Double d1 = (Double) currentStack.get(size - 2);
        Double d2 = (Double) currentStack.get(size - 1);
        // 添加历史栈信息
        historyStack.add(((ArrayList) currentStack).clone());
        // 生成新的栈
        currentStack.remove(size - 1);
        currentStack.remove(size - 2);
        Double resultCalculate = this.calculate(d1, d2, position, operator);
        if (resultCalculate != null) {
            currentStack.add(resultCalculate);
        }
    }

    public Double calculate(Double d1, Double d2, int position, String operator) throws Exception {
        return null;
    }
}
