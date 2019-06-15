package cc.lastone.calculator.operator.impl;


public class Multiplication extends BaseOperator {

    @Override
    public Double calculate(Double d1, Double d2, int position, String operator) {
        return d1 * d2;
    }
}
