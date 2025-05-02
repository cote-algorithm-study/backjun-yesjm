
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            solution(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution(BufferedReader reader) throws IOException {
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(reader.readLine());
            boolean result = false;

            for (int j = 2; j <= 64; j++) {
                if (isPalindrome(nNumberSystem(num, j))) {
                    result = true;
                    break;
                }
            }

            System.out.println(result ? 1 : 0);
        }
    }

    private static String nNumberSystem(int n, int b) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % b < 10) {
                sb.append(n % b);
            } else {
                sb.append((char)(n % b - 10 + 'A'));
            }
            n /= b;
        }
        return sb.reverse().toString();
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}