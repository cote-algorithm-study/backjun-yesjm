import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        char[][] board = new char[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            String input = new StringTokenizer(reader.readLine()).nextToken();
            for (int j = 1; j <= m; j++) {
                board[i][j] = input.charAt(j - 1);
            }
        }

        for (int time = 0; time < t; time++) {
            int[][] sum = prefixSum(board, n, m);

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int x1 = Math.max(1, i - k);
                    int y1 = Math.max(1, j - k);
                    int x2 = Math.min(n, i + k);
                    int y2 = Math.min(m, j + k);

                    int value = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
                    if (board[i][j] == '*') {
                        value--; // 본인 제외
                    }
                    if (board[i][j] == '*') {
                        if (value < a || value > b) {
                            board[i][j] = '.';
                        } else {
                            board[i][j] = '*';
                        }
                    } else {
                        if (value > a && value <= b) {
                            board[i][j] = '*';
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] prefixSum(char[][] board, int n, int m) {
        int[][] sum = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                if (board[i][j] == '*') {
                    sum[i][j]++;
                }
            }
        }
        return sum;
    }

}