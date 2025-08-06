import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int n, m, answer;
    static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = s.charAt(j);
        }

        dfs(0, 0, (1 << (board[0][0] - 'A')), 1);
        System.out.println(answer);

        br.close();
    }

    static void dfs(int y, int x, int visit, int depth) {
        answer = Math.max(answer, depth);

        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i], nx = x + dx[i];

            if(0 > ny || ny >= n || 0 > nx || nx >= m )
                continue;

            int idx = board[ny][nx] - 'A';
            if((visit & (1 << idx)) != 0)
                continue;

            dfs(ny, nx, visit | (1 << idx), depth + 1);
        }
    }
}