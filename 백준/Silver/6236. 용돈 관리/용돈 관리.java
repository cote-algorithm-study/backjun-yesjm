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
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(reader.readLine());
            nums[i] = input;
            max = Math.max(max, input);
            sum += input;
        }

        int result = 0;
        while (max <= sum) {
            int mid = (sum + max) / 2;

            if (getCount(nums, mid) <= m) {
                result = mid;
                sum = mid - 1;
            } else {
                max = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static int getCount(int[] nums, int limit) {
        int count = 1;
        int balance = limit;
        for (int n : nums) {
            if (balance < n) {
                count++;
                balance = limit;
            }
            balance -= n;
        }
        return count;
    }

}