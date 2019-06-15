package cc.lastone.calculator.utils;

public class OperatorWarning {
    public static String getWarning(int position, String operator) {
        return "operator " + operator + " (position:" + position + "):insufficient paramters";
    }
}
