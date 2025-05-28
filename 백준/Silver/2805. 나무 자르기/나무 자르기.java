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
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        int low = 0;
        int high = 0;
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            nums[i] = input;
            high = Math.max(high, input);
        }

        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            long length = getLength(nums, mid);

            if (length >= m) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static long getLength(int[] nums, int height) {
        long sum = 0;
        for (int n : nums) {
            if (n > height) {
                sum += n - height;
            }
        }
        return sum;
    }

}