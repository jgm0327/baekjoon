import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
    static int[][] board;
    static boolean[][] alreadyHere;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        alreadyHere = new boolean[n][n];
        System.out.println(dfs(0, 0, 0, 0));

        br.close();
    }

    static int dfs(int depth, int startY, int startX, int total){
        if(depth == 3){
            return total;
        }

        int ret = Integer.MAX_VALUE;
        for(int y = 0 ; y < n ; y++){
            for(int x = 0 ; x < n ; x++){
                int cost = cantPlant(y, x);
                if(alreadyHere[y][x] || cost == Integer.MAX_VALUE)
                    continue;

                int r;
                alreadyHere[y][x] = true;
                for(int i=0 ; i<4 ; i++){
                    int ny = y + dy[i], nx = x + dx[i];

                    alreadyHere[ny][nx] = true;
                }
                if(x == n - 1)
                    r = dfs(depth + 1, y + 1, 0, total + cost);
                else
                    r = dfs(depth + 1, y, x + 1, total + cost);

                alreadyHere[y][x] = false;
                for(int i=0 ; i<4 ; i++){
                    int ny = y + dy[i], nx = x + dx[i];

                    alreadyHere[ny][nx] = false;
                }

                ret = Math.min(ret, r);
            }
        }

        return Math.min(ret, Integer.MAX_VALUE);
    }

    static int cantPlant(int y, int x) {
        int total = board[y][x];

        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i], nx = x + dx[i];

            if(0 > ny || ny >= n || 0 > nx || nx >= n || alreadyHere[ny][nx])
                return Integer.MAX_VALUE;

            total += board[ny][nx];
        }
        return total;
    }
}
