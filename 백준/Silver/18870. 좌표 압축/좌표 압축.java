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
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> point = new HashSet<>();
        for (int i = 0; i < n; i++) {
            point.add(input[i]);
        }
        List<Integer> sortedPoint = new ArrayList<>(point);
        Collections.sort(sortedPoint);

        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int sp : sortedPoint) {
            map.put(sp, index++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : input) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb);

    }

}