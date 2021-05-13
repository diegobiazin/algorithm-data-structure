import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> orderedList = new ArrayList<>();
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];

            Pattern pattern = Pattern.compile("@gmail.com");
            Matcher matcher = pattern.matcher(emailID);
            boolean matchFound = matcher.find();
            if (matchFound) {
                orderedList.add(firstName);
            }
        }

        String[] firstNameEmailID = scanner.nextLine().split(" ");
        Pattern pattern = Pattern.compile("@gmail.com");

        orderedList.stream().sorted().forEach(n -> {
            System.out.println(n);
        });

    }
}
