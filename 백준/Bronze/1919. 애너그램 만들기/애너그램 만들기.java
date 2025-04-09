import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] firstChars = reader.readLine().toCharArray();
        char[] secondChars = reader.readLine().toCharArray();
        int[] alphabet = new int[26];

        for (char firstChar : firstChars) {
            alphabet[firstChar - 'a'] += 1;
        }
        for (char secondChar : secondChars) {
            alphabet[secondChar - 'a'] -= 1;
        }

        int result = 0;
        for (int a : alphabet) {
            result += Math.abs(a);
        }
        System.out.println(result);
    }

}