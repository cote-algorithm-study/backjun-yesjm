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
        int c = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(nums);

        int left = 1;
        int right = nums[n - 1] - nums[0];
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (getCount(nums, mid) >= c) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static int getCount(int[] nums, int distance) {
        int count = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= distance) {
                count++;
                last = nums[i];
            }
        }
        return count;
    }

}