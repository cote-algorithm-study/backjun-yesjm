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
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int num = Integer.parseInt(st.nextToken());

            int count = 0;
            int[] arr = new int[20];

            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int k = 0; k < 20; k++) {
                for (int l = 0; l < k; l++) {
                    if (arr[l] > arr[k]) {
                        count++;
                    }
                }
            }

            System.out.println(num + " " + count);
        }
    }

}