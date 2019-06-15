package cc.lastone.calculator.operator;

import java.util.List;

public interface Operator {
    void calculate(List currentStack, List historyStack, int position, String operator) throws Exception;
}
