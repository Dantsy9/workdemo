import java.util.*;

/**
 * <p>
 * map练习
 * </p>
 *
 * @author zmc
 * @Since 2023-08-16
 */

public class MapPractice {
    public static void main(String[] args) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        Map<Integer,Integer> map = new HashMap<>();
        Random r = new Random();
        Integer a = 0;
        for (int i = 0; i < 10; i++) {
            map1.put(i, r.nextInt(10));
        }
        for (int i = 0; i < 10; i++) {
            map2.put(i, r.nextInt(10));
        }

        for (Map.Entry<Integer,Integer> entry : map1.entrySet()) {
            Integer value = entry.getValue();
            if (map2.containsValue(value)){
                map.put(a,value);
                a++;
            }
        }

        Map<Integer,Integer> newmap = new HashMap<>();
        //用map的foreach方法结合lambda表达式把去重后的map放到newMap中
        map.forEach((k,v)->{
                    if (!newmap.containsValue(v)){
                        newmap.put(k,v);
                    }
                });
        System.out.println(newmap);
    }
}
