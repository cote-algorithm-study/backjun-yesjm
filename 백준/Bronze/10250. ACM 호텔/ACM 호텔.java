import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(reader.readLine());
            for (int i = 0; i < t; i++) {
                System.out.println(solution(reader));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String solution(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int floor = n % h == 0 ? h : n % h;
        int room = (n - 1) / h + 1;
        return String.format("%d%02d", floor, room);
    }

}