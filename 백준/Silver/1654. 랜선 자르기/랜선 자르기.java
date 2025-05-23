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
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] nums = new long[k];
        long low = 1;
        long high = 0;
        for (int i = 0; i < k; i++) {
            long input = Long.parseLong(reader.readLine());
            nums[i] = input;
            high = Math.max(high, input);
        }

        long result = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            long lenCableCount = getLenCableCount(nums, mid);

            if (lenCableCount >= n) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static long getLenCableCount(long[] nums, long height) {
        long sum = 0;
        for (long n : nums) {
            sum += n / height;
        }
        return sum;
    }

}