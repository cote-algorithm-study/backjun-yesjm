import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String result = solution(reader);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String solution(BufferedReader reader) throws IOException {
        String[] s1 = reader.readLine().split(" ");
        String[] s2 = reader.readLine().split(" ");
        int w = Integer.parseInt(s1[0]);
        int h = Integer.parseInt(s1[1]);
        int p = Integer.parseInt(s2[0]);
        int q = Integer.parseInt(s2[1]);
        int t = Integer.parseInt(reader.readLine());

        int x = (p + t) % (2 * w);
        int y = (q + t) % (2 * h);

        if (x > w) {
            x = (2 * w) - x;
        }
        if (y > h) {
            y = (2 * h) - y;
        }
        
        return String.format("%d %d", x, y);
    }

}