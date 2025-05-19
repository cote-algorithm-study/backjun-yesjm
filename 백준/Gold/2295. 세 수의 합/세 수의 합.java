import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(reader.readLine()));
        }
        Collections.sort(nums);

        // a + b 조합 생성
        Set<Integer> sum = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum.add(nums.get(i) + nums.get(j));
            }
        }

        // a + b = k - c
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int k = nums.get(i);
                int c = nums.get(j);
                if (sum.contains(k - c)) {
                    System.out.println(k);
                    return;
                }
            }
        }

    }

}