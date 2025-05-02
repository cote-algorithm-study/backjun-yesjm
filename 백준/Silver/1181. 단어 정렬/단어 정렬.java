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
        Set<String> setWords = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            setWords.add(input);
        }
        List<String> words = new ArrayList<>(setWords);
        words.sort(Comparator.comparing(String::length).thenComparing(w -> w));

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }

}