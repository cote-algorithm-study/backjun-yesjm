import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int result = solution(reader);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int solution(BufferedReader reader) throws IOException {
        String[] s1 = reader.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);

        int[] row = new int[n];
        int[] column = new int[m];
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'X') {
                    row[i]++;
                    column[j]++;
                }
            }
        }

        int a = countZeros(row);
        int b = countZeros(column);

        return Math.max(a, b);
    }

    private static int countZeros(int[] arr) {
        int count = 0;
        for (int n : arr) {
            if (n == 0)
                count++;
        }
        return count;
    }

}