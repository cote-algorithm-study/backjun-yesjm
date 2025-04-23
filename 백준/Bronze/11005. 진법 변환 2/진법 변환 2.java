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
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % b < 10) {
                sb.append(n % b);
            } else {
                sb.append((char)(n % b - 10 + 'A')); // 나머지가 10 이면 'A' + 10 이 아니라 'A'로 나타내야 함 (기존 숫자 10진법)
            }
            n /= b;
        }

        System.out.println(sb.reverse());
    }

}