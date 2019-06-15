package cc.lastone.calculator.operator.impl;

import cc.lastone.calculator.operator.Operator;

import java.util.List;

public class Undo implements Operator {

    @Override
    public void calculate(List currentStack, List historyStack, int position, String operator) {
        // 获得上一个栈
        int size = historyStack.size();
        // 获得两个数字
        if (size < 1) {
            // 没有上一步，清楚数据
            currentStack.clear();
        } else {
            currentStack.clear();
            currentStack.addAll((List) historyStack.get(size - 1));
            historyStack.remove(size - 1);
        }
    }
}
