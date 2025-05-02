import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
            int sum = 0;
            int min = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 7; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 == 0) {
                    sum += num;
                    if (num < min) {
                        min = num;
                    }
                }
            }
            System.out.printf("%d %d\n", sum, min);
        }
    }

}