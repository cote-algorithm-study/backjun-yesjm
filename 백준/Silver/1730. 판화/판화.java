import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        char[] cmd = reader.readLine().toCharArray();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }

        int x = 0, y = 0;
        for (char c : cmd) {
            int nx = x, ny = y;
            switch (c) {
                case 'U':
                    nx = x - 1;
                    break;
                case 'D':
                    nx = x + 1;
                    break;
                case 'L':
                    ny = y - 1;
                    break;
                case 'R':
                    ny = y + 1;
                    break;
            }

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (c == 'U' || c == 'D') {
                grid[x][y] = (grid[x][y] == '-' || grid[x][y] == '+') ? '+' : '|';
                grid[nx][ny] = (grid[nx][ny] == '-' || grid[nx][ny] == '+') ? '+' : '|';
            } else {
                grid[x][y] = (grid[x][y] == '|' || grid[x][y] == '+') ? '+' : '-';
                grid[nx][ny] = (grid[nx][ny] == '|' || grid[nx][ny] == '+') ? '+' : '-';
            }

            x = nx;
            y = ny;
        }

        StringBuilder sb = new StringBuilder();
        for (char[] chars : grid) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}