package cc.lastone.calculator;

import cc.lastone.calculator.operator.Operator;
import cc.lastone.calculator.operator.OperatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 当前栈数据
        List<Double> currentStack = new ArrayList();
        // 历史栈数据
        List<List<Double>> historyStack = new ArrayList();
        // 操作符
        Operator operator;
        // 从键盘接收数据
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to use Calculator");
        System.out.println("Please Enter spaces-separated numbers and operators");
        while (true) {
            if (scan.hasNextLine()) {
                String str = scan.nextLine();
                // 字符串所在位置
                int position = 0;
                String[] strArr = str.split(" ");
                for (String s : strArr) {
                    position++;
                    if (!s.isEmpty()) {
                        // 判断是否是数字还是操作符
                        if (isNumeric(s)) {
                            // 添加历史栈
                            historyStack.add((List<Double>) ((ArrayList) currentStack).clone());
                            // 是数字，添加到栈中
                            currentStack.add(Double.parseDouble(s));
                        } else {
                            // 不是数字，获得操作符
                            try {
                                operator = OperatorFactory.getOperator(s);
                                operator.calculate(currentStack, historyStack, position, s.toLowerCase());
                            } catch (Exception e) {
                                // 操作符不存在
                                System.out.println(e.getMessage());
                                break;
                            }
                        }
                    }
                    position += s.length();
                }
                // 操作结束，打印出stack
                printlnStack(currentStack);
                //System.out.println("stack:" + currentStack);
                //System.out.println("historyStack:" + historyStack);
            }
            //scan.close();
        }
    }

    /**
     * 判断输入的值是否为数字
     *
     * @param str String
     * @return boolean
     */
    public static boolean isNumeric(String str) {
        return str.matches("-?[0-9]+.?[0-9]*");
    }

    public static void printlnStack(List<Double> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append("stack:");
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            double d = stack.get(i);
            // 判断是否是整数
            if (d % 1 == 0) {
                // 整数
                sb.append((int) d);
            } else {
                // 小数,判断精度
                String moneyStr = String.valueOf(d);
                String[] num = moneyStr.split("\\.");
                if (num.length == 2) {
                    int j = num[1].length() > 10 ? 10 : num[1].length();
                    sb.append(String.format("%." + j + "f", d));
                }
            }
        }
        System.out.println(sb);
    }
}
