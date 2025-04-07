import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        char[] chars = input.toCharArray();
        StringBuilder answer = new StringBuilder();

        for (char a : chars) {
            char b;
            if (Character.isLowerCase(a)) {
                b = Character.toUpperCase(a);
            } else {
                b = Character.toLowerCase(a);
            }
            answer.append(b);
        }

        System.out.println(answer);
    }

}