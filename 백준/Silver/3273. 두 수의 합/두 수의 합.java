import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x) {
                left++;
                right--;
                count++;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

}