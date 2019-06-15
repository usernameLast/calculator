package cc.lastone.calculator.operator.impl;

import java.util.List;

public class Addition extends BaseOperator {

    @Override
    public Double calculate(Double d1, Double d2, int position, String operator) {
        return d1 + d2;
    }
}
