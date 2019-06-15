package cc.lastone.calculator.operator.impl;


import cc.lastone.calculator.utils.OperatorWarning;

public class Division extends BaseOperator {

    @Override
    public Double calculate(Double d1, Double d2, int position, String operator) throws Exception {
        if (d2 == 0) {
            throw new Exception(OperatorWarning.getWarning(position, operator));
        }
        return d1 / d2;
    }
}
