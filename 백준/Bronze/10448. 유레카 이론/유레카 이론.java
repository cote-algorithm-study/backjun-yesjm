import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            solution(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());

        List<Integer> triangular = new ArrayList<>();
        for (int i = 1; ; i++) {
            int t = i * (i + 1) / 2;
            if (t > 1000) {
                break;
            }
            triangular.add(t);
        }

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(reader.readLine());
            System.out.println(isEureka(triangular, k) ? 1 : 0);
        }
    }

    private static boolean isEureka(List<Integer> triangular, int k) {
        int size = triangular.size();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (int z = 0; z < size; z++) {
                    int sum = triangular.get(x) + triangular.get(y) + triangular.get(z);
                    if (sum == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}