package cc.lastone.calculator.operator;

import cc.lastone.calculator.operator.impl.*;

public class OperatorFactory {
    private final static Addition addition = new Addition();
    private final static Subtraction subtraction = new Subtraction();
    private final static Multiplication multiplication = new Multiplication();
    private final static Division division = new Division();
    private final static Sqrt sqrt = new Sqrt();
    private final static Undo undo = new Undo();
    private final static Clear clear = new Clear();

    public static Operator getOperator(String operator) throws Exception {
        switch (operator) {
            case "+":
                return addition;
            case "-":
                return subtraction;
            case "*":
                return multiplication;
            case "/":
                return division;
            case "sqrt":
                return sqrt;
            case "undo":
                return undo;
            case "clear":
                return clear;
        }
        // 操作符没有匹配
        throw new Exception("Illegal operators");
    }
}
