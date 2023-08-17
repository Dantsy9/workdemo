import java.util.*;

/**
 * <p>
 * 列表练习
 * </p>
 *
 * @author zmc
 * @Since 2023-08-16
 */

public class ListPractice {
    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>();
        List<Integer> aList1 = new ArrayList<>();
        List<Integer> ListInteger = new ArrayList<>();
        Random r = new Random();
        //集合一添加随机元素
        for (int i = 0; i < 10; i++) {
            int a = r.nextInt(15);
            aList.add(a);
        }
        //集合二添加随机元素
        for (int i = 0; i < 10; i++) {
            int a = r.nextInt(15);
            aList1.add(a);
        }
//        遍历集合一和集合二，并把重复元素添加到集合三
        for (Integer integer : aList) {
            for (Integer value : aList1) {
                if (Objects.equals(integer, value)) {
                    ListInteger.add(value);
                }
            }
        }
        //遍历集合三，移除重复元素
        for (int i = 0;i<ListInteger.size();i++) {
            for (int j = ListInteger.size()-1; j > i  ; j--){
                if (Objects.equals(ListInteger.get(i),ListInteger.get(j))){
                    ListInteger.remove(j);
                }
            }
        }
        //输出集合三
        System.out.println(ListInteger);


//        ListInteger = new ArrayList<>(new HashSet<>(ListInteger));

    }
}
