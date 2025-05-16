import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> s = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s.put(reader.readLine(), true);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String search = reader.readLine();
            if (s.getOrDefault(search, false)) {
                count++;
            }
        }

        System.out.println(count);
    }

}