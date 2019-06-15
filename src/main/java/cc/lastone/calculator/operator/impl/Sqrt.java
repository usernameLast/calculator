package cc.lastone.calculator.operator.impl;

import cc.lastone.calculator.operator.Operator;
import cc.lastone.calculator.utils.OperatorWarning;

import java.util.ArrayList;
import java.util.List;

public class Sqrt implements Operator {

    @Override
    public void calculate(List currentStack, List historyStack, int position, String operator) throws Exception {
        int size = currentStack.size();
        // 获得一个数字
        if (size < 1) {
            throw new Exception(OperatorWarning.getWarning(position, operator));
        }
        Double d1 = (Double) currentStack.get(size - 1);
        // 添加历史栈信息
        // 添加历史栈信息
        historyStack.add(((ArrayList) currentStack).clone());
        // 生成新的栈
        currentStack.remove(size - 1);
        currentStack.add(Math.sqrt(d1));
    }
}
