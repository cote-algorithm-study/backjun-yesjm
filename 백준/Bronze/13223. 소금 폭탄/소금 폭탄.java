import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String result = solution(reader);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String solution(BufferedReader reader) throws IOException {
        String[] s1 = reader.readLine().split(":");
        String[] s2 = reader.readLine().split(":");

        int currentTime = Integer.parseInt(s1[0]) * 3600 + Integer.parseInt(s1[1]) * 60 + Integer.parseInt(s1[2]);
        int saltTime = Integer.parseInt(s2[0]) * 3600 + Integer.parseInt(s2[1]) * 60 + Integer.parseInt(s2[2]);

        int difference = saltTime - currentTime;
        if (difference <= 0) {
            difference += 24 * 3600;
        }
        
        int hh = difference / 3600;
        int mm = (difference % 3600) / 60;
        int ss = difference % 60;

        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }

}