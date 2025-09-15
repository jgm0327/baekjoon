import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            n = Integer.parseInt(tokenizer.nextToken());
            m = Integer.parseInt(tokenizer.nextToken());

            if (n == 0 && m == 0)
                break;

            board = new int[n + 1][m + 1];
            boolean notExistOne = true;
            for (int i = 1; i <= n; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    board[i][j] = Integer.parseInt(tokenizer.nextToken());
                    if (board[i][j] == 1)
                        notExistOne = false;
                }
            }

            if (notExistOne) {
                answer.append("0\n");
                continue;
            }

            solution(answer);
        }

        System.out.println(answer);
        br.close();
    }

    static void solution(StringBuilder answer) {
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 0 || board[i][j - 1] == 0 || board[i - 1][j] == 0 || board[i - 1][j - 1] == 0)
                    continue;

                board[i][j] = Math.min(board[i - 1][j], Math.min(board[i - 1][j - 1], board[i][j - 1])) + 1;
                ret = Math.max(board[i][j], ret);
            }
        }

        answer.append(ret).append("\n");
    }
}
