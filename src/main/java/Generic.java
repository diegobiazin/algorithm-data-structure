import java.util.ArrayList;

public class Generic <T> {

    public void printArray(T[] arrayList) {
        for (T i : arrayList) {
            System.out.print(i+"\n");
        }
    }
}
