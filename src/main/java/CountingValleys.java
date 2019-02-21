import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int nivelMar = 0;
        int qtdVales = 0;

        for(int i = 0; i < n; i++){
            if('D' == s.charAt(i))
                nivelMar--;
            else if('U' == s.charAt(i)) {
                if(nivelMar == -1)
                    qtdVales++;
                nivelMar++;
            }
        }

        return qtdVales;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int result = countingValleys(8, "UDDDUDUU");
        System.out.println(result);
    }
}
