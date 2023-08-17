import java.util.*;

/**
 * <p>
 * 数组练习
 * </p>
 *
 * @author zmc
 * @Since 2023-08-15
 */

public class ArrayPractice {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int[] array = new int[10];
        int counter = 0;
        Random r = new Random();
        //数组一添加随机元素
        for (int i = 0; i < 10; i++) {
            int a = r.nextInt(20);
            array1[i] = a;
        }
        //数组二添加随机元素
        for (int i = 0; i < 10; i++) {
            int a = r.nextInt(20);
            array2[i] = a;
        }
        //数组一和数组二遍历，提取出重复元素放置到数组三
        for (int value : array1) {
            for (int k : array2) {
                if (value == k) {
                    array[counter] = value;
                    counter++;
                }
            }
        }
        //遍历数组三，将重复的元素为0
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length-1; j > i; j--) {
                if (array[i] == array[j]){
                    array[j] = 0;
                }
            }
        }
        //输出非0的元素
        for (int i = 0; i < 10; i++) {
            if (!(array[i] == 0)){
                System.out.println(array[i]);
            }
        }
    }
}

