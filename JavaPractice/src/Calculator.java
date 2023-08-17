import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double numberOne;
        double numberTwo;
        double result = 0;
        Scanner read1 = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        numberOne = read1.nextDouble();
        Scanner read2 = new Scanner(System.in);
        System.out.println("请输入第二个数字");
        numberTwo = read2.nextDouble();
        Scanner reade = new Scanner(System.in);
        System.out.println("请输入运算符");
        String reader = reade.next();
        char ch;
        ch = reader.charAt(0);
        switch (ch){
            case '+':
                result = numberOne + numberTwo;
                break;
            case '-':
                result = numberOne - numberTwo;
                break;
            case '*':
                result = numberOne * numberTwo;
                break;
            case '/':
                result = numberOne / numberTwo;
                break;
            case '%':
                result = numberOne % numberTwo;
                break;
            default:
                System.out.println("输入有误");
        }
        System.out.println("计算结果是：" + result);
    }
}