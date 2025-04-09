import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char result = solution(reader);
            System.out.println(result);
        }
    }

    private static char solution(BufferedReader reader) throws IOException {
        String s1 = reader.readLine().toUpperCase();
        int[] alphabet = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alphabet[s1.charAt(i) - 'A']++;
        }

        int max = -1;
        char result = '?';
        boolean duplicate = false;
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                result = (char)(i + 'A');
                duplicate = false;
            } else if (alphabet[i] == max) {
                duplicate = true;
            }
        }
        return duplicate ? '?' : result;
    }
}