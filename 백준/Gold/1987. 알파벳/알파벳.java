import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n, m, answer;
    private static char[][] board;
    private static final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        board = new char[n][m];
        for(int i=0 ; i<n ; i++){
            String str = br.readLine();
            for(int j=0 ; j<m ; j++){
                board[i][j] = str.charAt(j);
            }
        }

        answer = 0;
        dfs(1, 0, 0, 1 << (int)(board[0][0] - 'A'));

        System.out.println(answer);
    }

    public static void dfs(int depth, int y, int x, int path){

        answer = Math.max(depth, answer);
        
        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i], nx = x + dx[i];
            
            if(0 > ny || ny >= n || 0 > nx || nx >= m)
                continue;
            
            int bit = (int)(board[ny][nx] - 'A');

            if((path & (1 << bit)) == (1 << bit))
                continue;

            path |= (1 << bit);
            dfs(depth + 1, ny, nx, path);
            path &= ~(1 << bit);
        }
    }
}
