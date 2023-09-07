import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String statusAnswer;
        do {
            //TODO 没结束前可以一直

            //TODO 需要创建三个实例吗？
            Scanner read1 = new Scanner(System.in);
            System.out.println("请输入第一个数：");
            //TODO 异常处理
            double numberOne = read1.nextDouble();

            Scanner read2 = new Scanner(System.in);
            System.out.println("请输入第二个数字");
            double numberTwo = read2.nextDouble();

            Scanner reade = new Scanner(System.in);
            System.out.println("请输入运算符");
            String reader = reade.next();

            char ch;
            ch = reader.charAt(0);
            switch (ch) {
                case '+':
                    System.out.println("计算结果是：" + (numberOne + numberTwo));
                    break;
                case '-':
                    System.out.println("计算结果是：" + (numberOne - numberTwo));
                    break;
                case '*':
                    System.out.println("计算结果是：" + (numberOne * numberTwo));
                    break;
                //TODO
                case '/':
                    if(numberTwo == 0) {
                        throw new ArithmeticException("/by zero");
                    }
                    System.out.println("计算结果是：" +  (numberOne / numberTwo));
                    break;
                //TODO 有这个需求吗
                default:
                    System.out.println("输入有误");
            }
            System.out.println("是否继续进行计算？ y/n");
            Scanner status = new Scanner(System.in);
            statusAnswer = status.next();
        } while (Objects.equals(statusAnswer, "y"));
    }
}