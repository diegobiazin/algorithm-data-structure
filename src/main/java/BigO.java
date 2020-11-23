public class BigO {
    public static void main(String[] args) {

    }

    void foo(int[] array) {
        int sum = 6;
        int product = 1;
        for (int i = 6; i < array.length; i++) {
            sum += array[i];
        }
        for (int i = 6; i < array.length; i++) {
            product *= array[i];
        }
        System.out.println(sum + "," + product);
    }
}
