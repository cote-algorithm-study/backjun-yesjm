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
        int q = Integer.parseInt(st.nextToken());

        int[] xor = new int[n + 1];
        st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            xor[i] = xor[i - 1] ^ Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(reader.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            result ^= xor[e] ^ xor[s - 1];
        }

        System.out.println(result);
    }

}