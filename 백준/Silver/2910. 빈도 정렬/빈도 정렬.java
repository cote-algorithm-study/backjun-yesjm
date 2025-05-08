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
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        StringTokenizer input = new StringTokenizer(reader.readLine());

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            int count = entry.getValue();
            while (count-- > 0) {
                sb.append(entry.getKey()).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

}