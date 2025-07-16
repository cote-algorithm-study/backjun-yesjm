import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(nums);

        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;

        while (end < n) {
            int diff = nums[end] - nums[start];

            if (diff < m) {
                end++;
            } else {
                result = Math.min(result, diff);
                start++;
                if (start > end) {
                    end = start;
                }
            }
        }
        System.out.println(result);
    }

}