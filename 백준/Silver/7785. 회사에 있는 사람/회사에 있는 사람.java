import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

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
        TreeSet<String> worker = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            if (input[1].equals("enter")) {
                worker.add(input[0]);
            } else {
                worker.remove(input[0]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String word : worker) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }

}