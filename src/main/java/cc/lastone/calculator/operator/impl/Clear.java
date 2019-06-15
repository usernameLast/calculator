package cc.lastone.calculator.operator.impl;

import cc.lastone.calculator.operator.Operator;

import java.util.List;

public class Clear implements Operator {

    @Override
    public void calculate(List currentStack, List historyStack, int position, String operator) {
        currentStack.clear();
        historyStack.clear();
    }
}
