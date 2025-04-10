import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int result = solution(reader);
            System.out.println(result);
        }
    }

    private static int solution(BufferedReader reader) throws IOException {
        String s1 = reader.readLine();
        String s2 = reader.readLine();

        int i = 0;
        int count = 0;
        while (i <= s1.length()) {
            int foundIndex = s1.indexOf(s2, i);
            if (foundIndex != -1) {
                i = foundIndex + s2.length();
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    
}