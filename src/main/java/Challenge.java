import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge {

    public static void main(String[] args) {
        Number number = new Numero();
        number.dunha();
//        List<Integer> points = Arrays.asList(4 ,5 , 1, 2, 3, 4, 5);
        List<Integer> points = Arrays.asList(3, 1, 2, 3);
        int qt = points.size();
        int t = 4;
        int result = 0;
        points.sort(Comparator.comparingInt(Integer::intValue));
        HashSet<Integer> ordenedPoints = new HashSet<>(points);//.stream().filter( p -> p % 2 > 0 );
        List<Integer> impares = ordenedPoints.stream().filter(p -> p % 2 > 0).collect(Collectors.toList());
        if ((impares.get(impares.size()-1) - 1) >= 4)
            System.out.println(impares.size());

        System.out.println(ordenedPoints.size());
    }

    static String findNumber(int l, int r) {
        if (l % 2 == 0)
            System.out.println("Par");
        else
            System.out.println("Par");
        return null;
    }

    static abstract class Number {
        abstract void dunha();
    }

    static class Numero extends Number {

        @Override
        void dunha() {
            System.out.println("test");
        }
    }
}
