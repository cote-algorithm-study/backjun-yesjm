import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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
        HashMap<String, Integer> book = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            book.put(input, book.getOrDefault(input, 0) + 1);
        }

        String result = book.entrySet().stream()
            .max(Comparator
                     .comparing(Map.Entry<String, Integer>::getValue)
                     .thenComparing(Map.Entry::getKey, Comparator.reverseOrder())
            )
            .get()
            .getKey();

        System.out.println(result);
    }

}